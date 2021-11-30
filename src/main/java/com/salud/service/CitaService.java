package com.salud.service;

import com.salud.model.Cita;
import com.salud.model.Medico;
import com.salud.model.Paciente;
import com.salud.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CitaService {

    @Autowired
    CitaRepository citaRepository;

    public List<Cita> findAll() {
        return citaRepository.findAll();
    }
    public Cita findByCodCita(int codCita) {
        return citaRepository.findByCodCita(codCita);
    }
    public List<Cita> findByPaciente(Paciente paciente) {
        return citaRepository.findByPaciente(paciente);
    }
    public List<Cita> findByMedico(Medico medico) {
        return citaRepository.findByMedico(medico);
    }
    public List<Cita> findByFechaCita(Date fecha) {
        return citaRepository.findByFechaCita(fecha);
    }
    public List<Cita> findByCausa(String causa) {
        return citaRepository.findByCausa(causa);
    }
    public List<Cita> findByTipo(String tipo) {return citaRepository.findByTipo(tipo);
    }

    public Cita addCita(Cita cita) {
        return citaRepository.save(cita);
    }
    public void deleteCita(Cita cita) {
        citaRepository.delete(cita);
    }

    public void queryInsert(String fechaCita, String causa, String tipo, int codAr, int codMedico) {
        citaRepository.queryInsert(fechaCita, causa, tipo, codAr, codMedico);
    }

    public Cita querySelectByCodCita(int codCita) {
        return citaRepository.querySelectByCodCita(codCita);
    }

    public void queryDeleteByCodCita(int codCita) {
        citaRepository.queryDeleteByCodCita(codCita);
    }

    public void queryUpdateByCodCita(int codCita, String fechaCita, String causa, String tipo, int codAr, int codMedico) {
        citaRepository.queryUpdateByCodCita(codCita, fechaCita, causa, tipo, codAr, codMedico);
    }
}


