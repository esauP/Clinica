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
import pojo.Vaccines;

/**
 *
 * @author neuhaus
 */
public class LVaccines extends ConexionDB {

    public List<Vaccines> getVaccines() throws SQLException {
        List<Vaccines> listavacunas = new ArrayList<Vaccines>();
        try {
            String sql = "SELECT idvac, idpet, date_vaccine, observations, name FROM vaccines";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Vaccines aux = new Vaccines();
                aux.setIdvac(rs.getInt("idvac"));
                aux.setIdpet(rs.getInt("idpet"));
                aux.setDate_vaccine(rs.getString("date_vaccine"));
                aux.setObservaciones(rs.getString("observations"));
                aux.setName_vaccine(rs.getString("name"));
                listavacunas.add(aux);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            this.desconectar();
        }
        return listavacunas;
    }

    public boolean addVacines(int idpet, String date, String observations, String name) throws SQLException {
        boolean success = false;
        try {
            //Llamada a la funcion
            String sql = "{ ? = call addVacines (?,?,?,?) }";
            CallableStatement cStmt = this.getConexion().prepareCall(sql);
            //establezco la salida de la funcion
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            //establezco los parámetros de entrada
            cStmt.setInt(2, idpet);
            cStmt.setString(3, date);
            cStmt.setString(4, observations);
            cStmt.setString(5, name);
            //se ejecuta la funcion
            cStmt.execute();
            if (cStmt.getInt(1) == 0) {
                success = true;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            this.desconectar();
        }
        return success;
    }

    public boolean updateVacines(int idvac, int idpet, String date, String observations, String name) throws SQLException {
        boolean success = false;
        try {
            //Llamada a la funcion
            String sql = "{ ? = call updateVacines (?,?,?,?,?) }";
            CallableStatement cStmt = this.getConexion().prepareCall(sql);
            //establezco la salida de la funcion
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            //establezco los parámetros de entrada
            cStmt.setInt(2, idvac);
            cStmt.setInt(3, idpet);
            cStmt.setString(4, date);
            cStmt.setString(5, observations);
            cStmt.setString(6, name);
            //se ejecuta la funcion
            cStmt.execute();
            if (cStmt.getInt(1) == 0) {
                success = true;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            this.desconectar();
        }
        return success;
    }

    public boolean deleteVacines(int idvac) throws SQLException {
        boolean success = false;
        try {
            //Llamada a la funcion
            String sql = "{ ? = call deleteVacines (?) }";
            CallableStatement cStmt = this.getConexion().prepareCall(sql);
            //establezco la salida de la funcion
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            //establezco los parámetros de entrada
            cStmt.setInt(2, idvac);
            //se ejecuta la funcion
            cStmt.execute();
            if (cStmt.getInt(1) == 0) {
                success = true;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            this.desconectar();
        }
        return success;
    }

}
