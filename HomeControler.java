package com.niit.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.DAO.AdminCategoryDAO;
import com.niit.DAO.AdminProductDAO;
import com.niit.DAO.AdminSupplierDAO;
import com.niit.model.AdminProductmodel;

@Controller
public class HomeControler {

	@Autowired
	AdminCategoryDAO catDao;
	@Autowired
	AdminSupplierDAO supDao;
	@Autowired
	AdminProductDAO prodDao;
	
	
	
	
	@RequestMapping("/")
	public String index()
	{
	return "index";
	}	
	@RequestMapping("/login")
	   public String login(Model model)
	   {
	   model.addAttribute("isuserclickedlogin", "true");
	     return "login";
       }
	
	
	@RequestMapping("/Home")
	   public String Home(Model model)
	   {
	   model.addAttribute("isuserclickedHome", "true");
	     return "index";
 }
	@RequestMapping("/About")
	   public String About(Model model)
	   {
	   model.addAttribute("isuserclickedAbout", "true");
	     return "About";
}
	@RequestMapping("/contact us")
	   public String contact(Model model)
	   {
	   model.addAttribute("isuserclickedcontactus", "true");
	     return "contact us";
   }
	
	//===============================================================================
	@RequestMapping(value="/Products",method=RequestMethod.GET)
	public ModelAndView showProduct()
	{
		ModelAndView mv = new ModelAndView("Products","AdminProductmodel",new AdminProductmodel());
	    String catjsonlist=catDao.list();
	    mv.addObject("data",catjsonlist);
	    
	    String supjsonlist=supDao.list();
	    mv.addObject("data2",supjsonlist);
	    String prod=prodDao.list();
	    mv.addObject("data3",prod);
	    mv.addObject("check", true);
	    return mv;    
	}	
	
	
	//=========================================================================================
	@RequestMapping("/Result")
	   public String result(Model model)
	   {
	   model.addAttribute("isuserclickedResult", "true");
	     return "Result";
}
	@RequestMapping("/Admin")
	   public String Admin(Model model)
	   {
	   model.addAttribute("isuserclickedAdmin", "true");
	     return "Admin";
 }
	//==============================================================================================
	@RequestMapping(value="/moreinfo",method=RequestMethod.GET)
	public ModelAndView showProduct1()
	{
		ModelAndView mv = new ModelAndView("moreinfo","AdminProductmodel",new AdminProductmodel());
	    String catjsonlist=catDao.list();
	    mv.addObject("data",catjsonlist);
	    
	    String supjsonlist=supDao.list();
	    mv.addObject("data2",supjsonlist);
	    String prod=prodDao.list();
	    mv.addObject("data3",prod);
	    mv.addObject("check", true);
	    return mv;    
	}	
}
