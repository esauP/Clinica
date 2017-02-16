/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import pojo.Pets;

/**
 *
 * @author esaup
 */
public class LPetsTest {
    
    public LPetsTest() {
    }

    /**
     * Test of getPets method, of class LPets.
     */
    @Test
    public void testGetPets() throws Exception {
        System.out.println("getPets");
        List<Pets> expResult = null;
        List<Pets> result = LPets.getPets();
        assertNotNull(result);
       // assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    //    fail("The test case is a prototype.");
    }

    /**
     * Test of addPet method, of class LPets.
     */
    @Test
    public void testAddPet() throws Exception {
        System.out.println("addPet");
        String name_pt = "";
        String animal_pt = "";
        int gender_pt = 0;
        String race_pt = "";
        String colour_pt = "";
        String birth_pt = "";
        String idper_pt = "";
        boolean expResult = false;
        boolean result = LPets.addPet(name_pt, animal_pt, gender_pt, race_pt, colour_pt, birth_pt, idper_pt);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updatePet method, of class LPets.
     */
    @Test
    public void testUpdatePet() throws Exception {
        System.out.println("updatePet");
        int idpets = 0;
        String name_pt = "";
        String animal_pt = "";
        int gender_pt = 0;
        String race_pt = "";
        String colour_pt = "";
        String birth_pt = "";
        String idper_pt = "";
        boolean expResult = false;
        boolean result = LPets.updatePet(idpets, name_pt, animal_pt, gender_pt, race_pt, colour_pt, birth_pt, idper_pt);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletePet method, of class LPets.
     */
    @Test
    public void testDeletePet() throws Exception {
        System.out.println("deletePet");
        int idpets = 0;
        boolean expResult = false;
        boolean result = LPets.deletePet(idpets);
     //   assertNotNull(result);
       // assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
}
