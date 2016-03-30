package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import service.UserService;

@Controller
public class StartController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String start(){
        return "startPage";
	}
	
	@RequestMapping(value = "/sayhello", method = RequestMethod.GET)
    public String sayHello(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
	    return "sayhello";
    }

}
