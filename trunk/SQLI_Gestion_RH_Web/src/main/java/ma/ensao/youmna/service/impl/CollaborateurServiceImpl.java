package ma.ensao.youmna.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import ma.ensao.youmna.dao.CollaborateurDao;
import ma.ensao.youmna.model.Collaborateur;
import ma.ensao.youmna.service.CollaborateurService;

@Service
public class CollaborateurServiceImpl implements CollaborateurService{
	
	private CollaborateurDao collaborateurDao;
	

	public void setCollaborateurDao(CollaborateurDao collaborateurDao) {
		this.collaborateurDao = collaborateurDao;
	}

	public void createCollaborateur(Collaborateur collaborateur) {
		collaborateurDao.createCollaborateur(collaborateur);
		
	}

	public void deleteCollaborateur(String matricule) {
		collaborateurDao.deleteCollaborateur(matricule);
		
	}

	public Collaborateur getCollaborateurById(String matricule) {
		
		return collaborateurDao.getCollaborateurById(matricule);
	}

	public void updateCollaborateur(Collaborateur collaborateur) {
		collaborateurDao.updateCollaborateur(collaborateur);
		
	}

	public List<Collaborateur> getAllCollaborateurs() {

		return collaborateurDao.getAllCollaborateurs();
	}

}