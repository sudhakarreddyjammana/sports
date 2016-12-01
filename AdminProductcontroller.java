package com.niit.controlers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.DAO.AdminCategoryDAO;
import com.niit.DAO.AdminProductDAO;
import com.niit.DAO.AdminSupplierDAO;
import com.niit.model.AdminProductmodel;

@Controller
public class AdminProductcontroller {
	@Autowired
	AdminCategoryDAO catDao;
	@Autowired
	AdminSupplierDAO supDao;
	@Autowired
	AdminProductDAO prodDao;
	
	@RequestMapping(value="/AdminProduct",method=RequestMethod.GET)
	public ModelAndView showProduct()
	{
		ModelAndView mv = new ModelAndView("AdminProduct","AdminProductmodel",new AdminProductmodel());
	    String catjsonlist=catDao.list();
	    mv.addObject("data",catjsonlist);
	    
	    String supjsonlist=supDao.list();
	    mv.addObject("data2",supjsonlist);
	    String prod=prodDao.list();
	    mv.addObject("data3",prod);
	    mv.addObject("check", true);
	    return mv;    
	}
	@RequestMapping(value="/addpro",method=RequestMethod.POST)
	public ModelAndView addpro(AdminProductmodel aprod)
	{
		System.out.println("in addAdminProduct post1");
	    prodDao.Save(aprod); 
		System.out.println("in addAdminProduct post2");
		String prd=prodDao.list();
		ModelAndView mv = new ModelAndView("AdminProduct","AdminProductmodel",new AdminProductmodel());
		mv.addObject("data3",prd);
		String catjsonlist=catDao.list();
		
		mv.addObject("data",catjsonlist);
		System.out.println("in addAdminProduct post3");
		String supjsonlist=supDao.list();
		System.out.println("in addAdminProduct post4");
		mv.addObject("data2",supjsonlist);
		mv.addObject("check",true);
		System.out.println("in addAdminProduct post5");
		
		System.out.println("in addAdminProduct post6"+prd);
		
		System.out.println("in addAdminProduct post7");
		
		String path="G://sudhakar project//SportsWorld//src//main//webapp//resources//images//";
		path=path+String.valueOf(aprod.getPid())+".jpg";
		System.out.println("in addAdminProduct post8");
		File f=new File(path);
		System.out.println("in addAdminProduct post9");
		System.out.println("in addAdminProduct post9"+aprod);
		MultipartFile filedet=aprod.getPimage();
		System.out.println("in addAdminProduct post10"+filedet);
		if(!filedet.isEmpty())
		{
			System.out.println("in addAdminProduct post10");
			try
			{
			  byte[] bytes=filedet.getBytes();
			  System.out.println(bytes.length);
			  FileOutputStream fos=new FileOutputStream(f);
              			BufferedOutputStream bs=new BufferedOutputStream(fos);
              			bs.write(bytes);
              			bs.close();
             			 System.out.println("File Uploaded Successfully");
			}
			catch(Exception e)
			{
				System.out.println("Exception Arised"+e);
			}
		}
		else
		{
			System.out.println("File is Empty not Uploaded");
			
		}

		return mv;
		
	}
		
	
	@RequestMapping(value="/deletepro",method = RequestMethod.GET)
	public ModelAndView deletePro(@RequestParam("pid")String pid)
	{
		prodDao.deletePro(pid);
		String prjson=prodDao.list();
		ModelAndView m =new ModelAndView("AdminProduct","AdminProductmodel",new AdminProductmodel());
		m.addObject("check",true);
		m.addObject("data3",prjson);
	
		String catjsonlist=catDao.list();
		
		m.addObject("data", catjsonlist);
		String supjsonlist=supDao.list();
		m.addObject("data2", supjsonlist);
		return m;
		
	}
	@RequestMapping(value="updatepro",method=RequestMethod.GET)
	public ModelAndView updatePro(@RequestParam("pid")String pid)
	{
		AdminProductmodel ad =prodDao.DispRecord(pid);
		ModelAndView m = new ModelAndView("AdminProduct","AdminProductmodel",ad);
		

		System.out.println("pro idddddddddddddddddddddd"+ad.getPid());
		m.addObject("check",false);
		String catjsonlist=catDao.list();
		
		m.addObject("data",catjsonlist);
		String supjsonlist=supDao.list();
		m.addObject("data2",supjsonlist);
		String pdjsonlist=prodDao.list();
		m.addObject("data3",pdjsonlist);
		System.out.println(supjsonlist);
		return m;
	}
	@RequestMapping(value="/updatepro",method=RequestMethod.POST)
	public ModelAndView updateProd(AdminProductmodel pd)
	{
		prodDao.updatePro(pd);
		String apdjsonlist=prodDao.list();
		ModelAndView m = new ModelAndView("AdminProduct","AdminProductmodel",new AdminProductmodel());
		m.addObject("check",true);
		m.addObject("data3",apdjsonlist);
		String catjsonlist=catDao.list();
		
		
		
		m.addObject("data",catjsonlist);
		String supjsonlist=supDao.list();
		m.addObject("data2",supjsonlist);
	
		
		
		return m;
		
	}
	
	
	
}
	