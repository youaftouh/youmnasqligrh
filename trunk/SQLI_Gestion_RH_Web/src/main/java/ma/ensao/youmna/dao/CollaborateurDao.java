package ma.ensao.youmna.dao;

import java.util.List;

import ma.ensao.youmna.model.Collaborateur;

public interface CollaborateurDao {
	
	void createCollaborateur(Collaborateur collaborateur);
	
	void deleteCollaborateur(String matricule);
	
	Collaborateur getCollaborateurById(String matricule);
	
	void updateCollaborateur(Collaborateur collaborateur);
	
	List<Collaborateur> getAllCollaborateurs();

}