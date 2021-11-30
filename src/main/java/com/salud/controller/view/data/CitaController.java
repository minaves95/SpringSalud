package com.salud.controller.view.data;

import com.salud.model.Centro;
import com.salud.model.Cita;
import com.salud.model.Medico;
import com.salud.model.Paciente;
import com.salud.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.datatype.XMLGregorianCalendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller()
@RequestMapping("/salud")
public class CitaController {

    @Autowired
    private CitaRepository citaRepository;

    public List<Cita> findAll() {
        return citaRepository.findAll();
    }

    @RequestMapping("/cita/visualizar")
    public String showAllCentros(final Model model) {
        List<Medico> medicos = new ArrayList<>();
        List<Paciente> pacientes = new ArrayList<>();
        for(int i = 0; i < findAll().size(); i++){
            medicos.add(findAll().get(i).getMedico());
            pacientes.add(findAll().get(i).getPaciente());
        }

        model.addAttribute("medicos", medicos);
        model.addAttribute("pacientes", pacientes);
        model.addAttribute("citas", findAll());

        return "table_cita";
    }
}