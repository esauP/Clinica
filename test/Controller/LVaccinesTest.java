/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import pojo.Vaccines;

/**
 *
 * @author neuhaus
 */
public class LVaccinesTest {
    
    public LVaccinesTest() {
    }

    /**
     * Test of getVaccines method, of class LVaccines.
     */
//    @Test
//    public void testGetVaccines() throws Exception {
//        System.out.println("getVaccines");
//        LVaccines instance = new LVaccines();
//        List<Vaccines> expResult = null;
//        List<Vaccines> result = instance.getVaccines();
//        assertNotNull(result);
//    }

//    /**
//     * Test of addVacines method, of class LVaccines.
//     */
    
    @Test
    public void testAddVacines() throws Exception {
        System.out.println("addVacines");
        int idpet = 2;
        String date = "2017-01-12";
        String observations = "21:23";
        String name = "Rabia1";
        LVaccines instance = new LVaccines();
        boolean expResult = false;
        boolean result = instance.addVacines(idpet, date, observations, name);
        assertNotNull(result);
    }

    /**
     * Test of updateVacines method, of class LVaccines.
//     */
//    @Test
//    public void testUpdateVacines() throws Exception {
//        System.out.println("updateVacines");
//        int idvac = 1;
//        int idpet = 1;
//        String date = "2020-01-01";
//        String observations = "requiere sedación con estaca cuadrada 20x20";
//        String name = "Rabia";
//        LVaccines instance = new LVaccines();
//        boolean expResult = false;
//        boolean result = instance.updateVacines(idvac, idpet, date, observations, name);
//        assertNotNull(result);
//    }

    /**
     * Test of deleteVacines method, of class LVaccines.
     */
//    @Test
//    public void testDeleteVacines() throws Exception {
//        System.out.println("deleteVacines");
//        int idvac = 3;
//        LVaccines instance = new LVaccines();
//        boolean expResult = false;
//        boolean result = instance.deleteVacines(idvac);
//        assertNotNull(result);
//    }
    
}
