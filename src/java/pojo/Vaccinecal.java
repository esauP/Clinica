package pojo;
// Generated 06-feb-2017 10:24:18 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Vaccinecal generated by hbm2java
 */
public class Vaccinecal  implements java.io.Serializable {


     private String name;
     private String typeanimal;
     private String periodicity;
     private Set vaccineses = new HashSet(0);

    public Vaccinecal() {
    }

	
    public Vaccinecal(String name, String typeanimal, String periodicity) {
        this.name = name;
        this.typeanimal = typeanimal;
        this.periodicity = periodicity;
    }
    public Vaccinecal(String name, String typeanimal, String periodicity, Set vaccineses) {
       this.name = name;
       this.typeanimal = typeanimal;
       this.periodicity = periodicity;
       this.vaccineses = vaccineses;
    }
   
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getTypeanimal() {
        return this.typeanimal;
    }
    
    public void setTypeanimal(String typeanimal) {
        this.typeanimal = typeanimal;
    }
    public String getPeriodicity() {
        return this.periodicity;
    }
    
    public void setPeriodicity(String periodicity) {
        this.periodicity = periodicity;
    }
    public Set getVaccineses() {
        return this.vaccineses;
    }
    
    public void setVaccineses(Set vaccineses) {
        this.vaccineses = vaccineses;
    }




}


