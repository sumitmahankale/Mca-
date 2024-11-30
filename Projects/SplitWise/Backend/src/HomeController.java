package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Model.UserCreation;
import com.Service.SplitwiseService;

@Controller
public class HomeController {

	@Autowired
	private SplitwiseService service; 
	
	@RequestMapping("/")
	private String LandingPage()
	{
		return "Index";
	}
	
	@RequestMapping("/createaccount")
	private String CreateAccountPage()
	{
		return "CreateAccount";
	}
	@RequestMapping("forgotpass")
	private String ForgotPassWordPage()
	{
		return "ForgotPass";
	}
	@RequestMapping("/createnewuser")
	private String CreateNewUSer(@ModelAttribute UserCreation usercreation)
	{
		service.SaveUser(usercreation);
		return "CreateAccount";
	}
	
}
