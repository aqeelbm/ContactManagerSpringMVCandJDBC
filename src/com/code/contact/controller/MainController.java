package com.code.contact.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.code.contact.dao.ContactDAO;
import com.code.contact.model.Contacts;

/**
 * @author Aqeel
 *
 */

@Controller
public class MainController {
	
	@Autowired
	private ContactDAO contactDAO;
	
	@RequestMapping(value="/")
	public ModelAndView contactList(ModelAndView model) {
		List<Contacts> contactList = contactDAO.list();
		model.addObject("contactList", contactList);
		model.setViewName("index");
		return model;
	}
	
	@RequestMapping(value="/new", method=RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		Contacts newContact = new Contacts();
		model.addObject("contact", newContact);
		model.setViewName("contact_form");
		return model;
	}

	@RequestMapping(value="/saveContact", method=RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute Contacts contact) {
		contactDAO.saveOrUpdate(contact);
		
		return new ModelAndView("redirect:/");
	}
	
	
	@RequestMapping(value = "/editContact", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
	    int contactId = Integer.parseInt(request.getParameter("id"));
	    Contacts contact = contactDAO.get(contactId);
	    ModelAndView model = new ModelAndView("contact_form");
	    model.addObject("contact", contact);
	 
	    return model;
	}
	
	
	@RequestMapping(value = "/deleteContact", method = RequestMethod.GET)
	public ModelAndView deleteContact(HttpServletRequest request) {
	    int contactId = Integer.parseInt(request.getParameter("id"));
	    contactDAO.delete(contactId);
	    return new ModelAndView("redirect:/");
	}
}