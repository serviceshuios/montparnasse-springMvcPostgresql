package com.huios.SpringMVC.service;
import java.util.List;

import com.huios.SpringMVC.metier.Personne;



public interface Iadmin {
	public List<Personne> findAll();
	public int ajouterPersonne(Personne p);
	public int supprimerPersonne(int idPersonne);
	public Personne getPersonne(int idPersonne);
	public int modifierPersonne(Personne p);
	public Personne trouverParleNom(String nom);
	public List<Personne> rechercheParMC(String mc);


}
