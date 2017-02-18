/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import pojo.Doc;

/**
 *
 * @author neuhaus
 */
public class LDocumentTest {
    
    public LDocumentTest() {
    }

    /**
     * Test of getDocuments method, of class LDocument.
     */
    @Test
    public void testGetDocuments() throws Exception {
        System.out.println("getDocuments");
        LDocument instance = new LDocument();
        List<Doc> expResult = null;
        List<Doc> result = instance.getDocuments();
        assertEquals(expResult, result);
        assertNotNull(result);
    }

    /**
     * Test of addDoc method, of class LDocument.
     */
//    @Test
//    public void testAddDoc() throws Exception {
//        System.out.println("addDoc");
//        int idcon = 0;
//        String date_doc = "";
//        String description = "";
//        byte[] fileattached = null;
//        LDocument instance = new LDocument();
//        boolean expResult = false;
//        boolean result = instance.addDoc(idcon, date_doc, description, fileattached);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updateDoc method, of class LDocument.
//     */
//    @Test
//    public void testUpdateDoc() throws Exception {
//        System.out.println("updateDoc");
//        int iddoc = 0;
//        int idcon = 0;
//        String date_doc = "";
//        String description = "";
//        byte[] fileattached = null;
//        LDocument instance = new LDocument();
//        boolean expResult = false;
//        boolean result = instance.updateDoc(iddoc, idcon, date_doc, description, fileattached);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of deleteDoc method, of class LDocument.
     */
    @Test
    public void testDeleteDoc() throws Exception {
        System.out.println("deleteDoc");
        int iddoc = 0;
        LDocument instance = new LDocument();
        boolean expResult = false;
        boolean result = instance.deleteDoc(iddoc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
