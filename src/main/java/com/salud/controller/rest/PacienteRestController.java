package com.salud.controller.rest;

import com.salud.model.Paciente;
import com.salud.service.PacienteService;
import com.salud.utils.exception.EntityIdMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salud/api/paciente")
public class PacienteRestController {

    @Autowired
    PacienteService pacienteService;

    @Autowired
    public void PacienteService(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    /* ----------------- Get Data ------------------ */
    @GetMapping("")
    public List<Paciente> findAll() {
        return pacienteService.findAll();
    }

    @GetMapping("/{codAr}")
    public Paciente findByCodAr(@PathVariable Integer codAr) {
        return pacienteService.findByCodAr(codAr);
    }

    @GetMapping("/dni={dni}")
    public Paciente findByDni(@PathVariable String dni) {
        return pacienteService.findByDni(dni);
    }

    @GetMapping("/nombre={nombreCompleto}")
    public List<Paciente> findByNombre(@PathVariable String nombreCompleto) {
        return pacienteService.findByNombre(nombreCompleto);
    }

    @GetMapping("/telefono={telefono}")
    public List<Paciente> findByTelefono(@PathVariable String telefono) {
        return pacienteService.findByTelefono(telefono);
    }

    @GetMapping("/domicilio={domicilio}")
    public List<Paciente> findByDomicilio(@PathVariable String domicilio) {
        return pacienteService.findByDomicilio(domicilio);
    }

    @GetMapping("/localidad={localidad}")
    public List<Paciente> findByLocalidad(@PathVariable String localidad) {
        return pacienteService.findByLocalidad(localidad);
    }

    @GetMapping("/provincia={provincia}")
    public List<Paciente> findByProvincia(@PathVariable String provincia) {
        return pacienteService.findByProvincia(provincia);
    }

    @GetMapping("/CP={codPostal}")
    public List<Paciente> findByCodPostal(@PathVariable String codPostal) {
        return pacienteService.findByCodPostal(codPostal);
    }

    @GetMapping("/nacionalidad={nacionalidad}")
    public List<Paciente> findByNacionalidad(@PathVariable String nacionalidad) {
        return pacienteService.findByNacionalidad(nacionalidad);
    }

    @GetMapping("/vacunado={vacunado}")
    public List<Paciente> findByVacunado(@PathVariable boolean vacunado) {
        return pacienteService.findByVacunado(vacunado);
    }

    @GetMapping("/comprobar/{codAr},{dni},{telefono}")
    public boolean findByCodArAndDniAndTelefono(@PathVariable("codAr") int codAr, @PathVariable("dni") String dni, @PathVariable("telefono") String telefono) {
        if (pacienteService.findByCodArAndDniAndTelefono(codAr, dni, telefono) != null){
            return true;
        }
        return false;
    }

    /* ----------------- Request Data ------------------ */
    @RequestMapping(value = "/comprobarPaciente", method = RequestMethod.GET)
    public boolean findPacienteByCodArAndDniAndTelefono(@RequestParam("codAr") int codAr, @RequestParam("dni") String dni,
                                                 @RequestParam("telefono") String telefono) {
        if (pacienteService.findByCodArAndDniAndTelefono(codAr, dni, telefono) != null) {
            return true;
        }
        return false;
    }

    @RequestMapping(value = "/buscarPorCodigo"
            , produces = "application/json;charset=UTF-8"
            , method = RequestMethod.GET)
    public Paciente findPacienteByCodAr(@RequestParam("codAr") int codAr) {
        return pacienteService.querySelectByCodAr(codAr);
    }

    @RequestMapping(value = "/buscarPorDni"
            , produces = "application/json;charset=UTF-8"
            , method = RequestMethod.GET)
    public Paciente findPacienteByDni(@RequestParam("dni") String dni) {
        return pacienteService.findByDni(dni);
    }

    @RequestMapping(value = "/buscarPorLocalidad"
            , produces = "application/json;charset=UTF-8"
            , method = RequestMethod.GET)
    public List<Paciente> findPacienteByLocalidad(@RequestParam("localidad") String localidad) {
        return pacienteService.findByLocalidad(localidad);
    }

    @RequestMapping(value = "/buscarPorNacionalidad"
            , produces = "application/json;charset=UTF-8"
            , method = RequestMethod.GET)
    public List<Paciente> findPacienteByNacionalidad(@RequestParam("nacionalidad") String nacionalidad) {
        return pacienteService.findByNacionalidad(nacionalidad);
    }

    @RequestMapping(value = "/buscarPorVacunado"
            , produces = "application/json;charset=UTF-8"
            , method = RequestMethod.GET)
    public List<Paciente> findPacienteByVacunado(@RequestParam("vacunado") boolean vacunado) {
        return pacienteService.findByVacunado(vacunado);
    }

    /* ----------------- Insertar Data ------------------ */
    @PostMapping("/add")
    public void addPaciente(@RequestBody Paciente paciente) {
        try {
            pacienteService.addPaciente(paciente);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/insert={dni},{nombreCompleto},{fechaNacimiento},{telefono},{domicilio},{localidad},{provincia},{codPostal},{nacionalidad},{vacunado}")
    public void insertCentro(@PathVariable String dni, @PathVariable String nombreCompleto, @PathVariable String fechaNacimiento,
                             @PathVariable String telefono, @PathVariable String domicilio, @PathVariable String localidad,
                             @PathVariable String provincia, @PathVariable String codPostal, @PathVariable String nacionalidad,
                             @PathVariable boolean vacunado) {
        pacienteService.quertInsert(dni, nombreCompleto, fechaNacimiento, telefono, domicilio, localidad, provincia, codPostal, nacionalidad, vacunado);
    }

    /* ----------------- Delete Data ------------------ */
    @DeleteMapping("/delete")
    public void delete(@RequestBody Paciente paciente) {
        try {
            pacienteService.deletePaciente(paciente);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping("/delete={codAr}")
    public void deletePaciente(@PathVariable int codAr) {
        try {
            pacienteService.queryDeleteByCodAr(codAr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* ----------------- Update Data ------------------ */
    @PutMapping("/update")
    public void update(@RequestBody Paciente paciente) {
        try {
            if (pacienteService.findByCodAr(paciente.getCodAr()) != null) {
                pacienteService.addPaciente(paciente);
            } else {
                throw new EntityIdMismatchException();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PutMapping("/update={codAr},{dni},{nombreCompleto},{fechaNacimiento},{telefono},{domicilio},{localidad},{provincia},{codPostal},{nacionalidad},{vacunado}")
    public void updatePaciente(@PathVariable int codAr, @PathVariable String dni, @PathVariable String nombreCompleto, @PathVariable String fechaNacimiento,
                               @PathVariable String telefono, @PathVariable String domicilio, @PathVariable String localidad, @PathVariable String provincia,
                               @PathVariable String codPostal, @PathVariable String nacionalidad, @PathVariable boolean vacunado) {
        try {
            if (pacienteService.findByCodAr(codAr) != null) {
                pacienteService.queryUpdateByCodAr(codAr, dni, nombreCompleto, fechaNacimiento, telefono, domicilio, localidad, provincia, codPostal, nacionalidad, vacunado);
            } else {
                throw new EntityIdMismatchException();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
