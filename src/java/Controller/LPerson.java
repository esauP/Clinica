/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ConexionDB;
import pojo.Person;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author esaup
 */
public class LPerson extends ConexionDB {

    public Person getPerson(String dni) {
        Person aux = new Person();

        try {
            String sql = "Select idperson, name_per, address, phone, email from person where idperson = '" + dni + "'";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                aux.setIdperson(rs.getString(1));
                aux.setNamePer(rs.getString(2));
                aux.setAddress(rs.getString(3));
                aux.setPhone(rs.getString(4));
                aux.setEmail(rs.getString(5));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return aux;
    }

    public static List<Person> getPersons() throws SQLException {
        List<Person> listapersona = new ArrayList<Person>();
        ConexionDB conn = new ConexionDB();

        try {
            String sql = "Select idperson, name_per, address, phone, email from person ";
            PreparedStatement ps = conn.getConexion().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Person aux = new Person();
                aux.setIdperson(rs.getString(1));
                aux.setNamePer(rs.getString(2));
                aux.setAddress(rs.getString(3));
                aux.setPhone(rs.getString(4));
                aux.setEmail(rs.getString(5));
                listapersona.add(aux);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {
            conn.desconectar();
        }
        return listapersona;
    }

    public static void updateTelef(String dni, String telef) {
        String sql = "UPDATE person SET phone = '" + telef + "' WHERE idperson = '" + dni + "'";
        ConexionDB conn = new ConexionDB();
        try {
            PreparedStatement ps = conn.getConexion().prepareStatement(sql);
            ps.execute();
            conn.desconectar();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                conn.desconectar();
            } catch (SQLException ex) {
                Logger.getLogger(LPerson.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
