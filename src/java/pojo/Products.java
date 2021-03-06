package pojo;
// Generated 06-feb-2017 10:24:18 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * Products generated by hbm2java
 */
public class Products implements java.io.Serializable {

    private int idproducts;
    private String name;
    private double price;
    private int taxes;
    private Set billlLineses = new HashSet(0);

    public Products() {
    }

    public Products(String name, double price, int taxes) {
        this.name = name;
        this.price = price;
        this.taxes = taxes;
    }

    public Products(String name, double price, int taxes, Set billlLineses) {
        this.name = name;
        this.price = price;
        this.taxes = taxes;
        this.billlLineses = billlLineses;
    }

    public int getIdproducts() {
        return this.idproducts;
    }

    public void setIdproducts(int idproducts) {
        this.idproducts = idproducts;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTaxes() {
        return this.taxes;
    }

    public void setTaxes(int taxes) {
        this.taxes = taxes;
    }

    public Set getBilllLineses() {
        return this.billlLineses;
    }

    public void setBilllLineses(Set billlLineses) {
        this.billlLineses = billlLineses;
    }

    @Override
    public String toString() {
        return idproducts + "-" + name;
    }

}
