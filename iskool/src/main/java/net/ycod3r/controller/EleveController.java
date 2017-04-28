package net.ycod3r.controller;

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
import org.springframework.web.bind.annotation.RequestParam;

import net.ycod3r.domain.Classe;
import net.ycod3r.domain.Eleve;
import net.ycod3r.repository.ClasseRepo;
import net.ycod3r.repository.EleveRepo;

@Controller
@RequestMapping("/eleves")
public class EleveController {

	@Autowired
	private EleveRepo eleveRep;

	@Autowired
	private ClasseRepo classeRep;

	@ModelAttribute("classes")
	private List<Classe> getClasses() {
		List<Classe> classes = classeRep.findAll();
		return classes;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model) {
		List<Eleve> eleves = eleveRep.findAllByOrderByNomAscPrenomAsc();
		model.addAttribute("eleves", eleves);
		return "eleves";
	}

	@GetMapping("/add")
	public String add(Model model, @RequestParam("classe") Classe classe) {

		Eleve elv = new Eleve();
		if (classe != null)
			elv.setClasse(classe);
		System.out.println(elv.getClasse());
		model.addAttribute("eleve", elv);
		return "form-eleve";
	}

	@GetMapping("/new")
	public String addNew(Model model) {

		Eleve elv = new Eleve();
		model.addAttribute("eleve", elv);
		return "form-eleve";
	}

	
	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("eleve") Eleve eleve, BindingResult result) {
		if (result.hasErrors()) {
			return "form-eleve";
		} else {
			eleveRep.save(eleve);
			return "redirect:/classes/show/"+eleve.getClasse().getId();
		}
	}

	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable long id) {
		Eleve eleve = eleveRep.findOne(id);
		model.addAttribute("eleve", eleve);
		return "form-eleve";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable long id) {
		eleveRep.delete(id);
		// message de Confirmation
		return "redirect:/eleves";
	}

}
