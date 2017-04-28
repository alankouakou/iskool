package net.ycod3r.converters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;

import net.ycod3r.domain.Evaluation;
import net.ycod3r.repository.EvaluationRepo;

@Service
public class EvaluationFormatter implements Formatter<Evaluation>{
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@Autowired
	private EvaluationRepo evalRep;

	@Override
	public String print(Evaluation evaluation, Locale arg1) {
		//return evaluation.getClasse() +" - " + evaluation.getTypeEvaluation() + " du "+sdf.format(evaluation.getDateEvaluation()) ;
		return Long.toString(evaluation.getId());
	}

	@Override
	public Evaluation parse(String evalId, Locale arg1) throws ParseException {
		return evalRep.findOne(Long.parseLong(evalId));
	}

}
