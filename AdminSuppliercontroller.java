package com.niit.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.DAO.AdminSupplierDAO;
import com.niit.model.AdminSuppliermodel;




@Controller
public class AdminSuppliercontroller {
	@Autowired
	
	AdminSupplierDAO ci;
	
//	======================================GET OR DISPLAY METHOD===========================================
	@RequestMapping(value="/Adminsupplier",method = RequestMethod.GET)
	public ModelAndView addSupplier() 
	{
		ModelAndView mv = new ModelAndView("Adminsupplier","AdminSuppliermodel",new AdminSuppliermodel());
		
		String supgson=ci.list();
	
		mv.addObject("data",supgson);
		
		 mv.addObject("check",true);
		
		return mv;

	}
    @RequestMapping(value="/addsup",method = RequestMethod.POST)     
    	public ModelAndView addpSupplier(AdminSuppliermodel c ) {
    
	         ci.save(c);
	         
	        String clst=ci.list();
	        System.out.println("json list  ==========         "+clst);
	        ModelAndView mv =new ModelAndView("Adminsupplier","AdminSuppliermodel" ,new AdminSuppliermodel());
	        
	        mv.addObject("data",clst);
	        
	        mv.addObject("check",true);    
    	
    	return mv;
        
    }
//	=============================================UPDATE OR EDIT METHOD=========================================
    
    @RequestMapping(value="/updatesup",method=RequestMethod.GET)
	public ModelAndView updatesup(@RequestParam(value="custid")String sid)
	{
		
	
    AdminSuppliermodel acd =ci.DispRecord(sid);
	ModelAndView m = new ModelAndView("Adminsupplier","AdminSuppliermodel",acd);
		
		
		m.addObject("check",false);
	    String cgsonlist=ci.list();
	
	
	
	m.addObject("data",cgsonlist);
	System.out.println(cgsonlist);
	return m;
	}	
    @RequestMapping(value="/updatesup",method=RequestMethod.POST)
	public ModelAndView updatesup(AdminSuppliermodel ap)
	{
    	ModelAndView m = new ModelAndView("Adminsupplier","AdminSuppliermodel",new AdminSuppliermodel());
		ci.update(ap);                            //"category.jsp ","objvarName",creating an object
		m.addObject("check",true); 
		String cgsonlist=ci.list();
		m.addObject("data",cgsonlist);

		
		return m;
		
	}


//	=========================================delete METHOD==================================================
    @RequestMapping(value="/deletesup",method = RequestMethod.GET)
	public ModelAndView deletesup(@RequestParam("custid")String gcid) 
	{
		
		ci.delete(gcid);
		
		
			ModelAndView m = new ModelAndView("Adminsupplier","AdminSuppliermodel",new AdminSuppliermodel());
		
		String id=ci.sortId();
		m.addObject("supplierId",id);
		String supjsonlist=ci.list();
		
		m.addObject("data",supjsonlist);
		
		return m;
	}
	
	
}	
	

