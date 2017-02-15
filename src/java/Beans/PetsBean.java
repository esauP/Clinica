/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Controller.LPets;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import pojo.Person;
import pojo.Pets;

/**
 *
 * @author macarena jbenitez
 */
@Named(value = "petsBean")
@RequestScoped
public class PetsBean implements Serializable{
    
    private Integer idpets;
    private Person person;
    private String name;
    private String animal;
    private Boolean gender;
    private String race;
    private String colour;
    private Date birthDate;
    private List<Pets> listamascotas;

    /**
     * Creates a new instance of PetsBean
     */
    public PetsBean() throws SQLException{
        listamascotas = LPets.getPets();
    }

    public Integer getIdpets() {
        return idpets;
    }

    public void setIdpets(Integer idpets) {
        this.idpets = idpets;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<Pets> getListamascotas() {
        return listamascotas;
    }

    public void setListamascotas(List<Pets> listamascotas) {
        this.listamascotas = listamascotas;
    }
    
}
