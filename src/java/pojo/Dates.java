package pojo;
// Generated 06-feb-2017 10:24:18 by Hibernate Tools 4.3.1

import java.util.Date;

/**
 * Dates generated by hbm2java
 */
public class Dates implements java.io.Serializable {

    private int id;
    private Date date;
    private String person;
    private Date hour;
    private String observations;
    private int type;

    public Dates() {
    }

    public Dates(int id, String person, Date hour) {
        this.id = id;
        this.person = person;
        this.hour = hour;
    }

    public Dates(int id, String person, Date hour, String observations) {
        this.id = id;
        this.person = person;
        this.hour = hour;
        this.observations = observations;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPerson() {
        return this.person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public Date getHour() {
        return this.hour;
    }

    public void setHour(Date hour) {
        this.hour = hour;
    }

    public String getObservations() {
        return this.observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

}
