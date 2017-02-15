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
import pojo.Person;
import pojo.Pets;

/**
 *
 * @author macarena jbenitez
 */
public class LPets extends ConexionDB{
    
    public static List<Pets> getPets() throws SQLException {
        List<Pets> listamascotas = new ArrayList<Pets>();
        ConexionDB conn = new ConexionDB();

        try {
            String sql = "Select * from pets join person where pets.idper = person.idperson";
            PreparedStatement ps = conn.getConexion().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                Pets aux = new Pets();
                aux.setIdpets(rs.getInt(1));
                aux.setName(rs.getString(2));
                aux.setAnimal(rs.getString(3));
                aux.setGender(rs.getBoolean(4));
                aux.setRace(rs.getString(5));
                aux.setColour(rs.getString(6));
                aux.setBirthDate(rs.getDate(7));
                Person auxPer = new Person();
                    auxPer.setIdperson(rs.getString(8));
                    auxPer.setNamePer(rs.getString(9));
                    auxPer.setAddress(rs.getString(10));
                    auxPer.setPhone(rs.getString(11));
                    auxPer.setEmail(rs.getString(12));
                    auxPer.setPassword(rs.getString(13));
                    auxPer.setRole(rs.getInt(14));
                aux.setPerson(auxPer);
                listamascotas.add(aux);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {
            conn.desconectar();
        }
        return listamascotas;
    }
    
}
