package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage() {
        return "user/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET, params = "error")
    public String showLoginErrorPage(@RequestParam("error") String error) {
        return "user/login";
    }
}
