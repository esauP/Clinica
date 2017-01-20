/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.SQLException;
import pojo.Usuario;

/**
 *
 * @author esaup
 */
public interface IUsuario {
    public Usuario getUsuario(String user, String pas) throws SQLException;
}
