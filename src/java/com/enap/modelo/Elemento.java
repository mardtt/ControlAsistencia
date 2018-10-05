/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enap.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author SOPORTE
 */
@Entity
@Table(name = "elemento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Elemento.findAll", query = "SELECT e FROM Elemento e")
    , @NamedQuery(name = "Elemento.findByElementoID", query = "SELECT e FROM Elemento e WHERE e.elementoID = :elementoID")
    , @NamedQuery(name = "Elemento.findByDescripcion", query = "SELECT e FROM Elemento e WHERE e.descripcion = :descripcion")
    , @NamedQuery(name = "Elemento.findByTipo", query = "SELECT e FROM Elemento e WHERE e.tipo = :tipo")
    , @NamedQuery(name = "Elemento.findByValorNum", query = "SELECT e FROM Elemento e WHERE e.valorNum = :valorNum")})
public class Elemento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "elementoID")
    private Integer elementoID;
    @Size(max = 80)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 30)
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "valorNum")
    private Integer valorNum;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "elemento")
    private List<Docente> docenteList;
    @OneToMany(mappedBy = "elemento")
    private List<Usuario> usuarioList;

    public Elemento() {
    }

    public Elemento(Integer elementoID) {
        this.elementoID = elementoID;
    }

    public Integer getElementoID() {
        return elementoID;
    }

    public void setElementoID(Integer elementoID) {
        this.elementoID = elementoID;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getValorNum() {
        return valorNum;
    }

    public void setValorNum(Integer valorNum) {
        this.valorNum = valorNum;
    }

    @XmlTransient
    public List<Docente> getDocenteList() {
        return docenteList;
    }

    public void setDocenteList(List<Docente> docenteList) {
        this.docenteList = docenteList;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (elementoID != null ? elementoID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Elemento)) {
            return false;
        }
        Elemento other = (Elemento) object;
        if ((this.elementoID == null && other.elementoID != null) || (this.elementoID != null && !this.elementoID.equals(other.elementoID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.enap.modelo.Elemento[ elementoID=" + elementoID + " ]";
    }
    
}
