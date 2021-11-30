package com.salud.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "medico", schema = "salud")
public class Medico{
    private int codMedico;
    private String nombreCompleto;
    private Date fechaNacimiento;
    private String telefonoConsulta;
    private String telefonoPrivado;
    private String domicilio;
    private String localidad;
    private String provincia;
    private String codPostal;
    private String nacionalidad;
    private boolean vacunado;
    private Centro centroMedico;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_centro")
    public Centro getCentro() {
        return centroMedico;
    }
    public void setCentro(Centro centro) {
        this.centroMedico = centro;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_medico", nullable = false)
    public int getCodMedico() {
        return codMedico;
    }
    public void setCodMedico(int codMedico) {
        this.codMedico = codMedico;
    }

    @Basic
    @Column(name = "nombre_completo", length = 45)
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    @Basic
    @Column(name = "fecha_nacimiento")
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Basic
    @Column(name = "telefono_consulta", length = 9)
    public String getTelefonoConsulta() {
        return telefonoConsulta;
    }
    public void setTelefonoConsulta(String telefonoConsulta) {
        this.telefonoConsulta = telefonoConsulta;
    }

    @Basic
    @Column(name = "telefono_privado", length = 9)
    public String getTelefonoPrivado() {
        return telefonoPrivado;
    }
    public void setTelefonoPrivado(String telefonoPrivado) {
        this.telefonoPrivado = telefonoPrivado;
    }

    @Basic
    @Column(name = "domicilio", length = 45)
    public String getDomicilio() {
        return domicilio;
    }
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
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
    @Column(name = "nacionalidad", length = 45)
    public String getNacionalidad() {
        return nacionalidad;
    }
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Basic
    @Column(name = "vacunado", nullable = false)
    public boolean isVacunado() {
        return vacunado;
    }
    public void setVacunado(boolean vacunado) {
        this.vacunado = vacunado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medico medico = (Medico) o;
        return codMedico == medico.codMedico && vacunado == medico.vacunado && Objects.equals(nombreCompleto, medico.nombreCompleto) && Objects.equals(fechaNacimiento, medico.fechaNacimiento) && Objects.equals(telefonoConsulta, medico.telefonoConsulta) && Objects.equals(telefonoPrivado, medico.telefonoPrivado) && Objects.equals(domicilio, medico.domicilio) && Objects.equals(localidad, medico.localidad) && Objects.equals(provincia, medico.provincia) && Objects.equals(codPostal, medico.codPostal) && Objects.equals(nacionalidad, medico.nacionalidad)  && Objects.equals(centroMedico, medico.centroMedico);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codMedico, nombreCompleto, fechaNacimiento, telefonoConsulta, telefonoPrivado, domicilio, localidad, provincia, codPostal, nacionalidad, vacunado, centroMedico);
    }

    @Override
    public String toString() {
        return "Medico{" +
                "codMedico=" + codMedico +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", telefonoConsulta='" + telefonoConsulta + '\'' +
                ", telefonoPrivado='" + telefonoPrivado + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", localidad='" + localidad + '\'' +
                ", provincia='" + provincia + '\'' +
                ", codPostal='" + codPostal + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", vacunado=" + vacunado +
                ", [centroMedico=" + centroMedico.toString() + "]" +
                '}';
    }
}
