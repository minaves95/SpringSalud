package com.salud.controller.view;

import com.salud.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/salud")
public class RegisterController {

    @Autowired
    PacienteRepository pacienteRepository;

    @RequestMapping("/register")
    public String showViewRegister(final Model model) {

        /*model.addAttribute("", attribute)*/

        return "register";
    }

    /*@RequestMapping(value = {"/register"}, method = RequestMethod.GET)
    public ModelAndView showView() {
        ModelAndView model = new ModelAndView();
        model.setViewName("register");
        return model;
    }*/

}
