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
public class ConsultasDAO extends ConexionDB {

    public List<Consultation> listar() throws Exception {
        List<Consultation> lista = null;
        ConexionDB conn = new ConexionDB();

        try {
            String sql = "Select idcons, idpet, date_consultation, reason, diagnosis, treatment, observation FROM consultation";
            PreparedStatement ps = conn.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Consultation aux = new Consultation();
                aux.setIdcons(rs.getInt("idcons"));
                aux.setIdpets(rs.getInt("idpet"));
                aux.setDate(rs.getString("date_consultation"));
                aux.setReason(rs.getString("reason"));
                aux.setDiagnosis(rs.getString("diagnosis"));
                aux.setTreatment(rs.getString("treatment"));
                aux.setObservation(rs.getString("observation"));
                lista.add(aux);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            conn.desconectar();
        }
        return lista;
    }

    public boolean addConsultation(Consultation cons) throws SQLException {
        //int idpet, String date, String reason, String diagnosis, String treatment, String observation
        ConexionDB conn = new ConexionDB();
        boolean success = false;
        try {
            //Llamada a la funcion
            String sql = "{ ? = call addConsultation (?,?,?,?,?,?) }";
            CallableStatement cStmt = conn.getConexion().prepareCall(sql);
            //establezco la salida de la funcion
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            //establezco los parámetros de entrada
            cStmt.setInt(2, cons.getIdpets());
            cStmt.setString(3, cons.getDate());
            cStmt.setString(4, cons.getReason());
            cStmt.setString(5, cons.getDiagnosis());
            cStmt.setString(6, cons.getTreatment());
            cStmt.setString(7, cons.getObservation());
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

    public boolean updateConsultation(Consultation cons) throws SQLException {
        //int idcons, int idpet, String date, String reason, String diagnosis, String treatment, String observation
        boolean success = false;
        ConexionDB conn = new ConexionDB();
        try {
            //Llamada a la funcion
            String sql = "{ ? = call updateConsultation (?,?,?,?,?,?,?) }";
            CallableStatement cStmt = conn.getConexion().prepareCall(sql);
            //establezco la salida de la funcion
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            //establezco los parámetros de entrada
            cStmt.setInt(2, cons.getIdcons());
            cStmt.setInt(3, cons.getIdpets());
            cStmt.setString(4, cons.getDate());
            cStmt.setString(5, cons.getReason());
            cStmt.setString(6, cons.getDiagnosis());
            cStmt.setString(7, cons.getTreatment());
            cStmt.setString(8, cons.getObservation());
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

    public boolean deleteConsultation(Consultation cons) throws SQLException {
        boolean success = false;
        ConexionDB conn = new ConexionDB();
        try {
            //Llamada a la funcion
            String sql = "{ ? = call deleteConsultation (?) }";
            CallableStatement cStmt = conn.getConexion().prepareCall(sql);
            //establezco la salida de la funcion
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            //establezco los parámetros de entrada
            cStmt.setInt(2, cons.getIdcons());
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

    public static void main(String[] args) throws SQLException {
        ConsultasDAO d = new ConsultasDAO();
        Consultation cons = new Consultation();
        cons.setIdpets(0);
        cons.setDate("2018-12-12");
        cons.setReason("hola");
        cons.setDiagnosis("diagnosis");
        cons.setObservation("observaciones");
        cons.setTreatment("tratamietno");
        System.out.println(cons.toString());
        d.addConsultation(cons);
    }

}
