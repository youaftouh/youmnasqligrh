package ma.ensao.youmna.controller;

import java.util.List;

import ma.ensao.youmna.model.Collaborateur;
import ma.ensao.youmna.model.Competence;
import ma.ensao.youmna.model.Compte;
import ma.ensao.youmna.model.Diplome;
import ma.ensao.youmna.model.Technologie;
import ma.ensao.youmna.service.CollaborateurService;
import ma.ensao.youmna.service.CompetenceService;
import ma.ensao.youmna.service.CompteService;
import ma.ensao.youmna.service.DiplomeService;
import ma.ensao.youmna.service.SecurityContextAccessor;
import ma.ensao.youmna.service.TechnologieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.googlecode.charts4j.AxisLabels;
import com.googlecode.charts4j.AxisLabelsFactory;
import com.googlecode.charts4j.AxisStyle;
import com.googlecode.charts4j.AxisTextAlignment;
import com.googlecode.charts4j.Color;
import com.googlecode.charts4j.Data;
import com.googlecode.charts4j.GCharts;
import com.googlecode.charts4j.LineChart;
import com.googlecode.charts4j.PieChart;
import com.googlecode.charts4j.Plot;
import com.googlecode.charts4j.Plots;
import com.googlecode.charts4j.Slice;

@Controller
public class MainController {

	@Autowired
	SecurityContextAccessor securityContextAccessor;

	@Autowired
	private CollaborateurService collaborateurService;

	@Autowired
	private DiplomeService diplomeService;

	@Autowired
	private TechnologieService technologieService;

	@Autowired
	private CompetenceService competenceService;
	
	@Autowired
	private CompteService compteService;

	private String main;
	
	private String welcome;
	

