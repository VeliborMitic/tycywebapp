package nastycraft.controller;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import nastycraft.model.Newsletter;
import nastycraft.service.ForumService;
import nastycraft.service.NewsletterService;
import nastycraft.service.RanksOptionsService;
import nastycraft.service.RanksService;
import nastycraft.service.VotingService;

@Controller
public class MainController {

	@Autowired
	private RanksService ranksService;

	@Autowired
	private ForumService forumService;

	@Autowired
	private VotingService votingService;

	@Autowired
	private RanksOptionsService ranksOptionsService;

	@Autowired
	private NewsletterService newsletterService;

	
	@GetMapping("/admincp")
	public String admincp(HttpServletRequest request, HttpSession session) {
		return "/admincp";
	}

	@GetMapping("/")
	public String homeIndex(HttpServletRequest request) {
		request.setAttribute("linkk", forumService.findAll());
		request.setAttribute("mode", "HOME_INDEX");
		request.setAttribute("display", "HOME");
		return "/nastycraft";
	}

	@GetMapping("/donations")
	public String donations(HttpServletRequest request) {
		request.setAttribute("linkk", forumService.findAll());
		request.setAttribute("ranksList", ranksService.findAll());
		request.setAttribute("ranksOptionsList", ranksOptionsService.findAll());
		request.setAttribute("mode", "HOME_INDEX");
		request.setAttribute("display", "DONATIONS");
		return "/nastycraft";
	}

	@GetMapping("/voting")
	public String voting(HttpServletRequest request) {
		request.setAttribute("linkk", forumService.findAll());
		request.setAttribute("votingList", votingService.findAll());
		request.setAttribute("mode", "HOME_INDEX");
		request.setAttribute("display", "VOTING");
		return "/nastycraft";
	}

	// newsletter messages
	@PostMapping("/savenewsletter")
	public String saveNewsletter(@ModelAttribute Newsletter email, BindingResult bindingResult,
			HttpServletRequest request, RedirectAttributes attributes) {

		String remoteAddr = "";
		if (request != null) {
			remoteAddr = request.getHeader("X-FORWARDED-FOR");
			if (remoteAddr == null || "".equals(remoteAddr)) {
				remoteAddr = request.getRemoteAddr();
			}
		}

		if (newsletterService.ipExist(remoteAddr)) {
			attributes.addFlashAttribute("ipExist", true);
		} else if (newsletterService.emailExist(email.getEmail())) {
			attributes.addFlashAttribute("emailExist", true);
		} else if (!NewsletterService.isValidEmailAddress(email.getEmail())) {
			attributes.addFlashAttribute("added", false);
		} else {
			email.setIp(remoteAddr);
			newsletterService.saveNewsletter(email);
			attributes.addFlashAttribute("added", true);
		}

		return "redirect:" + "/";
	}

}