/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import pojo.Usuario;
//asasd
/**
 *
 * @author esaup
 */
public class DetalleUsuario extends ConexionDB implements IUsuario {

    /**
     *
     * @param user
     * @param pass
     * @return
     * @throws SQLException
     */
    @Override
    public Usuario getUsuario(String user, String pass) throws SQLException {
        Usuario us = new Usuario();

        String sql = "select observaciones from usuario where user = ? and password = ?";

        PreparedStatement ps = this.getConexion().prepareStatement(sql);

        ps.setString(1, user);
        ps.setString(2, pass);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            us.setPass(pass);
            us.setUsuario(user);
            us.setObservaciones(rs.getString("observaciones"));
        }
        this.desconectar();

        return us;
    }

    public List AllUsuarios() {

        PreparedStatement stmt = null;
        List searchResults = new LinkedList();
        ResultSet result = null;

        try {

            String sql = "SELECT * FROM usuario";
            stmt = this.getConexion().prepareStatement(sql);
            stmt.executeQuery();
            result = stmt.executeQuery();

            while (result.next()) {
                Usuario temp = new Usuario();
                temp.setUsuario(result.getString("user"));
                temp.setPass(result.getString("password"));
                temp.setObservaciones(result.getString("observaciones"));

                searchResults.add(temp);
            }
        } catch (SQLException e) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("ErrorCode: " + e.getErrorCode());
        } finally {

            try {
                if (result != null) {
                    result.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
            }

        }
        return searchResults;
    }

}
