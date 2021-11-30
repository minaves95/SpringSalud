package com.salud.controller.rest;

import com.salud.model.Centro;
import com.salud.service.CentroService;
import com.salud.utils.exception.EntityIdMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salud/api/centro")
public class CentroRestController {

    @Autowired
    CentroService centroService;

    @Autowired
    public void CentroService(CentroService centroService) {
        this.centroService = centroService;
    }

    /* ----------------- Get Data ------------------ */
    @GetMapping("")
    public List<Centro> findAll() {
        return centroService.findAll();
    }

    @GetMapping("/{codCentro}")
    public Centro findByCodCentro(@PathVariable Integer codCentro) {
        return centroService.findByCodCentro(codCentro);
    }

    @GetMapping("/nombre={nombreCentro}")
    public List<Centro> findByNombreCentro(@PathVariable String nombreCentro) {
        return centroService.findByNombreCentro(nombreCentro);
    }

    @GetMapping("/direccion={direccion}")
    public List<Centro> findByDireccion(@PathVariable String direccion) {
        return centroService.findByDireccion(direccion);
    }

    @GetMapping("/localidad={localidad}")
    public List<Centro> findByLocalidad(@PathVariable String localidad) {
        return centroService.findByLocalidad(localidad);
    }

    @GetMapping("/provincia={provincia}")
    public List<Centro> findByProvincia(@PathVariable String provincia) {
        return centroService.findByProvincia(provincia);
    }

    @GetMapping("/CP={codPostal}")
    public List<Centro> findByCodPostal(@PathVariable String codPostal) {
        return centroService.findByCodPostal(codPostal);
    }

    @GetMapping("/horario={horario}")
    public List<Centro> findByHorario(@PathVariable String horario) {
        return centroService.findByHorario(horario);
    }

    @GetMapping("/telefono={telefonoCentro}")
    public List<Centro> findByTelefonoCentro(@PathVariable String telefonoCentro) {
        return centroService.findByTelefonoCentro(telefonoCentro);
    }

    /* ----------------- Request Data ------------------ */
    @RequestMapping(value = "/buscarPorCodigo"
            , produces = "application/json;charset=UTF-8"
            , method = RequestMethod.GET)
    public Centro findCentroByCodCentro(@RequestParam("codCentro") int codCentro) {
        return centroService.querySelectByCodCentro(codCentro);
    }

    @RequestMapping(value = "/buscarPorNombre"
            , produces = "application/json;charset=UTF-8"
            , method = RequestMethod.GET)
    public List<Centro> findCentroByNombre(@RequestParam("nombreCompleto") String nombreCompleto) {
        return centroService.findByNombreCentro(nombreCompleto);
    }

    @RequestMapping(value = "/buscarPorDireccion"
            , produces = "application/json;charset=UTF-8"
            , method = RequestMethod.GET)
    public List<Centro> findCentroByDireccion(@RequestParam("direccion") String direccion) {
        return centroService.findByDireccion(direccion);
    }

    /* ----------------- Insertar Data ------------------ */
    @PostMapping("/add")
    public void addCentro(@RequestBody Centro centro) {
        try {
            centroService.addCentro(centro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/insert={nombreCentro},{direccion},{localidad},{provincia},{codPostal},{horario},{telefonoCentro}")
    public void insertCentro(@PathVariable String nombreCentro,@PathVariable String direccion, @PathVariable String localidad,
                             @PathVariable String provincia, @PathVariable String codPostal, @PathVariable String horario,
                             @PathVariable String telefonoCentro) {
        centroService.quertInsert(nombreCentro, direccion, localidad, provincia, codPostal, horario, telefonoCentro);
    }

    /* ----------------- Delete Data ------------------ */
    @DeleteMapping("/delete")
    public void delete(@RequestBody Centro centro) {
        try {
            centroService.deleteCentro(centro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping("/delete={codCentro}")
    public void deleteCentro(@PathVariable int codCentro) {
        try {
            centroService.queryDeleteByCodCentro(codCentro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* ----------------- Update Data ------------------ */
    @PutMapping("/update")
    public void update(@RequestBody Centro centro) {
        try {
            if (centroService.findByCodCentro(centro.getCodCentro()) != null) {
                centroService.addCentro(centro);
            } else {
                throw new EntityIdMismatchException();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PutMapping("/update={codCentro},{nombreCentro},{direccion},{localidad},{provincia},{codPostal},{horario},{telefonoCentro}")
    public void updateCentro(@PathVariable int codCentro, @PathVariable String nombreCentro, @PathVariable String direccion, @PathVariable String localidad,
                             @PathVariable String provincia, @PathVariable String codPostal, @PathVariable String horario, @PathVariable String telefonoCentro) {
        try {
            if (centroService.querySelectByCodCentro(codCentro) != null) {
                centroService.queryUpdateByCodCentro(codCentro,nombreCentro,direccion,localidad,provincia,codPostal,horario,telefonoCentro);
            } else {
                throw new EntityIdMismatchException();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PutMapping("/update_property/{codCentro},{value},{column}")
    public void updateCentroProperty(@PathVariable int codCentro, @PathVariable String value, @PathVariable String column) {
        try {
            if (centroService.querySelectByCodCentro(codCentro) != null) {
                centroService.queryUpdatePropertyByCodCentro(codCentro,value,column);
            } else {
                throw new EntityIdMismatchException();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


