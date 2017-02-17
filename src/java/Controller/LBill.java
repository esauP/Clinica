/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ConexionDB;
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
    
}
