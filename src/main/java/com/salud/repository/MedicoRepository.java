package com.salud.repository;

import com.salud.model.Centro;
import com.salud.model.Medico;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface MedicoRepository extends CrudRepository<Medico, Integer> {

    List<Medico> findAll();

    Medico findByCodMedico(int codMedico);
    List<Medico> findByNombreCompleto(String nombreCompleto);
    List<Medico> findByTelefonoConsulta(String telefono);
    List<Medico> findByTelefonoPrivado(String telefono);
    List<Medico> findByDomicilio(String domicilio);
    List<Medico> findByLocalidad(String localidad);
    List<Medico> findByProvincia(String provincia);
    List<Medico> findByVacunado(boolean vacunado);
    List<Medico> findByNacionalidad(String nacionalidad);

    List<Medico> findByCentro(Centro centro);

    Medico save(Medico Medico);

    void delete(Medico Medico);

    @Transactional
    @Modifying
    @Query(value =
            "insert into medico (nombre_completo, fecha_nacimiento, telefono_consulta, telefono_privado, domicilio, " +
                    "localidad, provincia, cod_postal, nacionalidad, vacunado, cod_centro) " +
                    "values (:nombreCompleto, :fechaNacimiento, :telefonoConsulta, :telefonoPrivado, :domicilio, :localidad, " +
                    ":provincia, :codPostal, :nacionalidad, :vacunado, :codCentro)", nativeQuery = true)
    void queryInsert(String nombreCompleto, String fechaNacimiento, String telefonoConsulta, String telefonoPrivado, String domicilio, String localidad, String provincia,
                     String codPostal, String nacionalidad, boolean vacunado, int codCentro);

    @Query(value = "select * from Medico  WHERE cod_medico = :codMedico", nativeQuery = true)
    Medico querySelectByCodMedico(int codMedico);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "delete from Medico  WHERE cod_medico = :codMedico", nativeQuery = true)
    void queryDeleteByCodMedico(int codMedico);

    @Transactional
    @Modifying
    @Query(value = "update medico m set " +
            "m.nombre_completo = :nombreCompleto," +
            "m.fecha_nacimiento = :fechaNacimiento," +
            "m.telefono_consulta = :telefonoConsulta," +
            "m.telefono_privado = :telefonoPrivado," +
            "m.domicilio = :domicilio," +
            "m.localidad = :localidad," +
            "m.provincia = :provincia," +
            "m.cod_postal = :codPostal," +
            "m.nacionalidad = :nacionalidad," +
            "m.vacunado = :vacunado," +
            "m.cod_centro = :codCentro " +
            "where m.cod_medico = :codMedico", nativeQuery = true)
    void queryUpdateByCodMedico(int codMedico, String nombreCompleto, String fechaNacimiento, String telefonoConsulta, String telefonoPrivado, String domicilio,
                                String localidad, String provincia, String codPostal, String nacionalidad, boolean vacunado, int codCentro);
}
