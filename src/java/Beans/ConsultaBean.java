/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Controller.ConsultasDAO;
import java.util.List;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedBean;

import pojo.Consultation;

/**
 *
 * @author neuhaus
 */
@ManagedBean
@RequestScoped
public class ConsultaBean {

    private List<Consultation> listaconsultas;
    Consultation consultation = new Consultation();
    ConsultasDAO dao = new ConsultasDAO();

    public ConsultaBean() throws Exception {
        listaconsultas = dao.listar();
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

    public void listar() throws Exception {
        try {
            dao = new ConsultasDAO();
            listaconsultas = dao.listar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void registrar() throws Exception {
        ConsultasDAO aux = new ConsultasDAO();
        try {
            aux.addConsultation(consultation);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Consultation> getListaconsultas() {
        return listaconsultas;
    }

    public void setListaconsultas(List<Consultation> listaconsultas) {
        this.listaconsultas = listaconsultas;
    }

    public static void main(String[] args) throws Exception {
        ConsultaBean b = new ConsultaBean();
        b.consultation.setIdpets(0);
        b.consultation.setDate("2018-12-12");
        b.consultation.setReason("hola");
        b.consultation.setDiagnosis("diagnosis");
        b.consultation.setObservation("observaciones");
        b.consultation.setTreatment("tratamietno");
        b.registrar();
    }

}
