package net.ycod3r.controller;

import java.util.Date;
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

import net.ycod3r.business.EleveMgr;
import net.ycod3r.business.MatiereMgr;
import net.ycod3r.domain.Classe;
import net.ycod3r.domain.Eleve;
import net.ycod3r.domain.Evaluation;
import net.ycod3r.domain.Matiere;
import net.ycod3r.domain.Note;
import net.ycod3r.domain.TypeNote;
import net.ycod3r.repository.ClasseRepo;
import net.ycod3r.repository.EvaluationRepo;
import net.ycod3r.repository.NoteRepo;
import net.ycod3r.repository.TypeNoteRepo;

@Controller
@RequestMapping("/evaluations")
public class EvaluationController {
	
	@Autowired
	private EvaluationRepo evaluationRep;
	
	@Autowired
	private ClasseRepo classeRep;
	
	@Autowired
	private TypeNoteRepo typeNoteRep;

	@Autowired
	private NoteRepo noteRep;
	
	@Autowired
	private EleveMgr eleveMgr;
	
	@Autowired
	private MatiereMgr matiereMgr;	


	@ModelAttribute("classes")
	private List<Classe> getClasses()
	{
		return classeRep.findAll();
	}
	
	@ModelAttribute("typeNotes")
	private List<TypeNote> getTypeEvaluation()
	{
		return typeNoteRep.findAll();
	}
	
	@ModelAttribute("matieres")
	private List<Matiere> getMatiere()
	{
		return matiereMgr.findAll();
	}
	
	
	@GetMapping
	public String index(Model model){
		
		List<Evaluation> evaluations = evaluationRep.findAllByOrderByDateEvaluationDesc();
		model.addAttribute("evaluations", evaluations);
		return "evaluations";
	}
	
	@GetMapping("/add")
	public String add(Model model){
		model.addAttribute("evaluation",new Evaluation());
		return "form-evaluation";
	}

	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable long id){
		Evaluation evaluation = evaluationRep.findOne(id);
		model.addAttribute("evaluation",evaluation);
		return "form-evaluation";
	}
	
	
	@GetMapping("/{id}/notes")
	public String show(Model model, @PathVariable long id){
		Evaluation evaluation = evaluationRep.findOne(id);
		model.addAttribute("evaluation",evaluation);
		Long nbNotes = noteRep.countByEvaluation(evaluation);
		Long nbEleves = eleveMgr.countByClasse(evaluation.getClasse());
		model.addAttribute("nbEleves",nbEleves);
		model.addAttribute("nbNotes",nbNotes);
		System.out.println("Nb notes :" + nbNotes);
		List<Note> notes = noteRep.findByEvaluationOrderByValeurDesc(evaluation);
		System.out.println("Liste des notes: " + notes);
		model.addAttribute("notes",notes);
		System.out.println("Notes:"+nbNotes+" effectif:"+nbEleves);
		return "notes-evaluation";
	}
	
	@GetMapping("/{id}/add-note")
	public String addNote(Model model, @PathVariable long id){
		
		Evaluation evaluation = evaluationRep.findOne(id);
		List<Eleve> eleves = eleveMgr.findNonEvaluesByEvaluationId(id);
		Note note = new Note();
		note.setEvaluation(evaluation);
		note.setDate(new Date());
		
		model.addAttribute("eleves",eleves);
		model.addAttribute("note",note);
		return "form-note";
	}
	
	
	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("evaluation") Evaluation evaluation, BindingResult result){
		if(result.hasErrors()){
			return "form-evaluation";
		}
		evaluationRep.save(evaluation);
		return "redirect:/evaluations";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteAction(@PathVariable long id){
		evaluationRep.delete(id);
		return "redirect:/";
	}
	


}
