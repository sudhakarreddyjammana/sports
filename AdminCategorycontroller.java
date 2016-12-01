package com.niit.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.DAO.AdminCategoryDAO;
import com.niit.model.AdminCategorymodel;




@Controller
public class AdminCategorycontroller {
	@Autowired
	
	AdminCategoryDAO ci;
	
//	======================================GET OR DISPLAY METHOD===========================================
	@RequestMapping(value="/Admincategory",method = RequestMethod.GET)
	public ModelAndView addCategory() 
	{
		ModelAndView mv = new ModelAndView("Admincategory","AdminCategorymodel",new AdminCategorymodel());
		
		String catgson=ci.list();
	
		mv.addObject("data",catgson);
		
		 mv.addObject("check",true);
		
		return mv;

	}
    @RequestMapping(value="/addcat",method = RequestMethod.POST)     
    	public ModelAndView addpCategory(AdminCategorymodel c ) {
    
	         ci.save(c);
	         
	        String clst=ci.list();
	        System.out.println("json list  ==========         "+clst);
	        ModelAndView mv =new ModelAndView("Admincategory","AdminCategorymodel" ,new AdminCategorymodel());
	        
	        mv.addObject("data",clst);
	        
	        mv.addObject("check",true);    
    	
    	return mv;
        
    }
//	=============================================UPDATE OR EDIT METHOD=========================================
    
    @RequestMapping(value="/updatecat",method=RequestMethod.GET)
	public ModelAndView updatecat(@RequestParam(value="custid")String cid)
	{
		
	
	AdminCategorymodel acd =ci.DispRecord(cid);
	ModelAndView m = new ModelAndView("Admincategory","AdminCategorymodel",acd);
		
		
		m.addObject("check",false);
	    String cgsonlist=ci.list();
	
	
	
	m.addObject("data",cgsonlist);
	System.out.println(cgsonlist);
	return m;
	}	
    @RequestMapping(value="/updatecat",method=RequestMethod.POST)
	public ModelAndView updatecat(AdminCategorymodel ap)
	{
    	ModelAndView m = new ModelAndView("Admincategory","AdminCategorymodel",new AdminCategorymodel());
		ci.update(ap);                            //"category.jsp ","objvarName",creating an object
		m.addObject("check",true); 
		String cgsonlist=ci.list();
		m.addObject("data",cgsonlist);

		
		return m;
		
	}


//	=========================================delete METHOD==================================================
    @RequestMapping(value="/deletecat",method = RequestMethod.GET)
	public ModelAndView deletecat(@RequestParam("custid")String gcid) 
	{
		
		ci.delete(gcid);
		
		
			ModelAndView m = new ModelAndView("Admincategory","AdminCategorymodel",new AdminCategorymodel());
		
		String id=ci.sortId();
		m.addObject("categoryId",id);
		String catjsonlist=ci.list();
		
		m.addObject("data",catjsonlist);
		
		return m;
	}
	
	
}	
	

