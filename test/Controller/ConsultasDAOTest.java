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
public class ConsultasDAOTest {
    
    public ConsultasDAOTest() {
    }

    /**
     * Test of listar method, of class ConsultasDAO.
     */
//    @Test
//    public void testListar() throws Exception {
//        System.out.println("listar");
//        ConsultasDAO instance = new ConsultasDAO();
//        List<Consultation> expResult = null;
//        List<Consultation> result = instance.listar();
////        assertEquals(expResult, result);
//        assertNotNull(result);
//    }
//
//    /**
//     * Test of addConsultation method, of class ConsultasDAO.
//     */
    @Test
    public void testAddConsultation() throws Exception {
        System.out.println("addConsultation");
        Consultation cons = null;
        ConsultasDAO instance = new ConsultasDAO();
        boolean expResult = false;
        boolean result = instance.addConsultation(cons);
        
        assertTrue(result);
    }
//
//    /**
//     * Test of updateConsultation method, of class ConsultasDAO.
//     */
//    @Test
//    public void testUpdateConsultation() {
//        System.out.println("updateConsultation");
//        Consultation cons = null;
//        ConsultasDAO instance = new ConsultasDAO();
//        boolean expResult = false;
//        boolean result = instance.updateConsultation(cons);
//        assertNotNull(result);
//    }
//
//    /**
//     * Test of deleteConsultation method, of class ConsultasDAO.
//     */
//    @Test
//    public void testDeleteConsultation() {
//        System.out.println("deleteConsultation");
//        Consultation cons = null;
//        ConsultasDAO instance = new ConsultasDAO();
//        boolean expResult = false;
//        boolean result = instance.deleteConsultation(cons);
////        assertNotNull(result);
//    }
    
}
