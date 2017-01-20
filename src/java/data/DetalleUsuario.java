/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pojo.Usuario;

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

}
