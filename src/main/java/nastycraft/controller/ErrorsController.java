package nastycraft.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ErrorsController implements ErrorController{

private static final String PATH ="/error";
	
	
	@Override
	public String getErrorPath() {
		
		return PATH;
	}
	
	@GetMapping("/error")
	public String errors(HttpServletRequest request) {
		
		 String errorMsg = "";
	        int httpErrorCode = getErrorCode(request);
	 
	        switch (httpErrorCode) {
	            case 400: {
	                errorMsg = "400. Bad Request";
	                break;
	            }
	            case 401: {
	                errorMsg = "401. Unauthorized";
	                break;
	            }
	            case 404: {
	                errorMsg = "404. Page not found";
	                break;
	            }
	            case 500: {
	                errorMsg = "500. Internal Server Error";
	                break;
	            }
	        }
		
	        request.setAttribute("errormsg", errorMsg);
	        
			return "/error";
			
	}
		
	private int getErrorCode(HttpServletRequest httpRequest) {
        return (Integer) httpRequest
          .getAttribute("javax.servlet.error.status_code");
    }
}