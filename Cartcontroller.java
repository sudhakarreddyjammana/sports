package com.niit.controlers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.niit.DAO.AdminProductDAO;
import com.niit.DAO.CartDAO;
import com.niit.model.AdminProductmodel;
import com.niit.model.Cartmodel;


@Controller
public class Cartcontroller {
	
	
	@Autowired
	AdminProductDAO prodDao ;
	@Autowired
	CartDAO cartDao;
	
	
	@RequestMapping(value = "/Cart", method = RequestMethod.GET)
	public ModelAndView AddCart(@RequestParam("pid") String pid,@RequestParam("s") int quantity) {
		
		AdminProductmodel p = prodDao.DispRecord(pid);
		Cartmodel c = new Cartmodel();
	System.out.println(p);
		c.setPid(""+p.getPid());
		System.out.println(c.getPid());
		c.setPname(p.getPname());
		c.setPprice(p.getPprice());
		c.setTotal(quantity*p.getPprice());
		c.setQuantity(quantity);
		int totalprice=0;
		totalprice=totalprice+quantity*p.getPprice();
		
		cartDao.insertCart(c);
		List cartlist=cartDao.listCart();
		ModelAndView mv = new ModelAndView("Cart","Crt",cartlist);
		System.out.println("pro id" + p.getPid());
		
		return mv;
	}
	


	
	

	
		
	

}