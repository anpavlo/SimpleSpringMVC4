package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.FacebookService;
import social.FacebookFriend;
import social.FacebookFriends;

@Controller
public class StartController {

    @Autowired
    private FacebookService facebookService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
	public String start(Model model){
		model.addAttribute("friendsList", facebookService.getAllFriends());
		return "startPage";
	}

    @RequestMapping(value = "/getXML", method = RequestMethod.GET)
    @ResponseBody
    public FacebookFriends getXML(){
        return new FacebookFriends(facebookService.getAllFriends());
    }
	
	@RequestMapping(value = "/sayhello", method = RequestMethod.GET)
    public String sayHello(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
	    return "sayhello";
    }

}
