/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Controller.LBill;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import pojo.Bill;
import pojo.Pets;

/**
 *
 * @author macarena jbenitez
 */
@Named(value = "billBean")
@ManagedBean
@RequestScoped
public class BillBean implements Serializable{

    private int idbill;
    private String idper;
    private String date;
    private String observations;
    private List<Bill> listafacturas;
    private Bill fac = new Bill();

    
    /**
     * Metodo para insertar una nueva factura
     *
     * @throws SQLException
     */
    public void AddBill() throws SQLException {
        LBill.addBill(fac.getIdper(), fac.getDate(), fac.getObservations());
        FacesMessage msg = new FacesMessage("Factura Insertada", fac.getIdbill().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
     /**
     * Metodo para eliminar una factura
     *
     * @throws SQLException
     */
    public void DeleteBill() throws SQLException {
        LBill.deleteBill(fac.getIdbill());
        FacesMessage msg = new FacesMessage("Factura Eliminada", fac.getIdbill().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void ListPets() throws SQLException{
        LBill.listPets();
    }
    
    public void ListProd() throws SQLException{
        LBill.listProd();
    }
    
    public BillBean() throws SQLException{
        listafacturas = LBill.getList();
    }

    public Integer getIdbill() {
        return idbill;
    }

    public void setIdbill(Integer idbill) {
        this.idbill = idbill;
    }

    public String getIdper() {
        return idper;
    }

    public void setIdper(String idper) {
        this.idper = idper;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public List<Bill> getListafacturas() {
        return listafacturas;
    }

    public void setListafacturas(List<Bill> listafacturas) {
        this.listafacturas = listafacturas;
    }

    public Bill getFac() {
        return fac;
    }

    public void setFac(Bill fac) {
        this.fac = fac;
    }
    
}
