package ma.ensao.youmna.service;

import java.util.List;

import ma.ensao.youmna.model.Compte;

public interface CompteService {
	void createCompte(Compte compte);
	void sendMessage(String to, String subject, String message);
	List<Compte> getAll();
}