/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enap.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author SOPORTE
 */
@Entity
@Table(name = "asignatura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asignatura.findAll", query = "SELECT a FROM Asignatura a")
    , @NamedQuery(name = "Asignatura.findByAsignaturaID", query = "SELECT a FROM Asignatura a WHERE a.asignaturaID = :asignaturaID")
    , @NamedQuery(name = "Asignatura.findByNombre", query = "SELECT a FROM Asignatura a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Asignatura.findByDocente", query = "SELECT a FROM Asignatura a WHERE a.docente = :docente")
    , @NamedQuery(name = "Asignatura.findByElemento", query = "SELECT a FROM Asignatura a WHERE a.elemento = :elemento")
    , @NamedQuery(name = "Asignatura.findByTema", query = "SELECT a FROM Asignatura a WHERE a.tema = :tema")
    , @NamedQuery(name = "Asignatura.findByHorario", query = "SELECT a FROM Asignatura a WHERE a.horario = :horario")
    , @NamedQuery(name = "Asignatura.findByCredito", query = "SELECT a FROM Asignatura a WHERE a.credito = :credito")})
public class Asignatura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "asignaturaID")
    private Integer asignaturaID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "docente")
    private int docente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "elemento")
    private int elemento;
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
    @Column(name = "credito")
    private int credito;
    @JoinTable(name = "estudiante_asignatura", joinColumns = {
        @JoinColumn(name = "asignaturaID", referencedColumnName = "asignaturaID")}, inverseJoinColumns = {
        @JoinColumn(name = "estudianteID", referencedColumnName = "usuario")})
    @ManyToMany
    private List<Estudiante> estudianteList;

    public Asignatura() {
    }

    public Asignatura(Integer asignaturaID) {
        this.asignaturaID = asignaturaID;
    }

    public Asignatura(Integer asignaturaID, String nombre, int docente, int elemento, int tema, int horario, int credito) {
        this.asignaturaID = asignaturaID;
        this.nombre = nombre;
        this.docente = docente;
        this.elemento = elemento;
        this.tema = tema;
        this.horario = horario;
        this.credito = credito;
    }

    public Integer getAsignaturaID() {
        return asignaturaID;
    }

    public void setAsignaturaID(Integer asignaturaID) {
        this.asignaturaID = asignaturaID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDocente() {
        return docente;
    }

    public void setDocente(int docente) {
        this.docente = docente;
    }

    public int getElemento() {
        return elemento;
    }

    public void setElemento(int elemento) {
        this.elemento = elemento;
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

    public int getCredito() {
        return credito;
    }

    public void setCredito(int credito) {
        this.credito = credito;
    }

    @XmlTransient
    public List<Estudiante> getEstudianteList() {
        return estudianteList;
    }

    public void setEstudianteList(List<Estudiante> estudianteList) {
        this.estudianteList = estudianteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (asignaturaID != null ? asignaturaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asignatura)) {
            return false;
        }
        Asignatura other = (Asignatura) object;
        if ((this.asignaturaID == null && other.asignaturaID != null) || (this.asignaturaID != null && !this.asignaturaID.equals(other.asignaturaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.enap.modelo.Asignatura[ asignaturaID=" + asignaturaID + " ]";
    }
    
}
