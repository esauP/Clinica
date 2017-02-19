/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author neuhaus
 */
public class LVaccinecalTest {

    public LVaccinecalTest() {
    }

    /**
     * Test of getVaccines method, of class LVaccinecal.
     */
    @Test
    public void testGetVaccines() throws Exception {
        System.out.println("getVaccines");
        LVaccinecal instance = new LVaccinecal();
        List<String> expResult = null;
        List<String> result = instance.getVaccines();
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

}
