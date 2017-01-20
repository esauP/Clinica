/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServ;

import data.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author cardenas
 */
@WebService(serviceName = "WS")
public class WS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     *
     * @param usuario
     * @param password
     * @return
     */
    @WebMethod(operationName = "consulta")
    public Boolean consulta(@WebParam(name = "usuario") String usuario, @WebParam(name = "password") String password) {
        ConexionDB d = new ConexionDB();
        String registros = "no exito";
        try {
            PreparedStatement pstm = d.getConexion().prepareStatement("SELECT observaciones as result FROM usuario WHERE user='" + usuario
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
