package net.ycod3r.controller;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.ycod3r.business.EnseignantMgr;
import net.ycod3r.domain.Civilite;
import net.ycod3r.domain.Classe;
import net.ycod3r.domain.Enseignant;
import net.ycod3r.domain.Sexe;
import net.ycod3r.domain.SituationFamiliale;
import net.ycod3r.repository.ClasseRepo;

@Controller
@RequestMapping("/enseignants")
public class EnseignantController {

	@Autowired
	private EnseignantMgr enseignantMgr;

	@Autowired
	private ClasseRepo classeRep;

	@ModelAttribute("classes")
	private List<Classe> getClasses() {
		List<Classe> classes = classeRep.findAll();
		return classes;
	}
	
	@ModelAttribute("civilites")
	private List<Civilite> getCivilites(){
		return Arrays.asList(Civilite.values());
	}

	@ModelAttribute("genres")
	private List<Sexe> getGenres(){
		return Arrays.asList(Sexe.values());
	}
	
	@ModelAttribute("etatCivils")
	private List<SituationFamiliale> getEtatCivils(){
		return Arrays.asList(SituationFamiliale.values());
	}
	
	@GetMapping("/list")
	public String index(Model model) {
		Collection<Enseignant> enseignants = enseignantMgr.findAllByOrderByNomAscPrenomAsc();
		model.addAttribute("enseignants", enseignants);
		return "enseignants";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String index2(Model model) {
		Collection<Enseignant> enseignants = enseignantMgr.findAllByOrderByNomAscPrenomAsc();
		model.addAttribute("enseignants", enseignants);
		return "enseignants-widget";
	}
	
	@GetMapping("/add")
	public String add(Model model) {

		Enseignant enseignant = new Enseignant();

		model.addAttribute("enseignant", enseignant);
		return "form-enseignant";
	}

	@GetMapping("/new")
	public String addNew(Model model) {

		Enseignant ens = new Enseignant();
		model.addAttribute("enseignant", ens);
		return "form-enseignant";
	}

	
	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("enseignant") Enseignant enseignant, BindingResult result) {
		if (result.hasErrors()) {
			return "form-enseignant";
		} else {
			enseignantMgr.save(enseignant);
			return "redirect:/enseignants";
		}
	}

	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable long id) {
		Enseignant enseignant = enseignantMgr.findOne(id);
		model.addAttribute("enseignant", enseignant);
		return "form-enseignant";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable long id) {
		enseignantMgr.delete(id);
		// message de Confirmation
		return "redirect:/enseignants";
	}

}
