package net.ycod3r.converters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;

public class FrenchDateFormatter implements Formatter<Date>{

	private SimpleDateFormat dateFormatter;
	
	public FrenchDateFormatter(String dateFormat){
		this.dateFormatter = new SimpleDateFormat(dateFormat);
	}
	@Override
	public String print(Date paramDate, Locale locale) {
		// TODO Auto-generated method stub
		
		return dateFormatter.format(paramDate);
	}

	@Override
	public Date parse(String param, Locale arg1) throws ParseException {
		// TODO Auto-generated method stub
		return dateFormatter.parse(param);
	}

}
