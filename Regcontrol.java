package com.niit.controlers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.DAO.RegistrationDAO;
import com.niit.model.Register;

@Controller
@RequestMapping("register")
@Component
public class Regcontrol{
	
	@Autowired
	RegistrationDAO dao;
	
	 @RequestMapping(method = RequestMethod.GET)
     public ModelAndView viewRegister() {
		ModelAndView mv=new ModelAndView("register","command",new Register());
       
        
       return mv;
   }  
	
	@RequestMapping(method = RequestMethod.POST)
	    public String processRegister(@ModelAttribute("Register") Register user,
	            Map<String, Object> model) {
	      System.out.println("First Name: " + user.getFirstName());
	       System.out.println("Last Name: " + user.getLastName());
	     //   System.out.println("password: " + user.getPassword());
	      //  System.out.println("email: " + user.getEmail());
	      //  System.out.println("mobile no: " + user.getMobile());
	        
	     dao.insertData(user);
	        return "Result";
	        		
	    }
}

    
	

