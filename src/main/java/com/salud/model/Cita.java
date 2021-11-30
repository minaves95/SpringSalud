package com.salud.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "cita", schema = "salud")
//@IdClass(CitaPK.class) with <id-class class="com.salud.dao.CitaPK"/>
public class Cita {

    private int codCita;
    private Paciente paciente;
    private Medico medico;
    private Date fechaCita;
    private String causa;
    private String tipo;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_cita", nullable = false)
    public int getCodCita() {
        return codCita;
    }
    public void setCodCita(int codCita) {
        this.codCita = codCita;
    }

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_ar")
    //@JoinTable(name = "paciente"/*, foreignKey = @ForeignKey(name = "cod_ar")*/)
    //@Column(name = "paciente_cod_ar", nullable = false, insertable = false, updatable = false)
    public Paciente getPaciente() {
        return paciente;
    }
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_medico")
    //@JoinTable(name = "medico"/*, foreignKey = @ForeignKey(name = "cod_medico")*/)
    //@Column(name = "medico_cod_medico", nullable = false, insertable = false, updatable = false)
    public Medico getMedico() {
        return medico;
    }
    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    @Basic
    @Column(name = "fecha_cita", nullable = false)
    public Date getFechaCita() {
        return fechaCita;
    }
    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    @Basic
    @Column(name = "causa", length = 45)
    public String getCausa() {
        return causa;
    }
    public void setCausa(String causa) {
        this.causa = causa;
    }

    @Basic
    @Column(name = "tipo", length = 45)
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cita cita = (Cita) o;
        return codCita == cita.codCita && paciente == cita.paciente && medico == cita.medico && Objects.equals(fechaCita, cita.fechaCita) && Objects.equals(causa, cita.causa) && Objects.equals(tipo, cita.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codCita, fechaCita, causa, tipo, paciente, medico);
    }

    @Override
    public String toString() {
        return "Cita{" +
                "codCita=" + codCita +
                ", [paciente=" + paciente.toString() + "]" +
                ", [medico=" + medico.toString() + "]" +
                ", fechaCita=" + fechaCita +
                ", causa='" + causa + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
