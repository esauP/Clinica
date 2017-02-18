/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.awt.event.ActionEvent;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import pojo.Person;
import Model.Login;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author esaup
 */
@Named(value = "loginBean")
@ManagedBean
public class LoginBean implements Serializable {

    private String username;

    private String password;

    private int role;

    public LoginBean() {
    }

    /**
     * Metodo para acceder al servicio
     * @param event 
     */
    public void logear(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesContext fcontext = FacesContext.getCurrentInstance();

        FacesMessage message = null;
        boolean loggedIn = false;
        Person pers = new Person();
        try {
            pers = Login.getConectado(username, password);

            if (pers == null) {
                fcontext.getExternalContext().redirect("error.html");

            } else {
                fcontext.getExternalContext().getSessionMap().put("usuario", pers);
                fcontext.getExternalContext().redirect("faces/adminHome.xhtml");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("Logeado", loggedIn);
    }

    public void validarSesion() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            Person pers = (Person) context.getExternalContext().getSessionMap().get("usuario");

            if (pers == null) {
                context.getExternalContext().redirect("error.html");
            }
        } catch (Exception e) {

        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

}