	/**
	 * @param welcome the welcome to set
	 */
	public void setWelcome(String welcome) {
		this.welcome = welcome;
	}

	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
	}

	@RequestMapping("index")
	public ModelAndView main() {
		return new ModelAndView(main);
	}

	@RequestMapping(value = { "/", "login" })
	public ModelAndView root() {
		if (securityContextAccessor.isCurrentAuthenticationAnonymous()) {
			return new ModelAndView("login");
		} else {
			return new ModelAndView("redirect:" + main);
		}
	}

	@RequestMapping("adminManagers")
	public ModelAndView managers() {
		return new ModelAndView("admin_managers");
	}

	//Show all collaborators
	@RequestMapping(value = "collaborators", method = RequestMethod.GET)
	public ModelAndView collaborators() {
		ModelAndView mav = new ModelAndView("collaborators");  
		  //List<Collaborateur> collaborateur = collaborateurService.getAllCollaborateurs();  
		  //mav.addObject("newCollab", new Collaborateur());		  
		 // mav.addObject("listCollab", collaborateur);
		  mav.addObject("VIEW", "show");
		return mav;
	}
	
	//Redirecting to form newCollab
	@RequestMapping(value = "newColaborateur", method = RequestMethod.GET)
	public ModelAndView newcollaborators() {
		  ModelAndView mav = new ModelAndView("collaborators");
		 mav.addObject("newCollab", new Collaborateur());		  
		  mav.addObject("VIEW", "new");		  
		return mav;
	}
	
	//Update collab & redirecting to show all collab
	@RequestMapping(value = "updateCollab", method = RequestMethod.GET)
	 public ModelAndView edit(@RequestParam("COLLAB_ID")String COLLAB_ID) {
		 ModelAndView mav = new ModelAndView("collaborators");  
		  Collaborateur collaborateur = collaborateurService.getCollaborateurById(COLLAB_ID);  
		  mav.addObject("editCollab", collaborateur);
		  mav.addObject("VIEW", "edit");		 
		return mav;
	}
	
	 //Update collab
	 @RequestMapping(value="updateCollab", method=RequestMethod.POST)  
	 public ModelAndView update(@ModelAttribute("editCollab") Collaborateur collaborateur)  
	 {  
	ModelAndView mav = new ModelAndView("collaborators");
	  collaborateurService.updateCollaborateur(collaborateur); 
	  mav.addObject("VIEW","view");
	  return mav;  
	 } 
	 
	 //view collab
		@RequestMapping(value = "viewCollab", method = RequestMethod.GET)
		 public ModelAndView view(@RequestParam("COLLAB_ID")String COLLAB_ID) {
			 ModelAndView mav = new ModelAndView("collaborators");  
			  Collaborateur collaborateur = collaborateurService.getCollaborateurById(COLLAB_ID);  
			  mav.addObject("viewCollab", collaborateur);
			  mav.addObject("VIEW", "view");		 
			return mav;
		}
		
		 
		 @RequestMapping(value="deleteCollab", method=RequestMethod.POST)  
		 public ModelAndView delete(@ModelAttribute("editCollab") Collaborateur collaborateur)  
		 {  
		  return null;  
		 } 

	@RequestMapping(value = "collaborators", method = RequestMethod.POST)
	public ModelAndView saveCollaborator(@ModelAttribute("newCollab") Collaborateur collaborateur) {
		System.out.println(collaborateur.getNom());
		// saving a new account
		Compte compte=collaborateur.getCompte();
		compteService.createCompte(compte);
		
		// saving a new collaborator
		collaborateurService.createCollaborateur(collaborateur);
		
		// saving all diplomes related to this collaborator
		List<Diplome> diplomes = collaborateur.getDIPLOME();
		Diplome dip = null;
		if (diplomes != null) {
			for (Diplome diplome : diplomes) {
				dip = diplome;
				diplomeService.saveDiplome(dip);
			}
		}
		
		// saving all technologies related to this collaborator
		List<Technologie> technologies = collaborateur.getTECHNOLOGIE();
		Technologie tech = null;
		if (technologies != null) {
			for (Technologie technologie : technologies) {
				tech = technologie;
				tech.setCollaborateur(collaborateur);
				technologieService.saveTechnologie(tech);
				// saving all competences related to this technology
				List<Competence> competences = collaborateur.getCOMPETENCE();
				Competence comp = null;
				if (competences != null) {
					for (Competence competence : competences) {
						comp = competence;
						comp.setTechnologie(tech);
						competenceService.saveCompetence(comp);
					}
				}

			}
				String to=collaborateur.getCompte().getEmail();
				compteService.sendMessage(to, welcome, welcome);

	}

		return new ModelAndView("collaborators");
	}

	@RequestMapping("reporting")
	public ModelAndView reporting() {
		//Salaire
        Plot plot = Plots.newPlot(Data.newData(0, 66.6, 33.3, 100));
        LineChart chart = GCharts.newLineChart(plot);
        chart.addYAxisLabels(AxisLabelsFactory.newNumericAxisLabels(0,33.3,66.6,100));
        chart.addXAxisLabels(AxisLabelsFactory.newNumericAxisLabels(0,33.3,66.6,100));
        chart.setSize(400, 200);
        AxisStyle axisStyle = AxisStyle.newAxisStyle(Color.BLACK, 13, AxisTextAlignment.CENTER);
        AxisLabels score = AxisLabelsFactory.newAxisLabels("Salaire", 50.0);
        score.setAxisStyle(axisStyle);
        AxisLabels year = AxisLabelsFactory.newAxisLabels("Year", 50.0);
        year.setAxisStyle(axisStyle);
        chart.addYAxisLabels(score);
        chart.addXAxisLabels(year);
        
        //Poste
        Plot plot2 = Plots.newPlot(Data.newData(0, 66.6, 33.3, 100));
        LineChart chart2 = GCharts.newLineChart(plot);
        chart2.addYAxisLabels(AxisLabelsFactory.newNumericAxisLabels(0,33.3,66.6,100));
        chart2.addXAxisLabels(AxisLabelsFactory.newNumericAxisLabels(0,33.3,66.6,100));
        chart2.setSize(400, 200);
        AxisStyle axisStyle2 = AxisStyle.newAxisStyle(Color.BLACK, 13, AxisTextAlignment.CENTER);
        AxisLabels score2 = AxisLabelsFactory.newAxisLabels("Poste", 50.0);
        score2.setAxisStyle(axisStyle2);
        AxisLabels year2 = AxisLabelsFactory.newAxisLabels("Year", 50.0);
        year2.setAxisStyle(axisStyle);
        chart2.addYAxisLabels(score);
        chart2.addXAxisLabels(year);
        
        //Ratio
        Slice s1 = Slice.newSlice(70, Color.newColor("CACACA"), "Masculin", "Masculin");
        Slice s2 = Slice.newSlice(30, Color.newColor("DF7417"), "Feminin", "Feminin");

        PieChart chartpi = GCharts.newPieChart(s1, s2);
        chartpi.setTitle("Ratio Feminin Masculin", Color.BLACK, 16);
        chartpi.setSize(500, 200);
        chartpi.setThreeD(true);
        
        ModelAndView mav=new ModelAndView("reporting");
        mav.addObject("chartSalaireUrl", chart.toURLString());
        mav.addObject("chartPosteUrl", chart2.toURLString());
        mav.addObject("chartRatioUrl", chartpi.toURLString());
		return mav;
	}

	@RequestMapping("administration")
	public ModelAndView administration() {
		return new ModelAndView("administration");
	}

	@RequestMapping("account")
	public ModelAndView account() {
		return new ModelAndView("account");
	}
	
	@RequestMapping(value = "/export", method = RequestMethod.GET)
	public ModelAndView getExcel() {
		ModelAndView mav=new ModelAndView("ExportExcel");
		List<Collaborateur> collabList = collaborateurService.getAllCollaborateurs();
		List<Competence> competList= competenceService.getAll() ;
		List<Compte> compteList= compteService.getAll() ;
		List<Technologie> techList= technologieService.getAll() ;
		List<Diplome> dipList= diplomeService.getAll() ;
		
		mav.addObject("collabList",collabList);
		mav.addObject("competList",competList);
		mav.addObject("compteList",compteList);
		mav.addObject("techList",techList);
		mav.addObject("dipList",dipList);
		return new ModelAndView("ExportExcel");
	}
}