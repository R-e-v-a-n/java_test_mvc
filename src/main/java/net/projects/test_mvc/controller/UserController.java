package net.projects.test_mvc.controller;

import net.projects.test_mvc.model.User;
import net.projects.test_mvc.service.SecurityService;
import net.projects.test_mvc.service.UserService;
import net.projects.test_mvc.validate.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller for {@link User}'s pages.
 *
 * @author Sergey Lazarev
 * @version 1.0
 */

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());

        return "redirect:/profile";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("loginForm", new User());

        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("loginForm") User loginForm, BindingResult bindingResult, Model model){

        if(securityService.autoLogin(loginForm.getUsername(), loginForm.getPassword())){
            return "redirect:/profile";
        }

        bindingResult.rejectValue("username", "Incorrect.loginForm");
        //model.addAttribute("error","Username or password is incorrect.");
        return "login";
    }

    @RequestMapping(value = "logout")
    public String logout(Model model){
        securityService.logout();
        return "redirect:/";
    }

    @RequestMapping(value = {"/", "/profile"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "profile";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        return "admin";
    }
}
