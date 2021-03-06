package pojo;
// Generated 06-feb-2017 10:24:18 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * Person generated by hbm2java
 */
public class Person implements java.io.Serializable {

    private String idperson;
    private String namePer;
    private String address;
    private String phone;
    private String email;
    private String password;
    private Integer role;

    public Person() {
    }

    public Person(String idperson, String namePer, String phone, String password) {
        this.idperson = idperson;
        this.namePer = namePer;
        this.phone = phone;
        this.password = password;
    }

    public Person(String idperson, String namePer, String address, String phone, String email, String password, Integer role) {
        this.idperson = idperson;
        this.namePer = namePer;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.role = role;

    }

    public String getIdperson() {
        return this.idperson;
    }

    public void setIdperson(String idperson) {
        this.idperson = idperson;
    }

    public String getNamePer() {
        return this.namePer;
    }

    public void setNamePer(String namePer) {
        this.namePer = namePer;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRole() {
        return this.role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return this.namePer; //To change body of generated methods, choose Tools | Templates.
    }

}
