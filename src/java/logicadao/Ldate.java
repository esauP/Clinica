/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import data.ConexionDB;
import java.util.ArrayList;
import java.util.Date;
import pojo.Dates;

/**
 *
 * @author esaup
 */
public class Ldate extends ConexionDB {

    public ArrayList<Dates> getDates() {
        ArrayList<Dates> lista = new ArrayList<>();

        String sql = "Select * from dates";
        try {
            PreparedStatement ps = this.getConexion().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Dates dd = new Dates();

                dd.setId(rs.getInt("iddate"));
                dd.setDate(rs.getDate("date"));
                dd.setHour(rs.getTime("hour"));
                dd.setPerson(rs.getString("idperson"));
                dd.setType(rs.getInt("type"));
                dd.setObservations(rs.getString("observations"));

                lista.add(dd);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
}
