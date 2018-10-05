/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enap.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SOPORTE
 */
@Entity
@Table(name = "docente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Docente.findAll", query = "SELECT d FROM Docente d")
    , @NamedQuery(name = "Docente.findByUsuario", query = "SELECT d FROM Docente d WHERE d.usuario = :usuario")
    , @NamedQuery(name = "Docente.findByTipo", query = "SELECT d FROM Docente d WHERE d.tipo = :tipo")
    , @NamedQuery(name = "Docente.findByAsignatura", query = "SELECT d FROM Docente d WHERE d.asignatura = :asignatura")})
public class Docente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario")
    private Integer usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "asignatura")
    private int asignatura;
    @JoinColumn(name = "elemento", referencedColumnName = "elementoID")
    @ManyToOne(optional = false)
    private Elemento elemento;
    @JoinColumn(name = "usuario", referencedColumnName = "usuarioID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuario1;

    public Docente() {
    }

    public Docente(Integer usuario) {
        this.usuario = usuario;
    }

    public Docente(Integer usuario, String tipo, int asignatura) {
        this.usuario = usuario;
        this.tipo = tipo;
        this.asignatura = asignatura;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(int asignatura) {
        this.asignatura = asignatura;
    }

    public Elemento getElemento() {
        return elemento;
    }

    public void setElemento(Elemento elemento) {
        this.elemento = elemento;
    }

    public Usuario getUsuario1() {
        return usuario1;
    }

    public void setUsuario1(Usuario usuario1) {
        this.usuario1 = usuario1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuario != null ? usuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Docente)) {
            return false;
        }
        Docente other = (Docente) object;
        if ((this.usuario == null && other.usuario != null) || (this.usuario != null && !this.usuario.equals(other.usuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.enap.modelo.Docente[ usuario=" + usuario + " ]";
    }
    
}
