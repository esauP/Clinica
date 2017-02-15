/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javafx.scene.control.TableColumn.CellEditEvent;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;
import pojo.Person;
import Controller.LPerson;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author esaup
 */
@Named(value = "personBean")
@ManagedBean
@RequestScoped
public class PersonBean {

    private String idperson;
    private String namePer;
    private String address;
    private String phone;
    private String email;
    private List<Person> listapersonas;
    private Person pers = new Person();

    public PersonBean() throws SQLException {
        listapersonas = LPerson.getPersons();
    }

    public void onRowEdit(RowEditEvent event) {
        Person personaM = (Person) event.getObject();
        FacesMessage msg = new FacesMessage("Persona Editada", personaM.getNamePer());
        LPerson.updateTelef(personaM.getIdperson(), personaM.getPhone());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edicion Cancellada", ((Person) event.getObject()).getIdperson());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if (newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Celda acutalizada", "Antiguo: " + oldValue + ", Nuevo:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void AddPerson() throws SQLException {
        LPerson.addPerson(pers.getIdperson(), pers.getNamePer(), pers.getAddress(), pers.getPhone(), pers.getEmail(), pers.getIdperson(), 4);
    }

    public List<Person> getListapersonas() {
        return listapersonas;
    }

    public void setListapersonas(List<Person> listapersonas) {
        this.listapersonas = listapersonas;
    }

    public String getIdperson() {
        return idperson;
    }

    public void setIdperson(String idperson) {
        this.idperson = idperson;
    }

    public String getNamePer() {
        return namePer;
    }

    public void setNamePer(String namePer) {
        this.namePer = namePer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Person getPers() {
        return pers;
    }

    public void setPers(Person pers) {
        this.pers = pers;
    }
}
