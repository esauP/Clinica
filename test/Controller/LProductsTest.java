/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import pojo.Products;

/**
 *
 * @author macarena jbenitez
 */
public class LProductsTest {
    
    public LProductsTest() {
    }

    /**
     * Test of getProducts method, of class LProducts.
     */
    @Test
    public void testGetProducts() throws Exception {
        System.out.println("getProducts");
        LProducts instance = new LProducts();
        List<Products> expResult = null;
        List<Products> result = instance.getProducts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addProduct method, of class LProducts.
     */
    @Test
    public void testAddProduct() throws Exception {
        System.out.println("addProduct");
        String name = "";
        double price = 0.0;
        int taxes = 0;
        LProducts instance = new LProducts();
        boolean expResult = false;
        boolean result = instance.addProduct(name, price, taxes);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateProduct method, of class LProducts.
     */
    @Test
    public void testUpdateProduct() throws Exception {
        System.out.println("updateProduct");
        int idproducts = 0;
        String name = "";
        double price = 0.0;
        int taxes = 0;
        LProducts instance = new LProducts();
        boolean expResult = false;
        boolean result = instance.updateProduct(idproducts, name, price, taxes);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteProduct method, of class LProducts.
     */
    @Test
    public void testDeleteProduct() throws Exception {
        System.out.println("deleteProduct");
        int idproducts = 0;
        LProducts instance = new LProducts();
        boolean expResult = false;
        boolean result = instance.deleteProduct(idproducts);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListProducts method, of class LProducts.
     */
    @Test
    public void testGetListProducts() throws Exception {
        System.out.println("getListProducts");
        LProducts instance = new LProducts();
        List<String> expResult = null;
        List<String> result = instance.getListProducts();
        for (int i=0; i<result.size();i++){
            System.out.println(result.get(i));
        }
    }
    
}
