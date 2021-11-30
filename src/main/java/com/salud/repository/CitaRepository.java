package com.salud.repository;


import com.salud.model.Cita;
import com.salud.model.Medico;
import com.salud.model.Paciente;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface CitaRepository extends CrudRepository<Cita, Integer> {

    List<Cita> findAll();
    Cita findByCodCita(int codCita);
    List<Cita> findByPaciente(Paciente paciente);
    List<Cita> findByMedico(Medico medico);
    List<Cita> findByFechaCita(Date fecha);
    List<Cita> findByCausa(String causa);
    List<Cita> findByTipo(String tipo);

    Cita save (Cita cita);
    void delete(Cita cita);

    @Transactional
    @Modifying
    @Query(value =
            "insert into cita (fecha_cita, causa, tipo, cod_ar, cod_medico) " +
                    "values (:fechaCita, :causa, :tipo, :codAr, :codMedico)", nativeQuery = true)
    void queryInsert(String fechaCita, String causa, String tipo, int codAr, int codMedico);

    @Query(value = "select * from Cita  WHERE cod_cita = :codCita", nativeQuery = true)
    Cita querySelectByCodCita(int codCita);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "delete from Cita  WHERE cod_cita = :codCita", nativeQuery = true)
    void queryDeleteByCodCita(int codCita);

    @Transactional
    @Modifying
    @Query(value = "update cita set " +
            "fecha_cita = :fechaCita," +
            "causa = :causa," +
            "tipo = :tipo," +
            "cod_ar = :codAr," +
            "cod_medico = :codMedico " +
            "where cod_cita = :codCita", nativeQuery = true)
    void queryUpdateByCodCita(int codCita, String fechaCita, String causa, String tipo, int codAr, int codMedico);

}
