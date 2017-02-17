/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author neuhaus
 */
public class ConexionDBTest {
    
    public ConexionDBTest() {
    }

    /**
     * Test of getConexion method, of class ConexionDB.
     */
    @Test
    public void testGetConexion() {
        System.out.println("getConexion");
        ConexionDB instance = new ConexionDB();
        Connection expResult = null;
        Connection result = instance.getConexion();
        assertNotNull(result);
    
        
    }

    
}
