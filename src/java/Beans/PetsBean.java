/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Controller.LPets;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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
    private Pets pet;
    private String name;
    private String animal;
    private int gender;
    private String race;
    private String colour;
    private String birthDate;
    private String idperson;
    private String namePer;
    private String address;
    private String phone;
    private String email;
    private String password;
    private Integer role;
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public List<Pets> getListamascotas() {
        return listamascotas;
    }

    public void setListamascotas(List<Pets> listamascotas) {
        this.listamascotas = listamascotas;
    }

    public String getIdperson() {
        return person.getIdperson();
    }

    public void setIdperson(String idperson) {
        this.person.setIdperson(idperson); 
    }

    public String getNamePer() {
        return person.getNamePer();
    }

    public void setNamePer(String namePer) {
        this.person.setNamePer(namePer); 
    }

    public String getAddress() {
        return person.getAddress();
    }

    public void setAddress(String address) {
        this.person.setAddress(address);
    }

    public String getPhone() {
        return person.getPhone();
    }

    public void setPhone(String phone) {
        this.person.setPhone(phone);
    }

    public String getEmail() {
        return person.getEmail();
    }

    public void setEmail(String email) {
        this.person.setEmail(email);
    }

    public String getPassword() {
        return person.getPassword();
    }

    public void setPassword(String password) {
        this.person.setPassword(password);
    }

    public Integer getRole() {
        return person.getRole();
    }

    public void setRole(Integer role) {
        this.person.setRole(role);
    }

    public Pets getPet() {
        return pet;
    }

    public void setPet(Pets pet) {
        this.pet = pet;
    }
    
    public void addPet() throws SQLException {
        LPets.addPet(pet.getName(), pet.getAnimal(), pet.getGender(), pet.getRace(), pet.getColour(), pet.getBirthDate(), person.getNamePer());
    }
    
      public boolean filterByName(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim();
        if (filterText == null || filterText.equals("")) {
            return true;
        }

        if (value == null) {
            return false;
        }

        String name = value.toString().toUpperCase();
        filterText = filterText.toUpperCase();

        if (namePer.contains(filterText)) {
            return true;
        } else {
            return false;
        }
    }
}
