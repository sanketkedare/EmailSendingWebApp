package com.becoder.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.becoder.model.Email;
import com.becoder.service.EmailService;
@Controller
public class HomeController
{
	@Autowired
	private EmailService emailService;

	@GetMapping("/")
	public String index()
	{
		return "index";
	}
	
	@PostMapping("/sendMail")
	public String sendMAil(@ModelAttribute Email email, HttpSession session)
	{
		System.out.println(email);
		
		emailService.sendMail(email);
		session.setAttribute("msg", "Email send Sucessfully");
		
		return "redirect:/";
	}
}
