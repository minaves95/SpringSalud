package com.salud.controller.view.data;


import com.salud.model.Centro;
import com.salud.service.CentroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller()
@RequestMapping("/salud/centro")
public class CentroController {

    @Autowired
    CentroService centroService;

    @Autowired
    public void CentroService(CentroService centroService) {
        this.centroService = centroService;
    }

    public List<Centro> findAll() {
        return centroService.findAll();
    }

    @RequestMapping("/visualizar")
    public String showAllCentros(final Model model, @RequestParam(defaultValue = "") String data){

        model.addAttribute("centros", findAll());

        return "table_centro";
    }

}
