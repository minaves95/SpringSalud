package com.salud.service;

import com.salud.model.Centro;
import com.salud.model.Medico;
import com.salud.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    @Autowired
    MedicoRepository medicoRepository;

    public List<Medico> findAll() {
        return medicoRepository.findAll();
    }
    public Medico findByCodMedico(int codMedico) {
        return medicoRepository.findByCodMedico(codMedico);
    }
    public List<Medico> findByNombreCompleto(String nombreCompleto) {
        return medicoRepository.findByNombreCompleto(nombreCompleto);
    }
    public List<Medico> findByTelefonoConsulta(String telefono) {
        return medicoRepository.findByTelefonoConsulta(telefono);
    }
    public List<Medico> findByTelefonoPrivado(String telefono) {
        return medicoRepository.findByTelefonoPrivado(telefono);
    }
    public List<Medico> findByDomicilio(String domicilio) {
        return medicoRepository.findByDomicilio(domicilio);
    }
    public List<Medico> findByLocalidad(String localidad) {
        return medicoRepository.findByLocalidad(localidad);
    }
    public List<Medico> findByProvincia(String provincia) {
        return medicoRepository.findByProvincia(provincia);
    }
    public List<Medico> findByNacionalidad(String nacionalidad) {
        return medicoRepository.findByNacionalidad(nacionalidad);
    }
    public List<Medico> findByVacunado(boolean vacunado) {
        return medicoRepository.findByVacunado(vacunado);
    }
    public List<Medico> findByCentro(Centro centro) {
        return medicoRepository.findByCentro(centro);
    }

    public Medico addMedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    public void deleteMedico(Medico medico) {
        medicoRepository.delete(medico);
    }

    public void queryInsert(String nombreCompleto, String fechaNacimiento, String telefonoConsulta, String telefonoPrivado, String domicilio, String localidad, String provincia,
                            String codPostal, String nacionalidad, boolean vacunado, Integer codCentro) {
        medicoRepository.queryInsert(nombreCompleto, fechaNacimiento, telefonoConsulta, telefonoPrivado, domicilio, localidad, provincia, codPostal, nacionalidad, vacunado, codCentro);
    }

    public Medico querySelectByCodMedico(int codMedico) {
        return medicoRepository.querySelectByCodMedico(codMedico);
    }

    public void queryDeleteByCodMedico(int codMedico) {
        medicoRepository.queryDeleteByCodMedico(codMedico);
    }

    public void queryUpdateByCodMedico(int codMedico, String nombreCompleto, String fechaNacimiento, String telefonoConsulta, String telefonoPrivado, String domicilio,
                                   String localidad, String provincia, String codPostal, String nacionalidad, boolean vacunado, Integer codCentro) {
        medicoRepository.queryUpdateByCodMedico(codMedico, nombreCompleto, fechaNacimiento, telefonoConsulta, telefonoPrivado, domicilio, localidad,
                provincia, codPostal, nacionalidad, vacunado, codCentro);
    }
}

