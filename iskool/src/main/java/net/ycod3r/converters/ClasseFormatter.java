package net.ycod3r.converters;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;

import net.ycod3r.domain.Classe;
import net.ycod3r.repository.ClasseRepo;

@Service
public class ClasseFormatter implements Formatter<Classe> {
	
	@Autowired
	private ClasseRepo classeRep; 

	@Override
	public String print(Classe classe, Locale arg1) {
		// TODO Auto-generated method stub
		return classe.toString();
	}

	@Override
	public Classe parse(String classeName, Locale arg1) throws ParseException {
		// TODO Auto-generated method stub
		Classe classe= null;
		classe = classeRep.findByName(classeName); 
		return classe;
	}

}
