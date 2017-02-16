/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import pojo.Consultation;

/**
 *
 * @author neuhaus
 */
public class LConsultationTest {
    
    public LConsultationTest() {
    }

    /**
     * Test of getConsultation method, of class LConsultation.
     */
//    @Test
//    public void testGetConsultation() throws Exception {
//        System.out.println("getConsultation");
//        List<Consultation> expResult = null;
//        List<Consultation> result = LConsultation.getConsultation();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addConsultation method, of class LConsultation.
//     */
//    @Test
//    public void testAddConsultation() {
//        System.out.println("addConsultation");
//        int idpet = 0;
//        String date = "";
//        String reason = "";
//        String diagnosis = "";
//        String treatment = "";
//        String observation = "";
//        boolean expResult = false;
//        boolean result = LConsultation.addConsultation(idpet, date, reason, diagnosis, treatment, observation);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of updateConsultation method, of class LConsultation.
     */
    @Test
    public void testUpdateConsultation() {
        System.out.println("updateConsultation");
        int idcons = 3;
        int idpet = 1;
        String date = "2017-02-20";
        String reason = "convulsiones";
        String diagnosis = "epilepsia";
        String treatment = "acariciar con estaca";
        String observation = "vender estaca 20x20";
        boolean expResult = false;
        boolean result = LConsultation.updateConsultation(idcons, idpet, date, reason, diagnosis, treatment, observation);
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

//    /**
//     * Test of deleteConsultation method, of class LConsultation.
//     */
//    @Test
//    public void testDeleteConsultation() {
//        System.out.println("deleteConsultation");
//        int idcons = 0;
//        boolean expResult = false;
//        boolean result = LConsultation.deleteConsultation(idcons);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
