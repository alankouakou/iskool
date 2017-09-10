package net.ycod3r.utils;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import net.ycod3r.domain.Civilite;
import net.ycod3r.domain.Classe;
import net.ycod3r.domain.Eleve;
import net.ycod3r.domain.Enseignant;
import net.ycod3r.domain.Evaluation;
import net.ycod3r.domain.Matiere;
import net.ycod3r.domain.Note;
import net.ycod3r.domain.Periode;
import net.ycod3r.domain.TypeNote;
import net.ycod3r.repository.ClasseRepo;
import net.ycod3r.repository.EleveRepo;
import net.ycod3r.repository.EnseignantRepo;
import net.ycod3r.repository.EvaluationRepo;
import net.ycod3r.repository.MatiereRepo;
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
	private EnseignantRepo enseignantRep;	
	@Autowired
	private NoteRepo noteRep;
	@Autowired
	private TypeNoteRepo typeNoteRep;
	@Autowired
	private PeriodeRepo periodeRep;
	
	@Autowired
	private EvaluationRepo evalRep;
	
	@Autowired
	private MatiereRepo matiereRep;

	//@Override
	public void run(String... arg0) throws Exception {
		
		//Initialisation matiere
		Matiere geometrie = new Matiere("Geometrie",4);
		Matiere francais = new Matiere("Technique d'expression",2);
		Matiere anglais = new Matiere("Anglais",1);
		Matiere rdm = new Matiere("RDM",4);
		
		matiereRep.save(Arrays.asList(geometrie,francais,anglais,rdm));

		// Initialisation Type Note
		TypeNote interro = new TypeNote("Test leger", 1);
		TypeNote devoir = new TypeNote("Test lourd", 2);
		TypeNote tp = new TypeNote("Travaux Pratiques", 2);

		typeNoteRep.save(Arrays.asList(interro, devoir, tp));

		// Initialisation periode

		Periode semestre1 = new Periode("1er Semestre 2017-2018");
		Periode semestre2 = new Periode("2e Semestre 2017-2018");

		periodeRep.save(Arrays.asList(semestre1, semestre2));

		// Initialisation classe
		Classe licence1 = new Classe("Licence 1");
		Classe licence2 = new Classe("Licence 2");
		//Classe cinquiemeA = new Classe("5eme A");
		//Classe cinquiemeB = new Classe("5eme B");

		//classeRep.save(Arrays.asList(sixiemeA, sixiemeB, cinquiemeA, cinquiemeB));
		classeRep.save(Arrays.asList(licence1, licence2));

		// Initialisation Eleves
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Eleve eleve1 = new Eleve("KOFFI", "Stéphane", Civilite.MONSIEUR, sdf.parse("01/02/1997"), licence1);
		Eleve eleve2 = new Eleve("KOUASSI", "Rosine", Civilite.MADEMOISELLE,sdf.parse("23/05/1995"), licence1);
		Eleve eleve3 = new Eleve("COULIBALY", "Mariama", Civilite.MADEMOISELLE, sdf.parse("12/07/1996"), licence1);
		Eleve eleve4 = new Eleve("YAO", "Olivier", Civilite.MONSIEUR, sdf.parse("07/03/1998"), licence1);
		Eleve eleve5 = new Eleve("TAPE", "Cedric", Civilite.MONSIEUR, sdf.parse("03/10/1998"), licence2);
		Eleve eleve6 = new Eleve("ZIKE", "Rodrigue", Civilite.MONSIEUR, sdf.parse("03/06/1997"), licence2);
		Eleve eleve7 = new Eleve("KOUAKOU", "Aurélien", Civilite.MONSIEUR, sdf.parse("09/11/1996"), licence2);
		Eleve eleve8 = new Eleve("KONE", "Abou",Civilite.MONSIEUR,  sdf.parse("12/12/1994"), licence2);
		Eleve eleve9 = new Eleve("NIAYE", "Aymeric", Civilite.MONSIEUR, sdf.parse("12/12/1999"), licence1);
		Eleve eleve10 = new Eleve("TOURE", "Karamoko", Civilite.MONSIEUR, sdf.parse("05/11/2000"), licence2);
		Eleve eleve11 = new Eleve("DEGNY", "Ambroise", Civilite.MONSIEUR, sdf.parse("06/10/1997"), licence2);

		eleveRep.save(Arrays.asList(eleve1, eleve2, eleve3, eleve4,eleve5,eleve6,eleve7,eleve8,eleve9,eleve10,eleve11));
		//eleveRep.save(Arrays.asList(eleve1, eleve2, eleve3, eleve4,eleve5,eleve6));
		// Initialisation Enseignants
		Enseignant enseignant = new Enseignant("SERY","Jocelyn",Civilite.MONSIEUR, sdf.parse("01/01/1975"),"09888888","22420000","jocelyn.sery@mail.com");
		Enseignant enseignant2 = new Enseignant("TOURE","Moussa",Civilite.MONSIEUR, sdf.parse("01/01/1978"),"02123456","22420000","moussa.toure@wanadoo.fr");
		Enseignant enseignant3 = new Enseignant("AKA","Armand",Civilite.MONSIEUR, sdf.parse("12/12/1973"),"05654321","22420000","armand.aka@hotmail.fr");
		
		enseignantRep.save(Arrays.asList(enseignant,enseignant2,enseignant3));
		//Initialisation evaluation
		Evaluation eval1 = new Evaluation(sdf.parse("03/12/2016"),licence1,geometrie,interro);
		Evaluation eval2 = new Evaluation(sdf.parse("01/03/2017"),licence2,francais,interro);
		Evaluation eval3 = new Evaluation(sdf.parse("01/02/2017"),licence1,geometrie,devoir);
		Evaluation eval4 = new Evaluation(sdf.parse("08/03/2017"),licence2,francais,devoir);
		Evaluation eval5 = new Evaluation(sdf.parse("08/03/2017"),licence2,francais,devoir);
		Evaluation eval6 = new Evaluation(sdf.parse("08/03/2017"),licence2,francais,devoir);
		evalRep.save(Arrays.asList(eval1,eval2,eval3,eval4,eval5,eval6));
		
		//Initialisation notes
		Note note1 = new Note(15,eleve1,eval1);
		Note note2 = new Note(12,eleve2,eval1);
		Note note3 = new Note(14,eleve3,eval1);
		Note note4 = new Note(17,eleve4,eval1);
		Note note5 = new Note(18,eleve1,eval3);
		Note note6 = new Note(13,eleve2,eval3);
		Note note7 = new Note(14,eleve3,eval3);
		Note note8 = new Note(15,eleve4,eval3);
		Note note9 = new Note(16,eleve5,eval2);
		Note note10 = new Note(11,eleve6,eval2);
		Note note11 = new Note(16,eleve7,eval2);
		Note note12 = new Note(12,eleve8,eval2);
		Note note13 = new Note(14,eleve5,eval4);
		Note note14 = new Note(16,eleve6,eval4);
		Note note15 = new Note(13,eleve7,eval4);
		Note note16 = new Note(18,eleve8,eval4);
		/*
		*/
		noteRep.save(Arrays.asList(note1,note2,note3,note4,note5,note6,note7,note8,note9,note10,note11,note12,note13,note14,note15,note16));

	}

}
