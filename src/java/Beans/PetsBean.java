/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Controller.LPets;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;
import pojo.Person;
import pojo.Pets;

/**
 *
 * @author macarena jbenitez
 */
@Named(value = "petsBean")
@RequestScoped
public class PetsBean implements Serializable {

    private Person person;
    private Pets petM = new Pets();
    private final List<Pets> listamascotas;

    private Integer idpets;
    private String name;
    private String animal;
    private int gender;
    private String race;
    private String colour;
    private String birthDate;

    /**
     * Creates a new instance of PetsBean
     *
     * @throws java.sql.SQLException
     */
    public PetsBean() throws SQLException {
        listamascotas = LPets.getPets();
    }

    /**
     * Metodo para insertar mascota
     *
     * @throws SQLException
     */
    public void addPet() throws SQLException {
        LPets.addPet(petM.getName(), petM.getAnimal(), petM.getGender(), petM.getRace(), petM.getColour(), petM.getBirthDate(), petM.getPerson().getIdperson());
        FacesMessage msg = new FacesMessage("Mascota Insertada", petM.getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    /**
     * Metodo para actualizar mascota
     *
     * @throws SQLException
     */
    public void updatePet() throws SQLException {
        LPets.updatePet(petM.getIdpets(), petM.getName(), petM.getAnimal(), petM.getGender(), petM.getRace(), petM.getColour(), petM.getBirthDate(), petM.getPerson().getIdperson());
        FacesMessage msg = new FacesMessage("Mascota Actualizada", petM.getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    /**
     * Metodo para borrar una mascota
     *
     * @throws SQLException
     */
    public void deletePet() throws SQLException {
        LPets.deletePet(petM.getIdpets());
        FacesMessage msg = new FacesMessage("Mascota Eliminada", petM.getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowEdit(RowEditEvent event) throws SQLException {
        Pets petMo = (Pets) event.getObject();
        FacesMessage msg = new FacesMessage("Persona Editada", petMo.getName());
        LPets.updatePet(petM.getIdpets(), petM.getName(), petM.getAnimal(), petM.getGender(), petM.getRace(), petM.getColour(), petM.getBirthDate(), petM.getPerson().getIdperson());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edicion Cancellada", ((Pets) event.getObject()).getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    /**
     * Metodo obtenido de internet para hacer que el filtrado no distinga entre
     * mayusculas o minusculas
     *
     * @param value
     * @param filter
     * @param locale
     * @return
     */
    public boolean filterByName(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim();
        if (filterText == null || filterText.equals("")) {
            return true;
        }

        if (value == null) {
            return false;
        }

        String namePetC = value.toString().toUpperCase();
        filterText = filterText.toUpperCase();

        if (namePetC.contains(filterText)) {
            return true;
        } else {
            return false;
        }
    }

    public Person getPerson(String dni) {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Pets getPetM() {
        return petM;
    }

    public void setPetM(Pets pet) {
        this.petM = pet;
    }

    public List<Pets> getListamascotas() {
        return listamascotas;
    }

    /*----------------------------------------------------------------------------*/
    public Integer getIdpets() {
        return idpets;
    }

    public void setIdpets(Integer idpets) {
        this.idpets = idpets;
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

}
