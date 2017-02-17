/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pojo.Bill;
import pojo.BillLines;
import pojo.Pets;
import pojo.Products;

/**
 *
 * @author macarena jbenitez
 */
public class LBillLine {
    
     public static List<BillLines> getList() throws SQLException {
        List<BillLines> listalineasfac = new ArrayList<BillLines>();
        ConexionDB conn = new ConexionDB();

        try {
            String sql = "Select  from where ";
            PreparedStatement ps = conn.getConexion().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
           
            while (rs.next()) {
                BillLines aux = new BillLines();
                Bill auxBill = new Bill();
                Pets auxPet = new Pets();
                Products auxProd = new Products();
                
                aux.setId(rs.getInt(1));
                    auxBill.setIdbill(rs.getInt(2));
                    auxBill.setIdper(rs.getString(3));
                    auxBill.setDate(rs.getString(4));
                    auxBill.setObservations(rs.getString(5));
                        auxPet.setIdpets(rs.getInt(6));
                        auxPet.setName(rs.getString(7));
                        auxPet.setAnimal(rs.getString(8));
                        auxPet.setGender(rs.getInt(9));
                        auxPet.setRace(rs.getString(10));
                        auxPet.setColour(rs.getString(11));
                        auxPet.setBirthDate(rs.getString(12));
                            auxProd.setIdproducts(rs.getInt(13));
                            auxProd.setName(rs.getString(14));
                            auxProd.setPrice(rs.getDouble(15));
                            auxProd.setTaxes(rs.getInt(16));
                aux.setQuantity(rs.getInt(17));
                aux.setTaxes(rs.getInt(18));
                aux.setDiscount(rs.getInt(19));
                aux.setObservations(rs.getString(20));
                listalineasfac.add(aux);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {
            conn.desconectar();
        }
        return listalineasfac;
    }
}
