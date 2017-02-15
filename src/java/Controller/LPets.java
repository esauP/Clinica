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
                aux.setGender(rs.getInt(4));
                aux.setRace(rs.getString(5));
                aux.setColour(rs.getString(6));
                aux.setBirthDate(rs.getString(7));
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
    
    
   
    public static boolean addPet(String name_pt, String animal_pt, int gender_pt, String race_pt, String colour_pt, String birth_pt, String idper_pt) throws SQLException {
        boolean success = false;
        ConexionDB conn = new ConexionDB();
        try {
            //Llamada a la funcion
            String sql = "{ ? = call addPet (?,?,?,?,?,?,?) }";
            CallableStatement cStmt = conn.getConexion().prepareCall(sql);
            //establezco la salida de la funcion
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            //establezco los parámetros de entrada
            cStmt.setString(2, name_pt);
            cStmt.setString(3, animal_pt);
            cStmt.setInt(4, gender_pt);
            cStmt.setString(5, race_pt);
            cStmt.setString(6, colour_pt);
            cStmt.setString(7, birth_pt);
            cStmt.setString(8, idper_pt);
            //se ejecuta la funcion
            cStmt.execute();

            if (cStmt.getInt(1) == 0) {
                success = true;
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }finally{
            conn.desconectar();
        }
        return success;
    }

    public static boolean updatePet(int idpets, String name_pt, String animal_pt, int gender_pt, String race_pt, String colour_pt, String birth_pt, String idper_pt) throws SQLException {
        boolean success = false;
        ConexionDB conn = new ConexionDB();
        try {
            //Llamada a la funcion
            String sql = "{ ? = call updatePet (?,?,?,?,?,?,?,?) }";
            CallableStatement cStmt = conn.getConexion().prepareCall(sql);
            //establezco la salida de la funcion
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            //establezco los parámetros de entrada
            cStmt.setInt(2, idpets);
            cStmt.setString(3, name_pt);
            cStmt.setString(4, animal_pt);
            cStmt.setInt(5, gender_pt);
            cStmt.setString(6, race_pt);
            cStmt.setString(7, colour_pt);
            cStmt.setString(8, birth_pt);
            cStmt.setString(9, idper_pt);
            //se ejecuta la funcion
            cStmt.execute();

            if (cStmt.getInt(1) == 0) {
                success = true;
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }finally{
            conn.desconectar();
        }
        return success;
    }

    public static boolean deletePet(int idpets) throws SQLException {
        boolean success = false;
        ConexionDB conn = new ConexionDB();
        try {
            //Llamada a la funcion
            String sql = "{ ? = call deletePet (?) }";
            CallableStatement cStmt = conn.getConexion().prepareCall(sql);
            //establezco la salida de la funcion
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            //establezco los parámetros de entrada
            cStmt.setInt(2, idpets);
            //se ejecuta la funcion
            cStmt.execute();
            if (cStmt.getInt(1) == 0) {
                success = true;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }finally{
            conn.desconectar();
        }
        return success;
    }
    
}
