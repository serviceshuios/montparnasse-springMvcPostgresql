package com.huios.SpringMVC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huios.SpringMVC.dao.PersonneDao;
import com.huios.SpringMVC.metier.Personne;


@Transactional
@Service
public class ServiceImpl implements Iadmin {
	@Autowired
	private PersonneDao dao;

	@Override
	public List<Personne> findAll() {
		// TODO Auto-generated method stub
		return dao.findAllByOrderByIdAsc();
	}

	@Override
	public int ajouterPersonne(Personne p) {
		// TODO Auto-generated method stub
		dao.save(p);
		return 1;
	}

	@Override
	public int supprimerPersonne(int idPersonne) {
		// TODO Auto-generated method stub
		dao.deleteById(idPersonne);
		return 1;
	}

	@Override
	public Personne getPersonne(int idPersonne) {
		// TODO Auto-generated method stub
		return dao.findById(idPersonne).get();
	}

	@Override
	public int modifierPersonne(Personne p) {
		// TODO Auto-generated method stub
		dao.save(p);
		return 1;
	}


	@Override
	public Personne trouverParleNom(String nom) {
		// TODO Auto-generated method stub
		return dao.findByNom(nom);
	}

	@Override
	public List<Personne> rechercheParMC(String mc) {
		// TODO Auto-generated method stub
		return dao.rechercheParMC("%"+mc+"%");
	}
	
}
