package com.salud.controller.rest;

import com.salud.model.Cita;
import com.salud.model.Medico;
import com.salud.service.CitaService;
import com.salud.service.MedicoService;
import com.salud.service.PacienteService;
import com.salud.utils.exception.EntityIdMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/salud/api/cita")
public class CitaRestController {

    @Autowired
    CitaService citaService;

    @Autowired
    MedicoService medicoService;

    @Autowired
    PacienteService pacienteService;

    @Autowired
    public void CitaService(CitaService citaService) {
        this.citaService = citaService;
    }

    @Autowired
    public void MedicoService(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @Autowired
    public void PacienteService(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    /* ----------------- Get Data ------------------ */
    @GetMapping
    public List<Cita> findAll() {
        return citaService.findAll();
    }

    @GetMapping("/{codCita}")
    public Cita findByCodCita(@PathVariable Integer codCita) {
        return citaService.findByCodCita(codCita);
    }

    @GetMapping("/causa={causa}")
    public List<Cita> findByCausa(@PathVariable String causa) {
        return citaService.findByCausa(causa);
    }

    @GetMapping("/tipo={tipo}")
    public List<Cita> findByTipo(@PathVariable String tipo) {
        return citaService.findByTipo(tipo);
    }

    // To Check
    @GetMapping("/fecha={fechaCita}")
    public List<Cita> findByFecha(@PathVariable String fechaCita) {
        Date fechaDate = null;
        try {
            fechaDate = new SimpleDateFormat(("yyyy-MM-dd HH:mm:ss")).parse(fechaCita);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return citaService.findByFechaCita(fechaDate);
    }

    /*@GetMapping("/mes&dia={mesAndDia}")
    public List<Cita> findByMesAndDia(@PathVariable String mesAndDia) {
        List<Cita> coincidencias = new ArrayList<>();
        List<Cita> citas = findAll();
        for(int i = 0; i < citas.size(); i++){
            if(){

            }
        }
        return coincidencias;
    }*/

    @GetMapping("/paciente={codAr}")
    public List<Cita> findByPaciente(@PathVariable Integer codAr) {
        return citaService.findByPaciente(pacienteService.findByCodAr(codAr));
    }

    @GetMapping("/medico={codMedico}")
    public List<Cita> findByMedico(@PathVariable Integer codMedico) {
        return citaService.findByMedico(medicoService.findByCodMedico(codMedico));
    }

    /* ----------------- Request Data ------------------ */
    @RequestMapping(value = "/buscarPorCodigo"
            , produces = "application/json;charset=UTF-8"
            , method = RequestMethod.GET)
    public Cita findMedicoByCodCita(@RequestParam("codCita") int codCita) {
        return citaService.querySelectByCodCita(codCita);
    }

    /* ----------------- Insertar Data ------------------ */
    @PostMapping("/add")
    public void addCita(@RequestBody Cita cita) {
        try {
            if (pacienteService.findByCodAr(cita.getPaciente().getCodAr()) != null && medicoService.findByCodMedico(cita.getMedico().getCodMedico()) != null) {
                citaService.addCita(cita);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/insert={fechaCita},{causa},{tipo},{codAr},{codMedico}")
    public void insertCita(@PathVariable String fechaCita, @PathVariable String causa, @PathVariable String tipo,
                           @PathVariable Integer codAr, @PathVariable Integer codMedico) {
        if (pacienteService.findByCodAr(codAr) != null && medicoService.findByCodMedico(codMedico) != null) {
            citaService.queryInsert(fechaCita, causa, tipo, codAr, codMedico);
        }
    }

    /* ----------------- Delete Data ------------------ */
    @DeleteMapping("/delete")
    public void delete(@RequestBody Cita cita) {
        try {
            citaService.deleteCita(cita);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping("/delete={codCita}")
    public void deleteCita(@PathVariable int codCita) {
        try {
            citaService.queryDeleteByCodCita(codCita);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* ----------------- Update Data ------------------ */
    @PutMapping("/update")
    public void update(@RequestBody Cita cita) {
        try {
            if (citaService.findByCodCita(cita.getCodCita()) != null
                    && pacienteService.findByCodAr(cita.getPaciente().getCodAr()) != null
                    && medicoService.findByCodMedico(cita.getMedico().getCodMedico()) != null) {
                citaService.addCita(cita);
            } else {
                throw new EntityIdMismatchException();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PutMapping("/update={codCita},{fechaCita},{causa},{tipo},{codAr},{codMedico}")
    public void updateCita(@PathVariable Integer codCita, @PathVariable String fechaCita, @PathVariable String causa, @PathVariable String tipo,
                           @PathVariable Integer codAr, @PathVariable Integer codMedico) {
        try {
            if (citaService.findByCodCita(codCita) != null && pacienteService.findByCodAr(codAr) != null && medicoService.findByCodMedico(codMedico) != null) {
                citaService.queryUpdateByCodCita(codCita, fechaCita, causa, tipo, codAr, codMedico);
            } else {
                throw new EntityIdMismatchException();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
