package nastycraft.controller;
 
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import nastycraft.service.EmailServiceImpl;

 
@Controller
public class SendnewsletterController {
     
    @Autowired
    private EmailServiceImpl emailserviceimpl;

       //email methods
        @GetMapping("/newsletter")
        public String newsletter(HttpServletRequest request) {
        	request.setAttribute("emailsavailable", emailserviceimpl.howManyEmails());
            return "/newsletter";
        }
         
        @PostMapping("/sendnewsletter")
        public String sendnewsletter(@RequestParam String subject,@RequestParam String textarea,HttpServletRequest request,RedirectAttributes attributes){
        	
        	if(subject.equals("") || textarea.equals("")) {
        		attributes.addFlashAttribute("emptyFields", true);
        	}else {
        		emailserviceimpl.setSubject(subject);
            	emailserviceimpl.setTextarea(textarea);
            	
            	emailserviceimpl.sendEmails();
            	
            	attributes.addFlashAttribute("send", true);
        	}
        	
            return "redirect:" + "/newsletter";
        }
            
   
          
          
        
}