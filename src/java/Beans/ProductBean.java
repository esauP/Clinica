/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Controller.LProducts;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import pojo.Products;

/**
 *
 * @author macarena jbenitez
 */
@Named(value = "productBean")
@ManagedBean
@RequestScoped

public class ProductBean {

    private List<Products> listproducts;
    private List<String> listamaestra;
    private Products prod = new Products();
    
    
    public ProductBean() throws SQLException{
        LProducts lp = new LProducts();
        listproducts = lp.getProducts();
        listamaestra = lp.getListProducts();
    }
    
    public List listar() throws SQLException {
        LProducts lp = new LProducts();
        return lp.getProducts();
    }
    
    public void addProduct() throws SQLException {
        LProducts lp = new LProducts();
        lp.addProduct(prod.getName(), prod.getPrice(), prod.getTaxes());
    }

    public void deleteProduct(int idprod) throws SQLException {
        LProducts lp = new LProducts();
        lp.deleteProduct(idprod);
    }

    public List<Products> getListproducts() {
        return listproducts;
    }

    public void setListproducts(List<Products> listproducts) {
        this.listproducts = listproducts;
    }

    public List<String> getListamaestra() {
        return listamaestra;
    }

    public void setListamaestra(List<String> listamaestra) {
        this.listamaestra = listamaestra;
    }

    public Products getProd() {
        return prod;
    }

    public void setProd(Products prod) {
        this.prod = prod;
    }
    
    public List<String> AutocompletarNameProd(String text) {
        // Assumed search using the startsWith
        List<String> queried = new ArrayList<>();
        for (int i = 0; i < this.listamaestra.size(); i++) {
            String nameProd = this.listamaestra.get(i);
            if (nameProd.toLowerCase().startsWith(text) || nameProd.startsWith(text)) {
                queried.add(nameProd);
            }
        }
        return queried;
    }
    
}
