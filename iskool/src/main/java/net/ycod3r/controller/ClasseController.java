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

import net.ycod3r.domain.Classe;
import net.ycod3r.domain.Eleve;
import net.ycod3r.repository.ClasseRepo;
import net.ycod3r.repository.EleveRepo;

@Controller
@RequestMapping({"/classes"})
public class ClasseController {
	
	@Autowired
	private ClasseRepo classeRep;
	
	@Autowired
	private EleveRepo eleveRep;
	
	@GetMapping
	public String index(Model model){
		
		List<Classe> classes = classeRep.findAllByOrderByNameAsc();
		model.addAttribute("classes", classes);
		return "classes";
	}
	
	@GetMapping("/add")
	public String add(Model model){
		model.addAttribute("classe",new Classe());
		return "form-classe";
	}

	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable long id){
		Classe classe = classeRep.findOne(id);
		model.addAttribute("classe",classe);
		return "form-classe";
	}
	
	
	@GetMapping("/show/{id}")
	public String show(Model model, @PathVariable long id){
		Classe classe = classeRep.findOne(id);
		model.addAttribute("classe",classe);
		long effectif = eleveRep.countByClasse(classe);
		model.addAttribute("effectif",effectif);
		System.out.println("Effectif :" + effectif);
		System.out.println("Classe name:" + classe.getName());
		List<Eleve> eleves = eleveRep.findByClasseOrderByNomAscPrenomAsc(classe);
		System.out.println("Liste des eleves: " + eleves);
		model.addAttribute("eleves",eleves);
		//long effectif  = eleveRep.countByClasse(classe);
		//model.addAttribute("effectif", effectif);
		return "effectif-classe";
	}
	
	
	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("classe") Classe classe, BindingResult result){
		if(result.hasErrors()){
			return "form-classe";
		}
		classeRep.save(classe);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteAction(@PathVariable long id){
		classeRep.delete(id);
		return "redirect:/";
	}
	


}
