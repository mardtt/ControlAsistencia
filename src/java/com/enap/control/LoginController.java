/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enap.control;

import com.enap.dao.UsuarioDao;
import com.enap.modelo.Usuario;
import java.io.IOException;
import javax.inject.Named;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author SOPORTE
 */
@Named(value = "LoginController")
@RequestScoped
public class LoginController implements Serializable {

    //Objetos
    private Usuario usuario;
    @Inject
    private UsuarioDao usuarioDao;
    private String pagina;

    /**
     * Creates a new instance of LoginController
     */
    public LoginController() {
        usuarioDao = new UsuarioDao();
        usuario = new Usuario();
    }

    public void login() throws IOException {
        
       usuario = usuarioDao.buscarPorUsuarioPass(usuario.getUsuario(), usuario.getContrasena());
       if (usuario != null) {
           switch (usuario.getTipo()) {
               case "admin":
                   pagina = "dashboard.xhtml";
                   FacesContext.getCurrentInstance().getExternalContext().redirect(pagina);
                   break;
               case "docente":
                   break;
               case "cdecurso":
                   break;
               default:
                   FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuario o Contraseña Incorrecto", "Intente de Nuevo"));
                   break;
           }
       } else {
           pagina = "index.xhtml";
           FacesContext.getCurrentInstance().getExternalContext();
       }
        
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }   
    

}
