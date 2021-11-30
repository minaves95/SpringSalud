package com.salud.controller.view;

import com.salud.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CitacionController {

    @Autowired
    MedicoService medicoService;

    @Autowired
    public void MedicoService(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @GetMapping("/salud/citacion")
    public String showView(final Model model) {

        model.addAttribute("medicos", medicoService.findAll());
        return "citacion";
    }

}
