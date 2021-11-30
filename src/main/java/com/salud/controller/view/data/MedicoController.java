package com.salud.controller.view.data;

import com.salud.model.Centro;
import com.salud.model.Medico;
import com.salud.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller()
@RequestMapping("/salud/medico")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    public List<Medico> findAll() {
        return medicoRepository.findAll();
    }

    @RequestMapping("/visualizar")
    public String showAllCentros(final Model model) {
        List<Centro> centros = new ArrayList<>();
        for(int i = 0; i < findAll().size(); i++){
            centros.add(findAll().get(i).getCentro());
        }
        model.addAttribute("centros", centros);
        model.addAttribute("medicos", findAll());

        return "table_medico";
    }
}