package com.huios.SpringMVC.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.huios.SpringMVC.metier.Personne;


@Transactional
@Repository
public interface PersonneDao extends JpaRepository<Personne, Integer>{
	public Personne findByNom(String leNom);
	public List<Personne> findByAge(int age);
	public Personne findByNomAndPrenom(String nom,String prenom);
	@Query("select  p from Personne p where p.nom like :x")
	public List<Personne> rechercheParMC(@Param("x")String mc);
	public List<Personne> findAllByOrderByIdAsc();
}
