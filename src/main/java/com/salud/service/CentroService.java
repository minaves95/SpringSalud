package com.salud.service;

import com.salud.controller.rest.CentroRestController;
import com.salud.controller.view.data.CentroController;
import com.salud.model.Centro;
import com.salud.repository.CentroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CentroService{

    @Autowired
    CentroRepository centroRepository;

    public List<Centro> findAll() {
        return centroRepository.findAll();
    }

    public Centro findByCodCentro(int codCentro) {
        return centroRepository.findByCodCentro(codCentro);
    }

    public List<Centro> findByNombreCentro(String nombreCentro) {
        return centroRepository.findByNombreCentro(nombreCentro);
    }

    public List<Centro> findByDireccion(String direccion) {
        return centroRepository.findByDireccion(direccion);
    }

    public List<Centro> findByLocalidad(String localidad) {
        return centroRepository.findByLocalidad(localidad);
    }

    public List<Centro> findByProvincia(String provincia) {
        return centroRepository.findByProvincia(provincia);
    }

    public List<Centro> findByCodPostal(String codPostal) {
        return centroRepository.findByCodPostal(codPostal);
    }

    public List<Centro> findByHorario(String horario) {
        return centroRepository.findByHorario(horario);
    }

    public List<Centro> findByTelefonoCentro(String telefonoCentro) {
        return centroRepository.findByTelefonoCentro(telefonoCentro);
    }

    public void addCentro(Centro centro) {
        centroRepository.save(centro);
    }

    public void deleteCentro(Centro centro) {
        centroRepository.delete(centro);
    }

    public void quertInsert(String nombreCentro, String direccion, String localidad, String provincia, String codPostal, String horario, String telefonoCentro) {
        centroRepository.queryInsert(nombreCentro, direccion, localidad, provincia, codPostal, horario, telefonoCentro);
    }
    public Centro querySelectByCodCentro(int codCentro) {
        return centroRepository.querySelectByCodCentro(codCentro);
    }
    public void queryDeleteByCodCentro(int codCentro) {
        centroRepository.queryDeleteByCodCentro(codCentro);
    }
    public void queryUpdateByCodCentro(int codCentro, String nombreCentro, String direccion, String localidad, String provincia,
                                       String codPostal, String horario, String telefonoCentro) {
        centroRepository.queryUpdateByCodCentro(codCentro, nombreCentro, direccion, localidad, provincia, codPostal, horario, telefonoCentro);
    }

    public void queryUpdatePropertyByCodCentro(int codCentro, String value, String column) {
        centroRepository.queryUpdatePropertyByCodCentro(codCentro,value,column);
    }
}
