package nastycraft.controller;
 
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import nastycraft.model.Forum;
import nastycraft.service.ForumService;

 
@Controller
public class ForumController {

	 
    @Autowired
    private ForumService forumService;
	 
     
   //forum methods
     @GetMapping("/newforum")
     public String editForum(HttpServletRequest request) {
         return "/newforum";
     }
      
     @GetMapping("/forumcp")
     public String forumcp(HttpServletRequest request) {
         request.setAttribute("linkk", forumService.findAll()); 
         return "/forumcp";
     }
      
     @PostMapping("/saveforum")
     public String saveForum(@ModelAttribute Forum forum,BindingResult bindingResult,HttpServletRequest request,RedirectAttributes attributes){
         forumService.saveForumLinks(forum);
         request.setAttribute("linkk", forumService.findAll()); 
         attributes.addFlashAttribute("added", true);
          
         return "redirect:" + "/forumcp";
     }
      
     @GetMapping("/updateforum")
     public String updateForum(@RequestParam int id,HttpServletRequest request){
         request.setAttribute("links", forumService.findOne(id));
         return "/newforum";
     }
      
     @GetMapping("/deleteforum")
     public String deleteForumLinks(@RequestParam int id,HttpServletRequest request,RedirectAttributes attributes){
         forumService.deleteForumLinks(id);
         request.setAttribute("linkk", forumService.findAll()); 
         attributes.addFlashAttribute("added", true);

         return "redirect:" + "/forumcp";
     }
      
     
    
     
    
  
}