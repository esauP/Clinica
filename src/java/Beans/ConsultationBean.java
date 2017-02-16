/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Controller.LConsultation;
import Controller.LPerson;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javafx.scene.control.TableColumn;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;
import pojo.*;

/**
 *
 * @author neuhaus
 */
@Named(value = "consultationBean")
@ManagedBean
@RequestScoped
public class ConsultationBean {

    private Integer idcons;
    private Pets pets;
    private String idpets;
    private Date date;
    private String reason;
    private String diagnosis;
    private String treatment;
    private String observation;

    private List<Consultation> listaconsultas;
    private Consultation consult = new Consultation();

    public ConsultationBean() throws SQLException {
        listaconsultas = LConsultation.getConsultation();
    }

    public void onRowEdit(RowEditEvent event) {
        Consultation consulta = (Consultation) event.getObject();
        FacesMessage msg = new FacesMessage("Consulta Editada", consulta.getIdcons().toString());
        LConsultation.updateConsultation(consulta.getIdcons(), Integer.parseInt(consulta.getIdpets()), consulta.getDate(), consulta.getReason(), consulta.getDiagnosis(), consulta.getTreatment(), consulta.getObservation());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edicion Cancellada", String.valueOf(((Consultation) event.getObject()).getIdcons())); //Se ha casteado el id que estaba en integer
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCellEdit(TableColumn.CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if (newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Celda acutalizada", "Antiguo: " + oldValue + ", Nuevo:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void AddConsultation() throws SQLException {
        LConsultation.addConsultation(consult.getIdcons(), consult.getIdpets(), consult.getReason(), consult.getDiagnosis(),
                consult.getTreatment(), consult.getObservation());
    }

    public void EliminarConsultation() throws SQLException {
        LConsultation.deleteConsultation(consult.getIdcons());
    }

    public Integer getIdcons() {
        return idcons;
    }

    public void setIdcons(Integer idcons) {
        this.idcons = idcons;
    }

    public Pets getPets() {
        return pets;
    }

    public void setPets(Pets pets) {
        this.pets = pets;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public List<Consultation> getListaconsultas() {
        return listaconsultas;
    }

    public void setListaconsultas(List<Consultation> listaconsultas) {
        this.listaconsultas = listaconsultas;
    }

    public String getIdpets() {
        return idpets;
    }

    public void setIdpets(String idpets) {
        this.idpets = idpets;
    }

    public Consultation getConsult() {
        return consult;
    }

    public void setConsult(Consultation consult) {
        this.consult = consult;
    }

}
