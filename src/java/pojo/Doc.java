package pojo;
// Generated 06-feb-2017 10:24:18 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Doc generated by hbm2java
 */
public class Doc  implements java.io.Serializable {


     private Integer iddoc;
     private Consultation consultation;
     private Date date;
     private String description;
     private byte[] file;

    public Doc() {
    }

    public Doc(Consultation consultation, Date date, String description, byte[] file) {
       this.consultation = consultation;
       this.date = date;
       this.description = description;
       this.file = file;
    }
   
    public Integer getIddoc() {
        return this.iddoc;
    }
    
    public void setIddoc(Integer iddoc) {
        this.iddoc = iddoc;
    }
    public Consultation getConsultation() {
        return this.consultation;
    }
    
    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public byte[] getFile() {
        return this.file;
    }
    
    public void setFile(byte[] file) {
        this.file = file;
    }




}


