/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.sql.SQLException;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import pojo.Products;
import pojo.BillLines;
import Controller.LBillLine;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author macarena jbenitez
 */
@Named(value = "billLineBeans")
@Dependent
public class BillLineBeans {

    private int id;
    private int idbill;
    private int idpets;
    private Products product = new Products();
    private int quantity;
    private double price;
    private int taxes;
    private int discount;
    private String observations;
    private List<BillLines> listalineasfac;
    private BillLines blines = new BillLines();

    public BillLineBeans() throws SQLException {
        listalineasfac = LBillLine.getList();
    }

    public void onRowEdit(RowEditEvent event) throws SQLException {
        BillLines billli = (BillLines) event.getObject();
        FacesMessage msg = new FacesMessage("Precio Editado", billli.getPrice().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edicion Cancelada", ((Products) event.getObject()).getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void AddLine() throws SQLException {
        LBillLine.addLinea(blines.getId(), idbill ,this.product.getIdproducts() ,
                blines.getQuantity(), blines.getPrice(), blines.getTaxes(), blines.getDiscount(),
                idpets, blines.getObservations());
        FacesMessage msg = new FacesMessage("Línea Insertada");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void DeleteLine() throws SQLException {
        LBillLine.deleteBillLine(blines.getId());
        FacesMessage msg = new FacesMessage("Línea Eliminada");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void Addcart() {
        BillLines fact = new BillLines(0, this.idbill, this.idpets, this.product.getIdproducts(), this.quantity, this.price, this.taxes, this.discount, this.observations);
        listalineasfac.add(fact);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBill() {
        return idbill;
    }

    public void setBill(int idbill) {
        this.idbill = idbill;
    }

    public int getPets() {
        return idpets;
    }

    public void setPets(int pets) {
        this.idpets = pets;
    }

    public Products getProducts() {
        return product;
    }

    public void setProducts(Products idproduct) {
        this.product = idproduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

}
