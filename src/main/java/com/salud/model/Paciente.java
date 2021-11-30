package com.salud.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "paciente", schema = "salud")
public class Paciente{
    private int codAr;
    private String dni;
    private String nombreCompleto;
    private Date fechaNacimiento;
    private String telefono;
    private String domicilio;
    private String localidad;
    private String provincia;
    private String codPostal;
    private String nacionalidad;
    private boolean vacunado;

    public Paciente() {}

    public Paciente(String dni, String nombreCompleto, Date fechaNacimiento, String telefono, String domicilio, String localidad, String provincia, String codPostal, String nacionalidad, boolean vacunado) {
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.domicilio = domicilio;
        this.localidad = localidad;
        this.provincia = provincia;
        this.codPostal = codPostal;
        this.nacionalidad = nacionalidad;
        this.vacunado = vacunado;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_ar", nullable = false)
    public int getCodAr() {
        return codAr;
    }
    public void setCodAr(int codAr) {
        this.codAr = codAr;
    }

    @Basic
    @Column(name = "dni", length = 9)
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
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
    @Column(name = "fecha_nacimiento", length = 10)
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Basic
    @Column(name = "telefono", length = 9)
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
    @Column(name = "nacionalidad", nullable = true, length = 45)
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
        Paciente paciente = (Paciente) o;
        return codAr == paciente.codAr && vacunado == paciente.vacunado && Objects.equals(dni, paciente.dni) && Objects.equals(nombreCompleto, paciente.nombreCompleto) && Objects.equals(fechaNacimiento, paciente.fechaNacimiento) && Objects.equals(telefono, paciente.telefono) && Objects.equals(domicilio, paciente.domicilio) && Objects.equals(localidad, paciente.localidad) && Objects.equals(provincia, paciente.provincia) && Objects.equals(codPostal, paciente.codPostal) && Objects.equals(nacionalidad, paciente.nacionalidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codAr, dni, nombreCompleto, fechaNacimiento, telefono, domicilio, localidad, provincia, codPostal, nacionalidad, vacunado);
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "codAr=" + codAr +
                ", dni='" + dni + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", telefono='" + telefono + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", localidad='" + localidad + '\'' +
                ", provincia='" + provincia + '\'' +
                ", codPostal='" + codPostal + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", vacunado=" + vacunado +
                '}';
    }
}
