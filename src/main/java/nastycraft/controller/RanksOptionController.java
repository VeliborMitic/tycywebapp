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
import nastycraft.model.RanksOptions;
import nastycraft.service.RanksOptionsService;


 
@Controller
public class RanksOptionController {
	

	 @Autowired
	    private RanksOptionsService ranksOptionsService;
	
	 //ranks option methods
     @GetMapping("/newrankoption")
     public String newRankOption(HttpServletRequest request) {
         return "/newrankoption";
     }
     
     @GetMapping("/rankoptioncp")
     public String rankoptioncp(HttpServletRequest request) {
   	  request.setAttribute("ranksOptionsList", ranksOptionsService.findAll()); 
         return "/rankoptioncp";
     }
     
     @PostMapping("/saveranksoption")
     public String saveRanksOption(@ModelAttribute RanksOptions rankOption,BindingResult bindingResult,HttpServletRequest request,RedirectAttributes attributes){
        
   	  if(rankOption.getHelper() == null) {
   		  rankOption.setHelper("red");
   	  }
   	  if(rankOption.getModerator() == null) {
   		  rankOption.setModerator("red");
   	  }
   	  if(rankOption.getAdmin() == null) {
   		  rankOption.setAdmin("red");
   	  }
   	  if(rankOption.getOperator() == null) {
   		  rankOption.setOperator("red");
   	  }
   	  
        ranksOptionsService.saveRankOption(rankOption);
        attributes.addFlashAttribute("addedr", true);

   	request.setAttribute("ranksOptionsList", ranksOptionsService.findAll());

       return "redirect:" + "/rankoptioncp";
     }
     
     @GetMapping("/updaterankoption")
     public String updateRanksOption(@RequestParam int id,HttpServletRequest request,RedirectAttributes attributes){
         request.setAttribute("rankOptionsup", ranksOptionsService.findOneRank(id));       
         
         attributes.addFlashAttribute("addedr", true);
         return "redirect:" + "/newrankoption";
     }
     
     @GetMapping("/deleterankoption")
     public String deleteRanksOptions(@RequestParam int id,HttpServletRequest request,RedirectAttributes attributes){
         ranksOptionsService.deleteRankOption(id);
         request.setAttribute("ranksOptionsList", ranksOptionsService.findAll());
         
         attributes.addFlashAttribute("deletedr", true);
         return "redirect:" + "/rankoptioncp";
     }
    
}