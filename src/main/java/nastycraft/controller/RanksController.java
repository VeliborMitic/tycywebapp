package nastycraft.controller;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import nastycraft.model.Ranks;
import nastycraft.service.HashsessionService;
import nastycraft.service.RanksService;

 
@Controller
public class RanksController {
	
	 private static boolean allowUpdateRanks = false;
	
	   @Autowired
	   private RanksService ranksService;
	   @Autowired
		private HashsessionService hashsessionservice;
	
	//ranks methods
    @GetMapping("/ranks")
    public String newRank(HttpServletRequest request,HttpSession session) {
    	if(hashsessionservice.verifyLogIn(session,request)){
        return "/ranks";
    	}else {
			return "redirect:" + "/errorlogin";
		}
    }
   
    
    @PostMapping("/saveranks")
    public String saveRanks(@ModelAttribute Ranks rank,BindingResult bindingResult,HttpServletRequest request,RedirectAttributes attributes,HttpSession session){
    	if(hashsessionservice.verifyLogIn(session,request)){
    	if(ranksService.findAll().size() < 4 || allowUpdateRanks == true) {
        	ranksService.saveRank(rank);
        	attributes.addFlashAttribute("addedr", true);
        }
        else {
        	attributes.addFlashAttribute("addNoMore", true);
        }
        
      allowUpdateRanks = false;
  	  request.setAttribute("ranksList", ranksService.findAll());
  	  
      return "redirect:" + "/rankscp";
    	}else {
			return "redirect:" + "/errorlogin";
		}
    }
    
    @GetMapping("/updateranks")
    public String updateRanks(@RequestParam int id,HttpServletRequest request,HttpSession session){
    	if(hashsessionservice.verifyLogIn(session,request)){
        request.setAttribute("ranksup", ranksService.findOneRank(id));       
        allowUpdateRanks = true;
        
        return "/ranks";
        
    	}else {
			return "redirect:" + "/errorlogin";
		}
    }
    
    @GetMapping("/deleteranks")
    public String deleteRanks(@RequestParam int id,HttpServletRequest request,RedirectAttributes attributes,HttpSession session){
    	if(hashsessionservice.verifyLogIn(session,request)){
    	ranksService.deleteRank(id);
        request.setAttribute("ranksList", ranksService.findAll()); 
        attributes.addFlashAttribute("deletedr", true);
        return "redirect:" + "/rankscp";
        
    	}else {
			return "redirect:" + "/errorlogin";
		}
    }
    
    @GetMapping("/rankscp")
    public String rankcp(HttpServletRequest request,HttpSession session) {
    	if(hashsessionservice.verifyLogIn(session,request)){ 
    	request.setAttribute("ranksList", ranksService.findAll()); 
        return "/rankscp";
        
    	}else {
			return "redirect:" + "/errorlogin";
		}
    }
    
}