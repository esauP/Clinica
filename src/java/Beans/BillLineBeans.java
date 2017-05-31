/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.sql.SQLException;
import java.util.List;
import javax.inject.Named;
import pojo.Products;
import pojo.BillLines;
import Controller.LBillLine;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;
import pojo.Pets;

/**
 *
 * @author macarena jbenitez
 */
@Named(value = "billLineBeans")
@ManagedBean
@RequestScoped
public class BillLineBeans {

    private int id;
    private int idbill;
    private int quantity;
    private int taxes;
    private int discount;
    private double price;
    private String observations;
    private Products prod;
    private Pets pet;
    private List<BillLines> listalineasfac;
    private BillLines blines = new BillLines();

    public BillLineBeans() throws SQLException {
        listalineasfac = LBillLine.getList();
    }

    public void onRowEdit(RowEditEvent event) throws SQLException {
        FacesMessage msg = new FacesMessage("Precio Editado");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edicion Cancelada", ((Products) event.getObject()).getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void AddLine() throws SQLException {

        for (BillLines line : listalineasfac) {
            LBillLine.addLinea(idbill, line.getProduct().getIdproducts(),
                    line.getQuantity(), line.getPrice(), line.getTaxes(), line.getDiscount(), line.getIdpet(), line.getObservations());
        }
        FacesMessage msg = new FacesMessage("Línea Insertada");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void DeleteLine() throws SQLException {
        LBillLine.deleteBillLine(blines.getId());
        FacesMessage msg = new FacesMessage("Línea Eliminada");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void Addcart() {
        BillLines fact = new BillLines(pet.getIdpets(), prod, quantity, price, taxes, discount);
        this.listalineasfac.add(fact);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdbill() {
        return idbill;
    }

    public void setIdbill(int idbill) {
        this.idbill = idbill;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTaxes() {
        return taxes;
    }

    public void setTaxes(int taxes) {
        this.taxes = taxes;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public List<BillLines> getListalineasfac() {
        return listalineasfac;
    }

    public void setListalineasfac(List<BillLines> listalineasfac) {
        this.listalineasfac = listalineasfac;
    }

    public BillLines getBlines() {
        return blines;
    }

    public void setBlines(BillLines blines) {
        this.blines = blines;
    }

    public Products getProd() {
        return prod;
    }

    public void setProd(Products prod) {
        this.prod = prod;
    }

    public Pets getPet() {
        return pet;
    }

    public void setPet(Pets pet) {
        this.pet = pet;
    }

}
