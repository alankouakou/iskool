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
import net.ycod3r.domain.Matiere;
import net.ycod3r.repository.ClasseRepo;
import net.ycod3r.repository.EleveRepo;
import net.ycod3r.repository.MatiereRepo;

@Controller
@RequestMapping({"/matieres"})
public class MatiereController {
	
	@Autowired
	private MatiereRepo matiereRep;
	
	@GetMapping
	public String index(Model model){
		
		List<Matiere> matieres = matiereRep.findAllByOrderByNameAsc();
		model.addAttribute("matieres", matieres);
		return "matieres";
	}
	
	@GetMapping("/add")
	public String add(Model model){
		model.addAttribute("matiere",new Matiere());
		return "form-matiere";
	}

	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable long id){
		Matiere matiere = matiereRep.findOne(id);
		model.addAttribute("matiere",matiere);
		return "form-matiere";
	}
	
	
	@GetMapping("/show/{id}")
	public String show(Model model, @PathVariable long id){
		Matiere matiere = matiereRep.findOne(id);
		model.addAttribute("matiere",matiere);
		System.out.println("Libelle matiere:" + matiere.getName());
		return "form-matiere";
	}
	
	
	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("matiere") Matiere matiere, BindingResult result){
		if(result.hasErrors()){
			return "form-matiere";
		}
		matiereRep.save(matiere);
		return "redirect:/matieres";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteAction(@PathVariable long id){
		matiereRep.delete(id);
		return "redirect:/matieres";
	}
	


}
