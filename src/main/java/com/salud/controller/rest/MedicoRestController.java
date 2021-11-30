package com.salud.controller.rest;

import com.salud.model.Medico;
import com.salud.service.CentroService;
import com.salud.service.MedicoService;
import com.salud.utils.exception.EntityIdMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salud/api/medico")
public class MedicoRestController {


    @Autowired
    MedicoService medicoService;

    @Autowired
    CentroService centroService;

    @Autowired
    public void MedicoService(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @Autowired
    public void CentroService(CentroService centroService) {
        this.centroService = centroService;
    }

    /* ----------------- Get Data ------------------ */
    @GetMapping
    public List<Medico> findAll() {
        return medicoService.findAll();
    }

    @GetMapping("/{codMedico}")
    public Medico findByCodMedico(@PathVariable Integer codMedico) {
        return medicoService.findByCodMedico(codMedico);
    }

    @GetMapping("/nombre={nombreCompleto}")
    public List<Medico> findByNombre(@PathVariable String nombreCompleto) {
        return medicoService.findByNombreCompleto(nombreCompleto);
    }

    @GetMapping("/telefonoConsulta={telefono}")
    public List<Medico> findByTelefonoConsulta(@PathVariable String telefono) {
        return medicoService.findByTelefonoConsulta(telefono);
    }

    @GetMapping("/telefonoPrivado={telefono}")
    public List<Medico> findByTelefonoPrivado(@PathVariable String telefono) {
        return medicoService.findByTelefonoPrivado(telefono);
    }

    @GetMapping("/domicilio={domicilio}")
    public List<Medico> findByDomicilio(@PathVariable String domicilio) {
        return medicoService.findByDomicilio(domicilio);
    }

    @GetMapping("/centro={codCentro}")
    public List<Medico> findByCentro(@PathVariable Integer codCentro) {
        return medicoService.findByCentro(centroService.findByCodCentro(codCentro));
    }

    /* ----------------- Request Data ------------------ */
    @RequestMapping(value = "/buscarPorCodigo"
            , produces = "application/json;charset=UTF-8"
            , method = RequestMethod.GET)
    public Medico findMedicoByCodMedico(@RequestParam("codMedico") int codMedico) {
        return medicoService.querySelectByCodMedico(codMedico);
    }

    @RequestMapping(value = "/buscarPorLocalidad"
            , produces = "application/json;charset=UTF-8"
            , method = RequestMethod.GET)
    public List<Medico> findMedicoByLocalidad(@RequestParam("localidad") String localidad) {
        return medicoService.findByLocalidad(localidad);
    }

    @RequestMapping(value = "/buscarPorProvincia"
            , produces = "application/json;charset=UTF-8"
            , method = RequestMethod.GET)
    public List<Medico> findMedicoByProvincia(@RequestParam("provincia") String provincia) {
        return medicoService.findByProvincia(provincia);
    }

    @RequestMapping(value = "/buscarPorNacionalidad"
            , produces = "application/json;charset=UTF-8"
            , method = RequestMethod.GET)
    public List<Medico> findMedicoByNacionalidad(@RequestParam("nacionalidad") String nacionalidad) {
        return medicoService.findByNacionalidad(nacionalidad);
    }

    @RequestMapping(value = "/buscarPorVacunado"
            , produces = "application/json;charset=UTF-8"
            , method = RequestMethod.GET)
    public List<Medico> findMedicoByVacunado(@RequestParam("vacunado") boolean vacunado) {
        return medicoService.findByVacunado(vacunado);
    }

    /* ----------------- Insertar Data ------------------ */
    @PostMapping("/add")
    public void addMedico(@RequestBody Medico medico) {
        try {
            if (centroService.findByCodCentro(medico.getCentro().getCodCentro()) != null){
                medicoService.addMedico(medico);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/insert={nombreCompleto},{fechaNacimiento},{telefonoConsulta},{telefonoPrivado},{domicilio},{localidad},{provincia},{codPostal},{nacionalidad},{vacunado},{codCentro}")
    public void insertMedico(@PathVariable String nombreCompleto, @PathVariable String fechaNacimiento, @PathVariable String telefonoConsulta,
                             @PathVariable String telefonoPrivado, @PathVariable String domicilio, @PathVariable String localidad, @PathVariable String provincia,
                             @PathVariable String codPostal, @PathVariable String nacionalidad, @PathVariable boolean vacunado, @PathVariable Integer codCentro) {
        if (centroService.findByCodCentro(codCentro) != null){
            medicoService.queryInsert(nombreCompleto, fechaNacimiento, telefonoConsulta, telefonoPrivado, domicilio, localidad,
                    provincia, codPostal, nacionalidad, vacunado, codCentro);
        }
    }

    /* ----------------- Delete Data ------------------ */
    @DeleteMapping("/delete")
    public void delete(@RequestBody Medico medico) {
        try {
            medicoService.deleteMedico(medico);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping("/delete={codMedico}")
    public void deleteMedico(@PathVariable int codMedico) {
        try {
            medicoService.queryDeleteByCodMedico(codMedico);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* ----------------- Update Data ------------------ */
    @PutMapping("/update")
    public void update(@RequestBody Medico medico) {
        try {
            if (medicoService.findByCodMedico(medico.getCodMedico()) != null && centroService.findByCodCentro(medico.getCentro().getCodCentro()) != null) {
                medicoService.addMedico(medico);
            } else {
                throw new EntityIdMismatchException();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PutMapping("/update={codMedico},{nombreCompleto},{fechaNacimiento},{telefonoConsulta},{telefonoPrivado},{domicilio},{localidad},{provincia},{codPostal},{nacionalidad},{vacunado},{codCentro}")
    public void updateMedico(@PathVariable int codMedico, @PathVariable String nombreCompleto, @PathVariable String fechaNacimiento, @PathVariable String telefonoConsulta,
                             @PathVariable String telefonoPrivado, @PathVariable String domicilio, @PathVariable String localidad, @PathVariable String provincia,
                             @PathVariable String codPostal, @PathVariable String nacionalidad, @PathVariable boolean vacunado, @PathVariable Integer codCentro) {
        try {
            if (medicoService.findByCodMedico(codMedico) != null && centroService.findByCodCentro(codCentro) != null) {
                medicoService.queryUpdateByCodMedico(codMedico, nombreCompleto, fechaNacimiento, telefonoConsulta, telefonoPrivado, domicilio, localidad,
                        provincia, codPostal, nacionalidad, vacunado, codCentro);
            } else {
                throw new EntityIdMismatchException();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
