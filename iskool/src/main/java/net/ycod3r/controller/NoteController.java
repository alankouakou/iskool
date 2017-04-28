package net.ycod3r.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.ycod3r.domain.Moyenne;
import net.ycod3r.domain.Note;
import net.ycod3r.repository.EvaluationRepo;
import net.ycod3r.repository.NoteRepo;

@Controller
@RequestMapping("/notes")
public class NoteController {

	@Autowired
	EvaluationRepo evalRep;

	@Autowired
	private NoteRepo noteRep;


	@GetMapping
	public String index(Model model) {

		List<Note> notes = noteRep.findAll();
		model.addAttribute("notes", notes);
		return "notes";
	}



	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("note", new Note());
		return "form-note";
	}

	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable long id) {
		Note note = noteRep.findOne(id);
		System.out.println(note.getEleve().getNom());
		model.addAttribute("eleves",note.getEleve());
		model.addAttribute("note", note);
		return "form-note";
	}



	@PostMapping("/save")
	public String save(@ModelAttribute("note") Note note) {
		if (note == null) {
			
			return "form-note";
		}
		noteRep.save(note);
		return "redirect:/evaluations/"+note.getEvaluation().getId()+"/notes";
	}

	@GetMapping("/delete/{id}")
	public String deleteAction(@PathVariable long id) {
		noteRep.delete(id);
		return "redirect:/notes";
	}
	
	
	@GetMapping("/moyennes")
	public String moyenneEleve(Model model){
		List<Moyenne> moyennes = noteRep.findMoyennes();
		model.addAttribute("moyennes",moyennes);
		return "moyennes";
	}

}
