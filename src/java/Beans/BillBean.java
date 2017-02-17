/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Controller.LBill;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import pojo.Bill;

/**
 *
 * @author macarena jbenitez
 */
@Named(value = "billBean")
@ManagedBean
@RequestScoped
public class BillBean implements Serializable{

    private Integer idbill;
    private String idper;
    private String date;
    private String observations;
    private List<Bill> listafacturas;
    private Bill fac = new Bill();

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
