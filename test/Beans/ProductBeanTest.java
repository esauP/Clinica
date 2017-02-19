/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.sql.SQLException;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pojo.Products;

/**
 *
 * @author macarena jbenitez
 */
public class ProductBeanTest {
    
    public ProductBeanTest() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of listar method, of class ProductBean.
     */
    @Test
    public void testListar() throws Exception {
        System.out.println("listar");
        ProductBean instance = new ProductBean();
        List expResult = null;
        List result = instance.listar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addProduct method, of class ProductBean.
     */
    @Test
    public void testAddProduct() throws Exception {
        System.out.println("addProduct");
        ProductBean instance = new ProductBean();
        instance.addProduct();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteProduct method, of class ProductBean.
     */
    @Test
    public void testDeleteProduct() throws Exception {
        System.out.println("deleteProduct");
        int idprod = 0;
        ProductBean instance = new ProductBean();
        instance.deleteProduct(idprod);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListproducts method, of class ProductBean.
     */
    @Test
    public void testGetListproducts() throws SQLException {
        System.out.println("getListproducts");
        ProductBean instance = new ProductBean();
        List<Products> expResult = null;
        List<Products> result = instance.getListproducts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListproducts method, of class ProductBean.
     */
    @Test
    public void testSetListproducts() throws SQLException {
        System.out.println("setListproducts");
        List<Products> listproducts = null;
        ProductBean instance = new ProductBean();
        instance.setListproducts(listproducts);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListamaestra method, of class ProductBean.
     */
    @Test
    public void testGetListamaestra() throws SQLException {
        System.out.println("getListamaestra");
        ProductBean instance = new ProductBean();
        List<String> expResult = null;
        List<String> result = instance.getListamaestra();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListamaestra method, of class ProductBean.
     */
    @Test
    public void testSetListamaestra() throws SQLException {
        System.out.println("setListamaestra");
        List<String> listamaestra = null;
        ProductBean instance = new ProductBean();
        instance.setListamaestra(listamaestra);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProd method, of class ProductBean.
     */
    @Test
    public void testGetProd() throws SQLException {
        System.out.println("getProd");
        ProductBean instance = new ProductBean();
        Products expResult = null;
        Products result = instance.getProd();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProd method, of class ProductBean.
     */
    @Test
    public void testSetProd() throws SQLException {
        System.out.println("setProd");
        Products prod = null;
        ProductBean instance = new ProductBean();
        instance.setProd(prod);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AutocompletarNameProd method, of class ProductBean.
     */
    @Test
    public void testAutocompletarNameProd() throws SQLException {
        System.out.println("AutocompletarNameProd");
        String text = "";
        ProductBean instance = new ProductBean();
        List<String> expResult = null;
        List<String> result = instance.AutocompletarNameProd(text);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
