/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author esaup
 */
public class Login extends ConexionDB {

    public Boolean consulta(String usuario, String password) {
        ConexionDB d = new ConexionDB();
        String registros = "no exito";
        try {
            PreparedStatement pstm = d.getConexion().prepareStatement("SELECT role as result FROM person WHERE idperson='" + usuario
                    + "' AND password='" + password + "'");
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getString("result");
            res.close();
            d.desconectar();

            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }

    }

}
