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
import nastycraft.model.Forum;
import nastycraft.service.ForumService;
import nastycraft.service.HashsessionService;

@Controller
public class ForumController {

	@Autowired
	private ForumService forumService;

	@Autowired
	private HashsessionService hashsessionservice;

	// forum methods
	@GetMapping("/newforum")
	public String editForum(HttpSession session,HttpServletRequest request) {
		if (hashsessionservice.verifyLogIn(session,request)) {
			return "/newforum";
		} else {
			return "redirect:" + "/errorlogin";
		}

	}

	@GetMapping("/forumcp")
	public String forumcp(HttpServletRequest request, HttpSession session) {
		if (hashsessionservice.verifyLogIn(session,request)) {
			request.setAttribute("linkk", forumService.findAll());
			return "/forumcp";
		} else {
			return "redirect:" + "/errorlogin";
		}
	}

	@PostMapping("/saveforum")
	public String saveForum(@ModelAttribute Forum forum, BindingResult bindingResult, HttpServletRequest request,
			RedirectAttributes attributes, HttpSession session) {
		if (hashsessionservice.verifyLogIn(session,request)) {

			forumService.saveForumLinks(forum);
			request.setAttribute("linkk", forumService.findAll());

			attributes.addFlashAttribute("added", true);

			return "redirect:" + "/forumcp";

		} else {
			return "redirect:" + "/errorlogin";
		}
	}

	@GetMapping("/updateforum")
	public String updateForum(@RequestParam int id, HttpServletRequest request, HttpSession session) {

		if (hashsessionservice.verifyLogIn(session,request)) {

			request.setAttribute("links", forumService.findOne(id));
			return "/newforum";

		} else {
			return "redirect:" + "/errorlogin";
		}
	}

	@GetMapping("/deleteforum")
	public String deleteForumLinks(@RequestParam int id, HttpServletRequest request, RedirectAttributes attributes,
			HttpSession session) {
		if (hashsessionservice.verifyLogIn(session,request)) {

			forumService.deleteForumLinks(id);
			request.setAttribute("linkk", forumService.findAll());

			attributes.addFlashAttribute("added", true);

			return "redirect:" + "/forumcp";

		} else {
			return "redirect:" + "/errorlogin";
		}
	}

}