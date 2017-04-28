package net.ycod3r.converters;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public final class BasicDateConverter implements Converter<Date, String>{
	private final SimpleDateFormat sdf;
	
	public BasicDateConverter(String dateFormat){
		this.sdf = new SimpleDateFormat(dateFormat);
	}

	@Override
	public String convert(Date arg0) {
		// TODO Auto-generated method stub
		return sdf.format(arg0);
	}


}
