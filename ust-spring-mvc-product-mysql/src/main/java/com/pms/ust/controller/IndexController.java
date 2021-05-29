package com.pms.ust.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ust.pms.model.MyNumbers;
import com.ust.pms.service.MyNumbersService;

//import com.ust.pms.model.MyNumbers;
//import com.ust.pms.service.MyNumbersService;

@Controller
public class IndexController {

	@Autowired
	MyNumbersService myNumbersService;



	@RequestMapping("/index")
	public ModelAndView index(){
		String username=null;

		Object principal=SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof UserDetails) {
			username=((UserDetails)principal).getUsername();
			System.out.println("###username is :"+username);
		}
		System.out.println("###username is :"+username);
		ModelAndView view= new ModelAndView();
		view.addObject("Username","rk");
		view.addObject("password","123");

		view.setViewName("index");
		return view;
	}

	@RequestMapping("/rk")
	public String kapoor(){
		return "kapoor";
	}

	@RequestMapping("/addNumbers")
	public ModelAndView addNumbers(){
		return new ModelAndView("addNumbersForm","name","To Shopping World");
	}

	@RequestMapping("/result")
	public ModelAndView result(MyNumbers myNumbers){
		int sum=myNumbers.getFirstNumber() +myNumbers.getSecondNumber();
		myNumbers.setResult(sum);
		myNumbersService.saveNumbers(myNumbers);

		ModelAndView view=new ModelAndView();
		view.addObject("res",sum);
		view.setViewName("myresult");
		return view;	
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(Model model,String error,String logout){ {

		if(error!=null) {
			model.addAttribute("errorMsg", "Your username or Password are incorrect");
		}
		if(logout!=null) {
			model.addAttribute("msg", "You Have been sucessfuly logged out");
		}
		return "login";
	}
	}

	//register code get
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public ModelAndView register() {
		return new ModelAndView("registration","user", new UserRegistration());
	}

	@Autowired
	JdbcUserDetailsManager jdbcUserDetailsManager;

	//POST
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("user")UserRegistration userRegistration){
		{
			List<GrantedAuthority>authorities=new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

			User user=new User(userRegistration.getUsername(),userRegistration.getPassword(),authorities);
			jdbcUserDetailsManager.createUser(user);
			return new ModelAndView("login","message","you have been sucessfully register.please login to proceed");
		}


		/*
		 * @RequestMapping("/index") public ModelAndView index(){ ModelAndView view =
		 * new ModelAndView(); view.addObject("username", "Jay");
		 * view.addObject("password", "jay@123"); view.setViewName("kapoor"); return
		 * view; }
		 * 
		 * @RequestMapping("/tufail") public String kapoor(){ return "k"; }
		 * 
		 * 
		 * @RequestMapping("/addNumbers") public ModelAndView addNumbers(){ return new
		 * ModelAndView("addNumbersForm","name","tufail"); }
		 * 
		 * 
		 * @RequestMapping("/result") public ModelAndView result(MyNumbers myNumbers) {
		 * int sum = myNumbers.getFirstNumber()+ myNumbers.getSecondNumber()+
		 * myNumbers.getThirdNumber() + myNumbers.getFourNumber() +
		 * myNumbers.getFiveNumber(); myNumbers.setResult(sum);
		 * myNumbersService.saveNumbers(myNumbers);
		 * 
		 * ModelAndView view = new ModelAndView(); view.addObject("res",sum);
		 * view.setViewName("myresult"); //return new ModelAndView("result","sum",sum);
		 * return view; }
		 */
	}
}