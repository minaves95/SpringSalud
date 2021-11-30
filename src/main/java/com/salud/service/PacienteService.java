package com.salud.service;

import com.salud.model.Paciente;
import com.salud.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

    public List<Paciente> findAll(){
        return pacienteRepository.findAll();
    }
    public Paciente findByCodAr(int codAr){
        return pacienteRepository.findByCodAr(codAr);
    }
    public Paciente findByDni(String dni){
        return pacienteRepository.findByDni(dni);
    }
    public List<Paciente> findByNombre(String nombreCompleto){
        return pacienteRepository.findByNombreCompleto(nombreCompleto);
    }
    public List<Paciente> findByTelefono(String telefono){
        return pacienteRepository.findByTelefono(telefono);
    }
    public List<Paciente> findByDomicilio(String domicilio){
        return pacienteRepository.findByDomicilio(domicilio);
    }
    public List<Paciente> findByLocalidad(String localidad) {
        return pacienteRepository.findByLocalidad(localidad);
    }
    public List<Paciente> findByProvincia(String provincia) {
        return pacienteRepository.findByProvincia(provincia);
    }
    public List<Paciente> findByCodPostal(String codPostal){
        return pacienteRepository.findByCodPostal(codPostal);
    }
    public List<Paciente> findByNacionalidad(String nacionalidad){
        return pacienteRepository.findByNacionalidad(nacionalidad);
    }
    public List<Paciente> findByVacunado(boolean vacunado){
        return pacienteRepository.findByVacunado(vacunado);
    }

    public Paciente findByCodArAndDniAndTelefono(int codAr, String dni, String telefono){
        return pacienteRepository.findByCodArAndDniAndTelefono(codAr,dni,telefono);
    }

    public void addPaciente(Paciente paciente){
        pacienteRepository.save(paciente);
    }
    public void deletePaciente(Paciente paciente){
        pacienteRepository.delete(paciente);
    }
    public void quertInsert(String dni, String nombreCompleto, String fechaNacimiento, String telefono, String domicilio, String localidad, String provincia,
                            String codPostal, String nacionalidad, boolean vacunado){
        pacienteRepository.queryInsert(dni,nombreCompleto,fechaNacimiento,telefono,domicilio,localidad,provincia,codPostal,nacionalidad,vacunado);
    }
    public Paciente querySelectByCodAr(int codAr){
        return pacienteRepository.querySelectByCodAr(codAr);
    }
    public void queryDeleteByCodAr(int codAr){
        pacienteRepository.queryDeleteByCodAr(codAr);
    }
    public void queryUpdateByCodAr(int codAr, String dni, String nombreCompleto, String fechaNacimiento, String telefono, String domicilio, String localidad, String provincia,
                                       String codPostal, String nacionalidad, boolean vacunado) {
        pacienteRepository.queryUpdateByCodAr(codAr, dni, nombreCompleto, fechaNacimiento, telefono, domicilio, localidad, provincia, codPostal, nacionalidad, vacunado);
    }

}
