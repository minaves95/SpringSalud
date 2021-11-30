package com.salud.repository;

import com.salud.model.Centro;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CentroRepository extends CrudRepository<Centro, Integer> {

    List<Centro> findAll();

    Centro findByCodCentro(int codCentro);

    List<Centro> findByNombreCentro(String nombreCentro);

    List<Centro> findByDireccion(String direccion);

    List<Centro> findByLocalidad(String localidad);

    List<Centro> findByProvincia(String provincia);

    List<Centro> findByCodPostal(String codPostal);

    List<Centro> findByHorario(String horario);

    List<Centro> findByTelefonoCentro(String telefonoCentro);

    Centro save(Centro centro);

    void delete(Centro centro);

    @Transactional
    @Modifying
    @Query(value =
            "insert into centro (nombre_centro, direccion, localidad, provincia, cod_postal, horario, telefono_centro) " +
                    "values (:nombreCentro, :direccion, :localidad, :provincia, :codPostal, :horario, :telefonoCentro)", nativeQuery = true)
    void queryInsert(String nombreCentro, String direccion, String localidad, String provincia, String codPostal, String horario, String telefonoCentro);

    @Query(value = "select * from centro  WHERE cod_centro = :codCentro", nativeQuery = true)
    Centro querySelectByCodCentro(int codCentro);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "delete from centro  WHERE cod_centro = :codCentro", nativeQuery = true)
    void queryDeleteByCodCentro(int codCentro);

    @Transactional
    @Modifying
    @Query(value = "update centro set " +
            "nombre_centro = :nombreCentro," +
            "direccion = :direccion," +
            "localidad = :localidad," +
            "provincia = :provincia," +
            "cod_postal = :codPostal," +
            "horario = :horario," +
            "telefono_centro = :telefonoCentro " +
            "where cod_centro = :codCentro", nativeQuery = true)
    void queryUpdateByCodCentro(int codCentro, String nombreCentro, String direccion, String localidad, String provincia, String codPostal, String horario, String telefonoCentro);

    // REVISAR
    @Transactional
    @Modifying
    @Query(value = "update centro set ?3 = ?2 where cod_centro = ?1", nativeQuery = true)
    void queryUpdatePropertyByCodCentro(@Param("codCentro") int codCentro, @Param("value") String value, String column);
}


