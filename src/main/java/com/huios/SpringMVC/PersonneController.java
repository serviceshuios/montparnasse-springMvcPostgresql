package com.huios.SpringMVC;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.huios.SpringMVC.metier.Personne;
import com.huios.SpringMVC.service.Iadmin;

@Controller
public class PersonneController {

	@Autowired
	private Iadmin service;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String lister(Model model) {
		model.addAttribute("personne", new Personne());
		model.addAttribute("personnes", service.findAll());
		return "personnes";
	}

	@RequestMapping(value = "/savePersonne")
	public String save(@Valid Personne personne, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("personnes", service.findAll());
			return "personnes";
		}
		if (personne.getId() == 0) {
			service.ajouterPersonne(personne);
			model.addAttribute("personne", new Personne());
			model.addAttribute("personnes", service.findAll());
			return "personnes";
		} else {
			service.modifierPersonne(personne);
			model.addAttribute("personne", new Personne());
			model.addAttribute("personnes", service.findAll());
			return "personnes";
		}
	}

	@RequestMapping(value = "/deletePersonne")
	public String delete(@RequestParam int id, Model model) {
		service.supprimerPersonne(id);
		model.addAttribute("personne", new Personne());
		model.addAttribute("personnes", service.findAll());
		return "personnes";
	}

	@RequestMapping(value = "/editPersonne")
	public String edit(@RequestParam int id, Model model) {
		model.addAttribute("personne", service.getPersonne(id));
		model.addAttribute("personnes", service.findAll());
		return "personnes";
	}
}
