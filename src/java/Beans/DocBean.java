/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Controller.LConsultation;
import Controller.LDocument;
import java.sql.SQLException;
import java.util.List;
import javafx.scene.control.TableColumn;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;
import pojo.*;

/**
 *
 * @author neuhaus
 */
@Named(value = "docBean")
@ManagedBean
@RequestScoped
public class DocBean {

    private List<Doc> listadoc;
    private Doc docu = new Doc();

    public DocBean() throws SQLException {
        LDocument ld = new LDocument();
        listadoc = ld.getDocuments();
    }

    public void addDoc() throws SQLException {
        LDocument ld = new LDocument();
        ld.addDoc(docu.getIdcons(), docu.getDate_doc(), docu.getDescription(), docu.getFileattached());
    }
    
    public void deleteDoc(int Iddoc) throws SQLException {
        LDocument ld = new LDocument();
        ld.deleteDoc(Iddoc);
    }
    
    public List listar() throws SQLException{
        LDocument ld = new LDocument();
        return ld.getDocuments();
    }
    
    //methods of buttons into the table

    public void onRowEdit(RowEditEvent event) throws SQLException {
        LDocument ld = new LDocument();
        Doc docum = (Doc) event.getObject();
        FacesMessage msg = new FacesMessage("Documento Editado", String.valueOf(docum.getIddoc()));
        ld.updateDoc(docum.getIddoc(), docum.getIdcons(), docum.getDate_doc(), docum.getDescription(), docum.getFileattached());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edición Cancelada", String.valueOf(((Doc) event.getObject()).getIddoc() )); //Se ha casteado el id que estaba en integer
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCellEdit(TableColumn.CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if (newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Celda acutalizada", "Antiguo: " + oldValue + ", Nuevo:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    
    //getters and setters

    public List<Doc> getListadoc() {
        return listadoc;
    }

    public void setListadoc(List<Doc> listadoc) {
        this.listadoc = listadoc;
    }

    public Doc getDocu() {
        return docu;
    }

    public void setDocu(Doc docu) {
        this.docu = docu;
    }

    
}
