package net.ycod3r.utils;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import net.ycod3r.domain.Classe;
import net.ycod3r.domain.Eleve;
import net.ycod3r.domain.Evaluation;
import net.ycod3r.domain.Note;
import net.ycod3r.domain.Periode;
import net.ycod3r.domain.TypeNote;
import net.ycod3r.repository.ClasseRepo;
import net.ycod3r.repository.EleveRepo;
import net.ycod3r.repository.EvaluationRepo;
import net.ycod3r.repository.NoteRepo;
import net.ycod3r.repository.PeriodeRepo;
import net.ycod3r.repository.TypeNoteRepo;

@Component
 public class DBInitJob implements CommandLineRunner {
//public class DBInitJob {
	@Autowired
	private ClasseRepo classeRep;
	@Autowired
	private EleveRepo eleveRep;
	@Autowired
	private NoteRepo noteRep;
	@Autowired
	private TypeNoteRepo typeNoteRep;
	@Autowired
	private PeriodeRepo periodeRep;
	
	@Autowired
	private EvaluationRepo evalRep;

	//@Override
	public void run(String... arg0) throws Exception {

		// Initialisation Type Note
		TypeNote interro = new TypeNote("Test leger", 1);
		TypeNote devoir = new TypeNote("Test lourd", 2);
		TypeNote tp = new TypeNote("Travaux Pratiques", 2);

		typeNoteRep.save(Arrays.asList(interro, devoir, tp));

		// Initialisation periode

		Periode semestre1 = new Periode("1er Semestre");
		Periode semestre2 = new Periode("2e Semestre");

		periodeRep.save(Arrays.asList(semestre1, semestre2));

		// Initialisation classe
		Classe sixiemeA = new Classe("6eme A");
		Classe sixiemeB = new Classe("6eme B");
		//Classe cinquiemeA = new Classe("5eme A");
		//Classe cinquiemeB = new Classe("5eme B");

		//classeRep.save(Arrays.asList(sixiemeA, sixiemeB, cinquiemeA, cinquiemeB));
		classeRep.save(Arrays.asList(sixiemeA, sixiemeB));

		// Initialisation Eleves
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Eleve eleve1 = new Eleve("KOFFI", "Stéphane", sdf.parse("01/02/2006"), sixiemeA);
		Eleve eleve2 = new Eleve("TAPE", "Cedric", sdf.parse("03/10/2005"), sixiemeB);
		Eleve eleve3 = new Eleve("KOUASSI", "Rosine", sdf.parse("23/05/2003"), sixiemeA);
		Eleve eleve4 = new Eleve("COULIBALY", "Mariama", sdf.parse("12/07/2005"), sixiemeA);
		Eleve eleve5 = new Eleve("YAO", "Olivier", sdf.parse("07/03/2005"), sixiemeA);
		Eleve eleve6 = new Eleve("ZIKE", "Rodrigue", sdf.parse("03/06/2006"), sixiemeB);
		Eleve eleve7 = new Eleve("KOUAKOU", "Aurélien", sdf.parse("09/11/2006"), sixiemeB);
		Eleve eleve8 = new Eleve("KONE", "Abou", sdf.parse("12/12/2005"), sixiemeB);

		eleveRep.save(Arrays.asList(eleve1, eleve2, eleve3, eleve4,eleve5,eleve6,eleve7,eleve8));
		
		
		//Initialisation evaluation
		Evaluation eval1 = new Evaluation(sdf.parse("03/12/2016"),sixiemeA,interro);
		Evaluation eval2 = new Evaluation(sdf.parse("01/04/2017"),sixiemeB,devoir);
		Evaluation eval3 = new Evaluation(sdf.parse("01/02/2017"),sixiemeA,devoir);
		evalRep.save(Arrays.asList(eval1,eval2,eval3));
		
		//Initialisation notes
		Note note1 = new Note(15,eleve1,eval1);
		Note note2 = new Note(12,eleve2,eval2);
		Note note3 = new Note(14,eleve3,eval1);
		Note note4 = new Note(17,eleve4,eval1);
		Note note5 = new Note(18,eleve5,eval1);
		
		noteRep.save(Arrays.asList(note1,note2,note3,note4,note5));

	}

}
