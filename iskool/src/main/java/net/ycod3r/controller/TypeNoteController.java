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

import net.ycod3r.domain.TypeNote;
import net.ycod3r.repository.TypeNoteRepo;

@Controller
@RequestMapping("/type-note")
public class TypeNoteController {
	
	@Autowired
	TypeNoteRepo tnRep;
	
	@GetMapping
	public String index(Model model){
		List<TypeNote> typeNotes = tnRep.findAll();
		model.addAttribute("typeNotes",typeNotes);
		return "typenotes";
	}
	
	@GetMapping("/add")
	public String add(Model model){
		TypeNote typeNote = new TypeNote();
		model.addAttribute("typeNote", typeNote);
		return "form-typenote";
	}
	
	
	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable long id){
		TypeNote typeNote = tnRep.findOne(id);
		model.addAttribute("typeNote", typeNote);
		return "form-typenote";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable long id){
		tnRep.delete(id);
		return "redirect:/type-note";
	}
	
	
	@PostMapping("/save")
	public String save(@Valid @ModelAttribute TypeNote typeNote ,BindingResult result){
		if(result.hasErrors()){
			return "form-typenote";
		} else {
			tnRep.save(typeNote);
			return "redirect:/type-note";
		}
	}
	

}
