package nastycraft.controller;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import nastycraft.service.EmailServiceImpl;
import nastycraft.service.HashsessionService;

 
@Controller
public class SendnewsletterController {
     
    @Autowired
    private EmailServiceImpl emailserviceimpl;
    
    @Autowired
	private HashsessionService hashsessionservice;

       //email methods
        @GetMapping("/newsletter")
        public String newsletter(HttpServletRequest request,HttpSession session) {
        	if(hashsessionservice.verifyLogIn(session,request)){
        	request.setAttribute("emailsavailable", emailserviceimpl.howManyEmails());
            return "/newsletter";
            
        	 }else {
      			return "redirect:" + "/errorlogin";
      		}
        }
         
        @PostMapping("/sendnewsletter")
        public String sendnewsletter(@RequestParam String subject,@RequestParam String textarea,HttpServletRequest request,RedirectAttributes attributes,HttpSession session){
        	if(hashsessionservice.verifyLogIn(session,request)){
        		
        	if(subject.equals("") || textarea.equals("")) {
        		attributes.addFlashAttribute("emptyFields", true);
        	}else {
        		emailserviceimpl.setSubject(subject);
            	emailserviceimpl.setTextarea(textarea);
            	emailserviceimpl.sendEmails();
            	
            	attributes.addFlashAttribute("send", true);
        	}
        	
            return "redirect:" + "/newsletter";
            
        	 }else {
      			return "redirect:" + "/errorlogin";
      		}
        }
            
   
          
          
        
}