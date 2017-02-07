/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadao;

import data.ConexionDB;
import pojo.Person;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

}
