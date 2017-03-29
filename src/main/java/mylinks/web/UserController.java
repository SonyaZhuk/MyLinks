package mylinks.web;

import mylinks.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import mylinks.service.SecurityService;
import mylinks.service.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @RequestMapping(value = "/registrationuser", method = RequestMethod.POST)
    public String registration(Model model, String error, User user) {
        try {
            userService.save(user);
        } catch (Exception e) {
            return "registration";
        }
        return "login";
    }


    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration() {
        return "registration";
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {

        return "welcome";
    }


}
