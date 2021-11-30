package com.salud.model;

import com.salud.repository.CentroRepository;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "centro", schema = "salud")
public class Centro {
    private Integer codCentro;
    private String nombreCentro;
    private String direccion;
    private String localidad;
    private String provincia;
    private String codPostal;
    private String horario;
    private String telefonoCentro;

    //-----------------------------
    public Centro() {

    }

    public Centro(String nombreCentro, String direccion, String localidad, String provincia, String codPostal, String horario, String telefonoCentro) {
        this.nombreCentro = nombreCentro;
        this.direccion = direccion;
        this.localidad = localidad;
        this.provincia = provincia;
        this.codPostal = codPostal;
        this.horario = horario;
        this.telefonoCentro = telefonoCentro;
    }

    public Centro(Integer codCentro, String nombreCentro, String direccion, String localidad, String provincia, String codPostal, String horario, String telefonoCentro) {
        this.codCentro = codCentro;
        this.nombreCentro = nombreCentro;
        this.direccion = direccion;
        this.localidad = localidad;
        this.provincia = provincia;
        this.codPostal = codPostal;
        this.horario = horario;
        this.telefonoCentro = telefonoCentro;
    }
    //---------------------

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_centro", nullable = false)
    public int getCodCentro() {
        return codCentro;
    }
    public void setCodCentro(int codCentro) {
        this.codCentro = codCentro;
    }

    @Basic
    @Column(name = "nombre_centro", length = 45)
    public String getNombreCentro() {
        return nombreCentro;
    }
    public void setNombreCentro(String nombreCentro) {
        this.nombreCentro = nombreCentro;
    }

    @Basic
    @Column(name = "direccion", length = 45)
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Basic
    @Column(name = "localidad", length = 45)
    public String getLocalidad() {
        return localidad;
    }
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    @Basic
    @Column(name = "provincia", length = 45)
    public String getProvincia() {
        return provincia;
    }
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Basic
    @Column(name = "cod_postal", length = 5)
    public String getCodPostal() {
        return codPostal;
    }
    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    @Basic
    @Column(name = "horario")
    public String getHorario() {
        return horario;
    }
    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Basic
    @Column(name = "telefono_centro", length = 9)
    public String getTelefonoCentro() {
        return telefonoCentro;
    }
    public void setTelefonoCentro(String telefonoCentro) {
        this.telefonoCentro = telefonoCentro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Centro centro = (Centro) o;
        return codCentro == centro.codCentro && Objects.equals(nombreCentro, centro.nombreCentro) && Objects.equals(direccion, centro.direccion) && Objects.equals(localidad, centro.localidad) && Objects.equals(provincia, centro.provincia) && Objects.equals(codPostal, centro.codPostal) && Objects.equals(horario, centro.horario) && Objects.equals(telefonoCentro, centro.telefonoCentro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codCentro, nombreCentro, direccion, localidad, provincia, codPostal, horario, telefonoCentro);
    }

    @Override
    public String toString() {
        return "Centro{" +
                "codCentro=" + codCentro +
                ", nombreCentro='" + nombreCentro + '\'' +
                ", direccion='" + direccion + '\'' +
                ", localidad='" + localidad + '\'' +
                ", provincia='" + provincia + '\'' +
                ", codPostal='" + codPostal + '\'' +
                ", horario='" + horario + '\'' +
                ", telefonoCentro='" + telefonoCentro + '\'' +
                '}';
    }
}

