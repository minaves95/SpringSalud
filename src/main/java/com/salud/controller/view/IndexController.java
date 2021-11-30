package com.salud.controller.view;

import com.salud.model.Cita;
import com.salud.model.Paciente;
import com.salud.service.CitaService;
import com.salud.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    PacienteService pacienteService;

    @Autowired
    public void PacienteService(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @Autowired
    CitaService citaService;

    @Autowired
    public void CitaService(CitaService citaService) {
        this.citaService = citaService;
    }

    @GetMapping("/salud/{dni}/index")
    public String showView(final Model model, @PathVariable String dni) throws ParseException {
        String view = "";
        List<Cita> miscitas = new ArrayList<>();
        for (Cita cita : citaService.findAll()) {
            if (cita.getPaciente().getDni().equals(dni)) {
                String fechaString = cita.getFechaCita() + "";
                DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
                Date date = inputFormat.parse(fechaString);
                /*DateFormat outputFormat = new SimpleDateFormat("HH:mm dd-MM-yyyy");
                String outputString = outputFormat.format(date);*/
                cita.setFechaCita(date);
                miscitas.add(cita);
            }
        }
        model.addAttribute("miscitas", miscitas);
        model.addAttribute("admin", "17460474R");
        model.addAttribute("user", dni);
        for (Paciente paciente : pacienteService.findAll()) {
            if (paciente.getDni().equals(dni)) {
                view = "index";
            }
        }
        return view;
    }

}
