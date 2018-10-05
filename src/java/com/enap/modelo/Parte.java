/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enap.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SOPORTE
 */
@Entity
@Table(name = "parte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parte.findAll", query = "SELECT p FROM Parte p")
    , @NamedQuery(name = "Parte.findByParteID", query = "SELECT p FROM Parte p WHERE p.parteID = :parteID")
    , @NamedQuery(name = "Parte.findByFecha", query = "SELECT p FROM Parte p WHERE p.fecha = :fecha")
    , @NamedQuery(name = "Parte.findByCurso", query = "SELECT p FROM Parte p WHERE p.curso = :curso")
    , @NamedQuery(name = "Parte.findByAsignatura", query = "SELECT p FROM Parte p WHERE p.asignatura = :asignatura")
    , @NamedQuery(name = "Parte.findByTema", query = "SELECT p FROM Parte p WHERE p.tema = :tema")
    , @NamedQuery(name = "Parte.findByHorario", query = "SELECT p FROM Parte p WHERE p.horario = :horario")
    , @NamedQuery(name = "Parte.findByElemento", query = "SELECT p FROM Parte p WHERE p.elemento = :elemento")})
public class Parte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "parteID")
    private Integer parteID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "curso")
    private int curso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "asignatura")
    private int asignatura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tema")
    private int tema;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horario")
    private int horario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "elemento")
    private int elemento;

    public Parte() {
    }

    public Parte(Integer parteID) {
        this.parteID = parteID;
    }

    public Parte(Integer parteID, Date fecha, int curso, int asignatura, int tema, int horario, int elemento) {
        this.parteID = parteID;
        this.fecha = fecha;
        this.curso = curso;
        this.asignatura = asignatura;
        this.tema = tema;
        this.horario = horario;
        this.elemento = elemento;
    }

    public Integer getParteID() {
        return parteID;
    }

    public void setParteID(Integer parteID) {
        this.parteID = parteID;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public int getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(int asignatura) {
        this.asignatura = asignatura;
    }

    public int getTema() {
        return tema;
    }

    public void setTema(int tema) {
        this.tema = tema;
    }

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }

    public int getElemento() {
        return elemento;
    }

    public void setElemento(int elemento) {
        this.elemento = elemento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (parteID != null ? parteID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parte)) {
            return false;
        }
        Parte other = (Parte) object;
        if ((this.parteID == null && other.parteID != null) || (this.parteID != null && !this.parteID.equals(other.parteID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.enap.modelo.Parte[ parteID=" + parteID + " ]";
    }
    
}
