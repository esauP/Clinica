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
import pojo.Bill;
import pojo.Pets;
import pojo.Products;
import pojo.BillLines;
import Controller.LBillLine;

/**
 *
 * @author macarena jbenitez
 */
@Named(value = "billLineBeans")
@Dependent
public class BillLineBeans {

    private int id;
    private Bill bill;
    private Pets pets;
    private Products products;
    private Integer quantity;
    private Double price;
    private Integer taxes;
    private Integer discount;
    private String observations;
    private List<BillLines> listalineasfac;
    private BillLines blines = new BillLines();
    
    public BillLineBeans() throws SQLException{
        listalineasfac = LBillLine.getList();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Pets getPets() {
        return pets;
    }

    public void setPets(Pets pets) {
        this.pets = pets;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getTaxes() {
        return taxes;
    }

    public void setTaxes(Integer taxes) {
        this.taxes = taxes;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
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
