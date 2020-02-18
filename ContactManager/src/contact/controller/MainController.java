package contact.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import contact.dao.ContactDAO;
import contact.model.Contact;


@Controller
public class MainController {

	@Autowired
	private ContactDAO contactDao;
	
	@RequestMapping(value = "/")
	public ModelAndView listContact(ModelAndView modelAndView)
	{
		ArrayList<Contact> listOfContacts = contactDao.listContacts();
		modelAndView.addObject("listOfContacts", listOfContacts);
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView newContact()
	{
		ModelAndView modelAndView= new ModelAndView("contact_form");
		Contact contact= new Contact();
		modelAndView.addObject("contact",contact);
		return modelAndView;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute("newContact") Contact newContact,HttpServletRequest req)
	{
		ModelAndView model = new  ModelAndView("redirect:/");
		
				contactDao.saveContact(newContact);
		
		return model;
	}
	
	@RequestMapping(value = "/edit")
	public ModelAndView editContact(@RequestParam int id,HttpServletRequest req)
	{
			
		ModelAndView model = new ModelAndView("edit_form");
		System.out.println(id);
		//model.addObject("contact",cont);
		String name = req.getParameter("name");
		String email= req.getParameter("email");
		String address= req.getParameter("address");
		String phoneNumber= req.getParameter("phoneNumber");
		System.out.println(name+ " -> "+ email+ " -> "+address + " -> "+phoneNumber);
		if(name!=null && email!=null && address!=null && phoneNumber!=null)
		{
			System.out.println("********* "+name+ " -> "+ email+ " -> "+address + " -> "+phoneNumber);
			Contact newContact = new Contact(id,name,email,address,phoneNumber);
			contactDao.updateContact(newContact);
		}
		return model;
	}
	
	@RequestMapping(value = "/redirect")
	   public ModelAndView redirect() {
		ModelAndView model = new ModelAndView("redirect:/");
		return model;
	   }

	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteContact(@RequestParam int id)
	{
			
		ModelAndView model = new ModelAndView("redirect:/");
		contactDao.deleteContact(id);
		return model;
	}
}
