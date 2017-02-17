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
import pojo.Bill;

/**
 *
 * @author macarena jbenitez
 */
public class LBill {
    
    public static List<Bill> getList() throws SQLException {
        List<Bill> listafacturas = new ArrayList<Bill>();
        ConexionDB conn = new ConexionDB();

        try {
            String sql = "Select idbill, idpers, date, observations from bill";
            PreparedStatement ps = conn.getConexion().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Bill aux = new Bill();
                aux.setIdbill(rs.getInt(1));
                aux.setIdper(rs.getString(2));
                aux.setDate(rs.getString(3));
                aux.setObservations(rs.getString(4));
                listafacturas.add(aux);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {
            conn.desconectar();
        }
        return listafacturas;
    }
    
        /**
     * Método para añadir una nueva factura
     * @param idBill
     * @param idPer
     * @param date
     * @param obser
     * @return
     * @throws SQLException 
     */
    public static boolean addBill(int idBill, String idPer, String date, String obser) throws SQLException {
        boolean success = false;
        ConexionDB conn = new ConexionDB();
        try {
            //Llamada a la funcion
            String sql = "{ ? = call addBill (?,?,?,?) }";
            CallableStatement cStmt = conn.getConexion().prepareCall(sql);
            //establezco la salida de la funcion
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            //establezco los parámetros de entrada
            cStmt.setInt(2, idBill);
            cStmt.setString(3, idPer);
            cStmt.setString(4, date);
            cStmt.setString(5, obser);
            //se ejecuta la funcion
            cStmt.execute();

            if (cStmt.getInt(1) == 0) {
                //System.out.println(cStmt.getInt(1));
                success = true;
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            conn.desconectar();
        }
        return success;
    }

    
}
