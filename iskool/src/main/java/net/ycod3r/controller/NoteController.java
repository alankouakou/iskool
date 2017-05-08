package net.ycod3r.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.ycod3r.business.EleveMgr;
import net.ycod3r.business.NoteMgr;
import net.ycod3r.domain.Eleve;
import net.ycod3r.domain.Moyenne;
import net.ycod3r.domain.Note;
import net.ycod3r.repository.EvaluationRepo;
import net.ycod3r.utils.MoyenneComparatorDesc;

@Controller
@RequestMapping("/notes")
public class NoteController {

	@Autowired
	EvaluationRepo evalRep;

	@Autowired
	private NoteMgr noteMgr;
	
	@Autowired
	private EleveMgr eleveMgr;
	


	@GetMapping
	public String index(Model model) {

		List<Note> notes = noteMgr.findAll();
		model.addAttribute("notes", notes);
		return "notes";
	}
	
	@GetMapping("/eleve/{id}")
	public String notesByEleveId(@PathVariable Long id, Model model){
		List<Note> notes= noteMgr.findByEleveId(id);
		Eleve eleve = eleveMgr.findOne(id);
		Moyenne moyenne = noteMgr.findMoyenneByEleveId(id);
		Long nbNotes = noteMgr.countByEleve(eleve);
		
		model.addAttribute("moyenne",moyenne);
		model.addAttribute("nbNotes", nbNotes);
		model.addAttribute("eleve",eleve);
		model.addAttribute("notes",notes);
		return "notes-eleve";
	}
	
	
	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("note", new Note());
		return "form-note";
	}

	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable long id) {
		Note note = noteMgr.findOne(id);
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
		noteMgr.save(note);
		return "redirect:/evaluations/"+note.getEvaluation().getId()+"/notes";
	}

	@GetMapping("/delete/{id}")
	public String deleteAction(@PathVariable long id) {
		noteMgr.delete(id);
		return "redirect:/notes";
	}
	
	
	@GetMapping("/moyennes")
	public String moyenneEleve(Model model){
		List<Moyenne> moyennes = noteMgr.findMoyennes();
		Collections.sort(moyennes, new MoyenneComparatorDesc());
		model.addAttribute("moyennes",moyennes);
		return "moyennes";
	}

	@GetMapping("/moyennes/{id}")
	public String moyenneEleve(Model model, @PathVariable Long id){
		List<Moyenne> moyennes = noteMgr.findMoyennesByClasseId(id);
		Collections.sort(moyennes,new MoyenneComparatorDesc());
		model.addAttribute("moyennes",moyennes);
		return "moyennes_classe";
	}
}
