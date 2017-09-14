package net.ycod3r.controller;


import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.ycod3r.config.PrincipalUser;
 
@Controller
public class HomeController {
	
	@RequestMapping({"","/dashboard"})
	public String dashboard(PrincipalUser principal){
		
		return "dashboard";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String connexion(){
		return "my_login";
	}
	
	@RequestMapping(value="/403",method=RequestMethod.GET)
	public String forbidden(){
		return "forbidden";
	}


}
