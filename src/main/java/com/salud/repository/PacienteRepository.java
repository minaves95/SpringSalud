package com.salud.repository;

import com.salud.model.Paciente;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PacienteRepository extends CrudRepository <Paciente, Integer>  {

    List<Paciente> findAll();
    Paciente findByCodAr(int codAr);
    Paciente findByDni(String dni);
    List<Paciente> findByNombreCompleto(String nombreCompleto);
    List<Paciente> findByTelefono(String telefono);
    List<Paciente> findByDomicilio(String domicilio);
    List<Paciente> findByLocalidad(String localidad);
    List<Paciente> findByProvincia(String provincia);
    List<Paciente> findByCodPostal(String codPostal);
    List<Paciente> findByNacionalidad(String nacionalidad);
    List<Paciente> findByVacunado(boolean vacunado);
    Paciente findByCodArAndDniAndTelefono(int codAr, String dni, String telefono);

    Paciente save (Paciente paciente);
    void delete(Paciente paciente);

    @Transactional
    @Modifying
    @Query(value =
            "insert into paciente (dni, nombre_completo, fecha_nacimiento, telefono, domicilio, localidad, provincia, cod_postal, nacionalidad, vacunado) " +
                    "values (:dni, :nombreCompleto, :fechaNacimiento, :telefono, :domicilio, :localidad, :provincia, :codPostal, :nacionalidad, :vacunado)", nativeQuery = true)
    void queryInsert(String dni, String nombreCompleto, String fechaNacimiento, String telefono, String domicilio, String localidad, String provincia,
                     String codPostal, String nacionalidad, boolean vacunado);

    @Query(value = "select * from paciente  WHERE cod_ar = :codAr", nativeQuery = true)
    Paciente querySelectByCodAr(int codAr);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "delete from paciente  WHERE cod_ar = :codAr", nativeQuery = true)
    void queryDeleteByCodAr(int codAr);

    @Transactional
    @Modifying
    @Query(value = "update paciente p set " +
                                    "p.dni = :dni," +
                                    "p.nombre_completo = :nombreCompleto," +
                                    "p.fecha_nacimiento = :fechaNacimiento," +
                                    "p.telefono = :telefono," +
                                    "p.domicilio = :domicilio," +
                                    "p.localidad = :localidad," +
                                    "p.provincia = :provincia," +
                                    "p.cod_postal = :codPostal," +
                                    "p.nacionalidad = :nacionalidad," +
                                    "p.vacunado = :vacunado " +
                        "where p.cod_ar = :codAr", nativeQuery = true)
    void queryUpdateByCodAr(int codAr, String dni, String nombreCompleto, String fechaNacimiento, String telefono, String domicilio, String localidad, String provincia,
                           String codPostal, String nacionalidad, boolean vacunado);

   /* @Transactional
    @Modifying
    @Query(value = "update paciente p set p.:column = :value where p.cod_ar = :codAr", nativeQuery = true)
    void queryUpdatePropertyByCodAr(int codAr, String column, String value);*/
}
