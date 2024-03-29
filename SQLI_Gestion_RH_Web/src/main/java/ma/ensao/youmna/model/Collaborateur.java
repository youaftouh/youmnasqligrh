package ma.ensao.youmna.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 
 * Modèle Collaborateur
 *
 */
@Entity
@Table(name = "collaborateur")
public class Collaborateur {
	
	@Id
	@Column(name = "matricule", nullable = false)
	private String matricule;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "prenom")
	private String prenom;
	
	@Column(name = "abreviation", nullable = false)
	private String abreviation;
	
	@Column(name = "mgrh_ancien",nullable = true)
	private String mgrhAncien;
	
	@Column(name = "mgrh_actuel",nullable = true)
	private String mgrhActuel;
	
	@Column(name = "sexe")
	private Character sexe;
	
	@Column(name = "site")
	private String site;
	
	@Column(name = "bu")
	private String bu;
	
	@Column(name = "date_embauche")
	private String dateEmbauche;
	
	@Column(name = "mois_bap")
	private String moisBap;
	
	@Column(name = "date_depart",nullable = true)
	private String dateDepart;
	
	@Column(name = "ancien_coll",nullable = true)
	private Boolean ancienColl;
	
	@Column(name = "participe_si",nullable = true)
	private Boolean participeSi;
	
	@Column(name = "date_si",nullable = true)
	private String dateSi;
	
	@Column(name = "poste_actuel3", nullable = false)
	private String posteActuel3;
	
	@Column(name = "poste_actuel4", nullable = false)
	private String posteActuel4;
	
	@Column(name = "salaire_actuel", nullable = true)
	private Double salaireActuel;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Compte compte;
	
	@Column(name="role")
	private String role;
	
	@Transient
	private List<Diplome> DIPLOME;
	@Transient
	private List<Technologie> TECHNOLOGIE;
	@Transient
	private List<Competence> COMPETENCE;
	
	
	Boolean status;
	
	/**
	 * @return the status
	 */
	public Boolean getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}
	/**
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}
	/**
	 * @param matricule the matricule to set
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * @return the abreviation
	 */
	public String getAbreviation() {
		return abreviation;
	}
	/**
	 * @param abreviation the abreviation to set
	 */
	public void setAbreviation(String abreviation) {
		this.abreviation = abreviation;
	}
	/**
	 * @return the mgrhAncien
	 */
	public String getMgrhAncien() {
		return mgrhAncien;
	}
	/**
	 * @param mgrhAncien the mgrhAncien to set
	 */
	public void setMgrhAncien(String mgrhAncien) {
		this.mgrhAncien = mgrhAncien;
	}
	/**
	 * @return the mgrhActuel
	 */
	public String getMgrhActuel() {
		return mgrhActuel;
	}
	/**
	 * @param mgrhActuel the mgrhActuel to set
	 */
	public void setMgrhActuel(String mgrhActuel) {
		this.mgrhActuel = mgrhActuel;
	}
	/**
	 * @return the sexe
	 */
	public Character getSexe() {
		return sexe;
	}
	/**
	 * @param sexe the sexe to set
	 */
	public void setSexe(Character sexe) {
		this.sexe = sexe;
	}
	/**
	 * @return the site
	 */
	public String getSite() {
		return site;
	}
	/**
	 * @param site the site to set
	 */
	public void setSite(String site) {
		this.site = site;
	}
	/**
	 * @return the bu
	 */
	public String getBu() {
		return bu;
	}
	/**
	 * @param bu the bu to set
	 */
	public void setBu(String bu) {
		this.bu = bu;
	}
	/**
	 * @return the dateEmbauche
	 */
	public String getDateEmbauche() {
		return dateEmbauche;
	}
	/**
	 * @param dateEmbauche the dateEmbauche to set
	 */
	public void setDateEmbauche(String dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}
	/**
	 * @return the moisBap
	 */
	public String getMoisBap() {
		return moisBap;
	}
	/**
	 * @param moisBap the moisBap to set
	 */
	public void setMoisBap(String moisBap) {
		this.moisBap = moisBap;
	}
	/**
	 * @return the dateDepart
	 */
	public String getDateDepart() {
		return dateDepart;
	}
	/**
	 * @param dateDepart the dateDepart to set
	 */
	public void setDateDepart(String dateDepart) {
		this.dateDepart = dateDepart;
	}
	
	/**
	 * @return the ancienColl
	 */
	public Boolean getAncienColl() {
		return ancienColl;
	}
	/**
	 * @param ancienColl the ancienColl to set
	 */
	public void setAncienColl(Boolean ancienColl) {
		this.ancienColl = ancienColl;
	}

	/**
	 * @return the participeSi
	 */
	public Boolean getParticipeSi() {
		return participeSi;
	}
	/**
	 * @param participeSi the participeSi to set
	 */
	public void setParticipeSi(Boolean participeSi) {
		this.participeSi = participeSi;
	}
	/**
	 * @return the dateSi
	 */
	public String getDateSi() {
		return dateSi;
	}
	/**
	 * @param dateSi the dateSi to set
	 */
	public void setDateSi(String dateSi) {
		this.dateSi = dateSi;
	}
	/**
	 * @return the posteActuel3
	 */
	public String getPosteActuel3() {
		return posteActuel3;
	}
	/**
	 * @param posteActuel3 the posteActuel3 to set
	 */
	public void setPosteActuel3(String posteActuel3) {
		this.posteActuel3 = posteActuel3;
	}
	/**
	 * @return the posteActuel4
	 */
	public String getPosteActuel4() {
		return posteActuel4;
	}
	/**
	 * @param posteActuel4 the posteActuel4 to set
	 */
	public void setPosteActuel4(String posteActuel4) {
		this.posteActuel4 = posteActuel4;
	}
	/**
	 * @return the salaireActuel
	 */
	public Double getSalaireActuel() {
		return salaireActuel;
	}
	/**
	 * @param salaireActuel the salaireActuel to set
	 */
	public void setSalaireActuel(Double salaireActuel) {
		this.salaireActuel = salaireActuel;
	}
	/**
	 * @return the compte
	 */
	public Compte getCompte() {
		return compte;
	}
	/**
	 * @param compte the compte to set
	 */
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	/**
	 * @return the dIPLOME
	 */
	public List<Diplome> getDIPLOME() {
		return DIPLOME;
	}
	/**
	 * @param dIPLOME the dIPLOME to set
	 */
	public void setDIPLOME(List<Diplome> dIPLOME) {
		DIPLOME = dIPLOME;
	}
	/**
	 * @return the tECHNOLOGIE
	 */
	public List<Technologie> getTECHNOLOGIE() {
		return TECHNOLOGIE;
	}
	/**
	 * @param tECHNOLOGIE the tECHNOLOGIE to set
	 */
	public void setTECHNOLOGIE(List<Technologie> tECHNOLOGIE) {
		TECHNOLOGIE = tECHNOLOGIE;
	}
	/**
	 * @return the cOMPETENCE
	 */
	public List<Competence> getCOMPETENCE() {
		return COMPETENCE;
	}
	/**
	 * @param cOMPETENCE the cOMPETENCE to set
	 */
	public void setCOMPETENCE(List<Competence> cOMPETENCE) {
		COMPETENCE = cOMPETENCE;
	}
	
	
	
}
