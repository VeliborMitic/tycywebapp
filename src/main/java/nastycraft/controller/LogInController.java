package nastycraft.controller;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import nastycraft.model.Hashsession;
import nastycraft.service.HashsessionService;

import nastycraft.service.UserService;


 
@Controller
public class LogInController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private HashsessionService hashsessionservice;
	
	
	 
	@GetMapping("/nasticraftcmslogin")
	public String home(HttpServletRequest request) {
		return "/nasticraftcmslogin";
	}

	public void checkIfExist(String name) {
		if(hashsessionservice.returnName(name) != "") {
			hashsessionservice.deleteHashSessionByName(name);
		}
	}
	
	
	@PostMapping("/login-user")
	public String loginUser(@RequestParam String name, @RequestParam String password, HttpServletRequest request,HttpSession session, RedirectAttributes attributes) {
			checkIfExist(name);
		if (userService.checkPassAndUser(name, password)) {
			 String hashString = hashsessionservice.hashString();
			 
			 Hashsession hashsession = new Hashsession(name,hashString,hashsessionservice.getIp(request));
			 hashsessionservice.saveHash(hashsession);

			session.setAttribute("loginsession", hashString);
			session.setAttribute("username", name);

			return "redirect:" + "/admincp";

		} else {
			attributes.addFlashAttribute("wrong_password", true);
			return "redirect:" + "/nasticraftcmslogin";
		}
	}

	@GetMapping("/logOut")
	public String logOut(RedirectAttributes attributes, HttpServletRequest request, HttpSession session) {
		hashsessionservice.deleteHashSessionByName((String)session.getAttribute("username"));
		session.removeAttribute("loginsession");
		session.removeAttribute("username");
		
		attributes.addFlashAttribute("log_out", true);
		return "redirect:" + "/nasticraftcmslogin";
	}

	
     
    
  
}