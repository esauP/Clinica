/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ConexionDB;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pojo.*;

/**
 *
 * @author neuhaus
 */
public class LDocument extends ConexionDB {

    public List<Doc> getDocuments() throws SQLException {
        List<Doc> listadoc = new ArrayList<Doc>();
        ConexionDB conn = new ConexionDB();
        try {
            String sql = "Select iddoc, idcons, date_doc, description, fileattached from doc";
            PreparedStatement ps = conn.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Doc aux = new Doc();
                aux.setIddoc(rs.getInt("iddoc"));
                aux.setIdcons(rs.getInt("idcons"));
                aux.setDate_doc(rs.getString("date_doc"));
                aux.setDescription(rs.getString("description"));
                aux.setFileattached(rs.getBytes("fileattached"));
                listadoc.add(aux);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            conn.desconectar();
        }
        return listadoc;
    }

    public boolean addDoc(int idcon, String date_doc, String description, byte[] fileattached) throws SQLException {
        ConexionDB conn = new ConexionDB();
        boolean success = false;
        try {
            //Llamada a la funcion
            String sql = "{ ? = call addDoc (?,?,?,?) }";
            CallableStatement cStmt = this.getConexion().prepareCall(sql);
            //establezco la salida de la funcion
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            //establezco los parámetros de entrada
            cStmt.setInt(2, idcon);
            cStmt.setString(3, date_doc);
            cStmt.setString(4, description);
            cStmt.setBytes(5, fileattached);
            //se ejecuta la funcion
            cStmt.execute();
            if (cStmt.getInt(1) == 0) {
                success = true;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            conn.desconectar();
        }
        return success;
    }

    public boolean updateDoc(int iddoc, int idcon, String date_doc, String description, byte[] fileattached) throws SQLException {
        ConexionDB conn = new ConexionDB();
        boolean success = false;
        try {
            //Llamada a la funcion
            String sql = "{ ? = call updateDoc (?,?,?,?,?) }";
            CallableStatement cStmt = this.getConexion().prepareCall(sql);
            //establezco la salida de la funcion
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            //establezco los parámetros de entrada
            cStmt.setInt(2, iddoc);
            cStmt.setInt(3, idcon);
            cStmt.setString(4, date_doc);
            cStmt.setString(5, description);
            cStmt.setBytes(6, fileattached);
            //se ejecuta la funcion
            cStmt.execute();
            if (cStmt.getInt(1) == 0) {
                success = true;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            conn.desconectar();
        }
        return success;
    }

    public boolean deleteDoc(int iddoc) throws SQLException {
        ConexionDB conn = new ConexionDB();
        boolean success = false;
        try {
            //Llamada a la funcion
            String sql = "{ ? = call deleteDoc (?) }";
            CallableStatement cStmt = this.getConexion().prepareCall(sql);
            //establezco la salida de la funcion
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            //establezco los parámetros de entrada
            cStmt.setInt(2, iddoc);
            //se ejecuta la funcion
            cStmt.execute();
            if (cStmt.getInt(1) == 0) {
                success = true;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            conn.desconectar();
        }
        return success;
    }
    
//    public static void main (String [] args) throws SQLException{
//        LDocument d = new LDocument();
//        System.out.println(d.getDocuments().size());
//        System.out.println(d.getDocuments().toString());
//    }

}
