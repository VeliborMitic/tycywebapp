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
import nastycraft.model.Voting;
import nastycraft.service.VotingService;

 
@Controller
public class VoteController {
	
	private static boolean allowUpdateVoting = false;
	 
	 @Autowired
	 private VotingService votingService;
	 
	   
	 
  
	//voting methods
     @GetMapping("/newvote")
     public String newVote(HttpServletRequest request) {
         return "/newvote";
     }
      
     @PostMapping("/savevote")
     public String saveVote(@ModelAttribute Voting vote,BindingResult bindingResult,HttpServletRequest request,RedirectAttributes attributes){
        
         if(votingService.findAll().size() < 4 || allowUpdateVoting == true) {
         	votingService.saveVoting(vote);
         	attributes.addFlashAttribute("addedv", true);
         }
         else {
        	 attributes.addFlashAttribute("addNoMoreVote", true);
         }
         
         allowUpdateVoting = false;
         request.setAttribute("votingList", votingService.findAll());
          
         return "redirect:" + "/votecp";
     }
     
     @GetMapping("/updatevoting")
     public String updateVote(@RequestParam int id,HttpServletRequest request){
         request.setAttribute("voteup", votingService.findOneVoting(id));
         allowUpdateVoting = true;

         return "/newvote";
     }
      
     @GetMapping("/deletevoting")
     public String deleteVote(@RequestParam int id,HttpServletRequest request,RedirectAttributes attributes){
         votingService.deleteVoting(id);
         request.setAttribute("votingList", votingService.findAll()); 
         attributes.addFlashAttribute("deletedv", true);

         return "redirect:" + "/votecp";
     }
     
     @GetMapping("/votecp")
     public String votecp(HttpServletRequest request) {
     	  request.setAttribute("votingList", votingService.findAll()); 
         return "/votecp";
     }
     
     
    
  
}