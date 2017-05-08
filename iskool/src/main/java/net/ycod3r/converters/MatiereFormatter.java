package net.ycod3r.converters;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import net.ycod3r.domain.Matiere;
import net.ycod3r.repository.MatiereRepo;

@Component
public class MatiereFormatter implements Formatter<Matiere>{

	@Autowired
	private MatiereRepo matiereRep;
	
	@Override
	public String print(Matiere matiere, Locale arg1) {
		return matiere.getName();
	}

	@Override
	public Matiere parse(String name, Locale arg1) throws ParseException {
		Matiere matiere = null;
		matiere= matiereRep.findByName(name);
		return matiere;
	}

}
