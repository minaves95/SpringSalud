package com.salud.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/salud")
public class LoginController {

    /*@GetMapping("/login")
    public String showView(final Model model) {

        return "login";
    }*/

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public ModelAndView showViewLogin() {
        ModelAndView model = new ModelAndView();
        model.setViewName("login");
        return model;
    }
}
