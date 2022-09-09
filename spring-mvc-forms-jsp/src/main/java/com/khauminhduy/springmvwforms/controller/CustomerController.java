package com.khauminhduy.springmvwforms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.khauminhduy.springmvwforms.domain.Customer;
import com.khauminhduy.springmvwforms.validator.CustomerValidator;

import jakarta.validation.Valid;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerValidator customerValidator;

	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public ModelAndView showForm() {
		return new ModelAndView("customerHome", "customer", new Customer());
	}

	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public String submit(@Valid @ModelAttribute("customer") Customer customer, BindingResult result, ModelMap model) {
		customerValidator.validate(customer, result);
		if(result.hasErrors()) {
			return "error";
		}
		model.addAttribute("customerId", customer.getCustomerId());
		model.addAttribute("customerName", customer.getCustomerName());
		model.addAttribute("customerContact", customer.getCustomerContact());
		model.addAttribute("customerEmail", customer.getCustomerEmail());
		return "customerView";
	}

}
