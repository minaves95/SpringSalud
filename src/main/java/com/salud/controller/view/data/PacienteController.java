package com.salud.controller.view.data;

import com.salud.model.Paciente;
import com.salud.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/salud/paciente")
public class PacienteController {

   @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }

    @RequestMapping("/visualizar")
    public String showAllPacientes(final Model model) {

        model.addAttribute("pacientes", findAll());

        return "table_paciente";
    }

    @RequestMapping("/tableCodAr")
    public String showPaciente(@RequestParam("codAr") int codAr, final Model model) {
        model.addAttribute("pacientes", pacienteRepository.findByCodAr(codAr));
        return "table_paciente";
    }

    @RequestMapping("/tableParams")
    public String showPacienteComprobado(@RequestParam("codAr") int codAr, @RequestParam("dni") String dni ,
                                         @RequestParam("telefono") String telefono, final Model model) {
        model.addAttribute("pacientes", pacienteRepository.findByCodArAndDniAndTelefono(codAr, dni, telefono));
        return "table_paciente";
    }
}
