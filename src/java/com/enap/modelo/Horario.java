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
@Table(name = "horario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Horario.findAll", query = "SELECT h FROM Horario h")
    , @NamedQuery(name = "Horario.findByHorarioID", query = "SELECT h FROM Horario h WHERE h.horarioID = :horarioID")
    , @NamedQuery(name = "Horario.findByInicial", query = "SELECT h FROM Horario h WHERE h.inicial = :inicial")
    , @NamedQuery(name = "Horario.findByFinal1", query = "SELECT h FROM Horario h WHERE h.final1 = :final1")
    , @NamedQuery(name = "Horario.findByInicialOpcional", query = "SELECT h FROM Horario h WHERE h.inicialOpcional = :inicialOpcional")
    , @NamedQuery(name = "Horario.findByFinalOpcional", query = "SELECT h FROM Horario h WHERE h.finalOpcional = :finalOpcional")})
public class Horario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "horarioID")
    private Integer horarioID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inicial")
    @Temporal(TemporalType.TIME)
    private Date inicial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "final")
    @Temporal(TemporalType.TIME)
    private Date final1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inicialOpcional")
    @Temporal(TemporalType.TIME)
    private Date inicialOpcional;
    @Basic(optional = false)
    @NotNull
    @Column(name = "finalOpcional")
    @Temporal(TemporalType.TIME)
    private Date finalOpcional;

    public Horario() {
    }

    public Horario(Integer horarioID) {
        this.horarioID = horarioID;
    }

    public Horario(Integer horarioID, Date inicial, Date final1, Date inicialOpcional, Date finalOpcional) {
        this.horarioID = horarioID;
        this.inicial = inicial;
        this.final1 = final1;
        this.inicialOpcional = inicialOpcional;
        this.finalOpcional = finalOpcional;
    }

    public Integer getHorarioID() {
        return horarioID;
    }

    public void setHorarioID(Integer horarioID) {
        this.horarioID = horarioID;
    }

    public Date getInicial() {
        return inicial;
    }

    public void setInicial(Date inicial) {
        this.inicial = inicial;
    }

    public Date getFinal1() {
        return final1;
    }

    public void setFinal1(Date final1) {
        this.final1 = final1;
    }

    public Date getInicialOpcional() {
        return inicialOpcional;
    }

    public void setInicialOpcional(Date inicialOpcional) {
        this.inicialOpcional = inicialOpcional;
    }

    public Date getFinalOpcional() {
        return finalOpcional;
    }

    public void setFinalOpcional(Date finalOpcional) {
        this.finalOpcional = finalOpcional;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (horarioID != null ? horarioID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horario)) {
            return false;
        }
        Horario other = (Horario) object;
        if ((this.horarioID == null && other.horarioID != null) || (this.horarioID != null && !this.horarioID.equals(other.horarioID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.enap.modelo.Horario[ horarioID=" + horarioID + " ]";
    }
    
}
