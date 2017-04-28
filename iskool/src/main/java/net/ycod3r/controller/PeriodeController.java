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

import net.ycod3r.domain.Periode;
import net.ycod3r.repository.PeriodeRepo;

@Controller
@RequestMapping("/periodes")
public class PeriodeController {
	
	@Autowired
	private PeriodeRepo periodeRep;
	
	@GetMapping
	public String index(Model model){
		
		List<Periode> periodes = periodeRep.findAll();
		model.addAttribute("periodes", periodes);
		return "periodes";
	}
	
	@GetMapping("/add")
	public String nouveau(Model model){
		model.addAttribute("periode",new Periode());
		return "form-periode";
	}

	@GetMapping("/edit/{id}")
	public String editer(Model model, @PathVariable long id){
		Periode periode = periodeRep.findOne(id);
		model.addAttribute("periode",periode);
		return "form-periode";
	}
	

	@PostMapping("/save")
	public String enregistrer(@Valid @ModelAttribute("periode") Periode periode, BindingResult result){
		if(result.hasErrors()){
			return "form-periode";
		}
		periodeRep.save(periode);
		return "redirect:/periodes";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteAction(@PathVariable long id){
		periodeRep.delete(id);
		return "redirect:/periodes";
	}
	


}
