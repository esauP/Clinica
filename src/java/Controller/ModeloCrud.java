/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ConexionDB;
import java.sql.CallableStatement;
import java.sql.SQLException;

/**
 * @author Esau, Macarena, Víctor Clase para las llamadas a las funciones PLSQL
 * que realizan el crud de los objetos en la base de datos
 *
 */
public class ModeloCrud extends ConexionDB {

    

    /**
     * Método para modificar una persona
     *
     * @param idperson
     * @param name
     * @param address
     * @param phone
     * @param email
     * @param password
     * @param role
     * @return
     */
    public boolean updatePerson(String idperson, String name, String address, String phone, String email, String password, int role) {
        boolean success = false;
        try {
            //Llamada a la funcion
            String sql = "{ ? = call updatePerson (?,?,?,?,?,?,?) }";
            CallableStatement cStmt = this.getConexion().prepareCall(sql);
            //establezco la salida de la funcion
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            //establezco los parámetros de entrada
            cStmt.setString(2, idperson);
            cStmt.setString(3, name);
            cStmt.setString(4, address);
            cStmt.setString(5, phone);
            cStmt.setString(6, email);
            cStmt.setString(7, password);
            cStmt.setInt(8, role);
            //se ejecuta la funcion
            cStmt.execute();

            if (cStmt.getInt(1) == 0) {
                success = true;
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return success;
    }

    /**
     * Método para eliminar una persona de la base de datos
     *
     * @param idperson
     * @return
     */
    public boolean deletePerson(String idperson) {
        boolean success = false;
        try {
            //Llamada a la funcion
            String sql = "{ ? = call deletePerson (?) }";
            CallableStatement cStmt = this.getConexion().prepareCall(sql);
            //establezco la salida de la funcion
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            //establezco los parámetros de entrada
            cStmt.setString(2, idperson);
            //se ejecuta la funcion
            cStmt.execute();
            if (cStmt.getInt(1) == 0) {
                success = true;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return success;
    }

    /**
     *
     * @param name_pt
     * @param animal_pt
     * @param gender_pt
     * @param race_pt
     * @param colour_pt
     * @param birth_pt
     * @param idper_pt
     * @return
     */
    public boolean addPet(String name_pt, String animal_pt, int gender_pt, String race_pt, String colour_pt, String birth_pt, String idper_pt) {
        boolean success = false;
        try {
            //Llamada a la funcion
            String sql = "{ ? = call addPet (?,?,?,?,?,?,?) }";
            CallableStatement cStmt = this.getConexion().prepareCall(sql);
            //establezco la salida de la funcion
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            //establezco los parámetros de entrada
            cStmt.setString(2, name_pt);
            cStmt.setString(3, animal_pt);
            cStmt.setInt(4, gender_pt);
            cStmt.setString(5, race_pt);
            cStmt.setString(6, colour_pt);
            cStmt.setString(7, birth_pt);
            cStmt.setString(8, idper_pt);
            //se ejecuta la funcion
            cStmt.execute();

            if (cStmt.getInt(1) == 0) {
                success = true;
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return success;
    }

    public boolean updatePet(int idpets, String name_pt, String animal_pt, int gender_pt, String race_pt, String colour_pt, String birth_pt, String idper_pt) {
        boolean success = false;
        try {
            //Llamada a la funcion
            String sql = "{ ? = call updatePet (?,?,?,?,?,?,?,?) }";
            CallableStatement cStmt = this.getConexion().prepareCall(sql);
            //establezco la salida de la funcion
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            //establezco los parámetros de entrada
            cStmt.setInt(2, idpets);
            cStmt.setString(3, name_pt);
            cStmt.setString(4, animal_pt);
            cStmt.setInt(5, gender_pt);
            cStmt.setString(6, race_pt);
            cStmt.setString(7, colour_pt);
            cStmt.setString(8, birth_pt);
            cStmt.setString(9, idper_pt);
            //se ejecuta la funcion
            cStmt.execute();

            if (cStmt.getInt(1) == 0) {
                success = true;
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return success;
    }

    public boolean deletePet(int idpets) {
        boolean success = false;
        try {
            //Llamada a la funcion
            String sql = "{ ? = call deletePet (?) }";
            CallableStatement cStmt = this.getConexion().prepareCall(sql);
            //establezco la salida de la funcion
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            //establezco los parámetros de entrada
            cStmt.setInt(2, idpets);
            //se ejecuta la funcion
            cStmt.execute();
            if (cStmt.getInt(1) == 0) {
                success = true;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return success;
    }

//  ---------------------------------------  CRUD DATE
    public boolean addDate(String date_d, String hour, String idperson, int type, String observations) {
        boolean success = false;
        try {
            //Llamada a la funcion
            String sql = "{ ? = call addDate (?,?,?,?,?) }";
            CallableStatement cStmt = this.getConexion().prepareCall(sql);
            //establezco la salida de la funcion
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            //establezco los parámetros de entrada
            cStmt.setString(2, date_d);
            cStmt.setString(3, hour);
            cStmt.setString(4, idperson);
            cStmt.setInt(5, type);
            cStmt.setString(6, observations);
            //se ejecuta la funcion
            cStmt.execute();

            if (cStmt.getInt(1) == 0) {
                success = true;
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return success;
    }

    public boolean updateDate(int iddate, String date_d, String hour, String idperson, int type, String observations) {
        boolean success = false;
        try {
            //Llamada a la funcion
            String sql = "{ ? = call updateDate (?,?,?,?,?,?) }";
            CallableStatement cStmt = this.getConexion().prepareCall(sql);
            //establezco la salida de la funcion
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            //establezco los parámetros de entrada
            cStmt.setInt(2, iddate);
            cStmt.setString(3, date_d);
            cStmt.setString(4, hour);
            cStmt.setString(5, idperson);
            cStmt.setInt(6, type);
            cStmt.setString(7, observations);
            //se ejecuta la funcion
            cStmt.execute();

            if (cStmt.getInt(1) == 0) {
                success = true;
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return success;
    }

    public boolean deleteDate(int iddate) {
        boolean success = false;
        try {
            //Llamada a la funcion
            String sql = "{ ? = call deleteDate (?) }";
            CallableStatement cStmt = this.getConexion().prepareCall(sql);
            //establezco la salida de la funcion
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            //establezco los parámetros de entrada
            cStmt.setInt(2, iddate);
            //se ejecuta la funcion
            cStmt.execute();
            if (cStmt.getInt(1) == 0) {
                success = true;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return success;
    }

    //  ---------------------------------------  CRUD CONSULTATION
//    public boolean addConsultation(int idpet, String date, String reason, String diagnosis, String treatment, String observation) {
//        boolean success = false;
//        try {
//            //Llamada a la funcion
//            String sql = "{ ? = call addConsultation (?,?,?,?,?,?) }";
//            CallableStatement cStmt = this.getConexion().prepareCall(sql);
//            //establezco la salida de la funcion
//            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
//            //establezco los parámetros de entrada
//            cStmt.setInt(2, idpet);
//            cStmt.setString(3, date);
//            cStmt.setString(4, reason);
//            cStmt.setString(5, diagnosis);
//            cStmt.setString(6, treatment);
//            cStmt.setString(7, observation);
//            //se ejecuta la funcion
//            cStmt.execute();
//            if (cStmt.getInt(1) == 0) {
//                success = true;
//            }
//        } catch (SQLException e) {
//            System.err.println(e.getMessage());
//        }
//        return success;
//    }
//
//    public boolean updateConsultation(int idcons, int idpet, String date, String reason, String diagnosis, String treatment, String observation) {
//        boolean success = false;
//        try {
//            //Llamada a la funcion
//            String sql = "{ ? = call updateConsultation (?,?,?,?,?,?,?) }";
//            CallableStatement cStmt = this.getConexion().prepareCall(sql);
//            //establezco la salida de la funcion
//            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
//            //establezco los parámetros de entrada
//            cStmt.setInt(2, idcons);
//            cStmt.setInt(3, idpet);
//            cStmt.setString(4, date);
//            cStmt.setString(5, reason);
//            cStmt.setString(6, diagnosis);
//            cStmt.setString(7, treatment);
//            cStmt.setString(8, observation);
//            //se ejecuta la funcion
//            cStmt.execute();
//            if (cStmt.getInt(1) == 0) {
//                success = true;
//            }
//        } catch (SQLException e) {
//            System.err.println(e.getMessage());
//        }
//        return success;
//    }
//
//    public boolean deleteConsultation(int idcons) {
//        boolean success = false;
//        try {
//            //Llamada a la funcion
//            String sql = "{ ? = call deleteConsultation (?) }";
//            CallableStatement cStmt = this.getConexion().prepareCall(sql);
//            //establezco la salida de la funcion
//            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
//            //establezco los parámetros de entrada
//            cStmt.setInt(2, idcons);
//            //se ejecuta la funcion
//            cStmt.execute();
//            if (cStmt.getInt(1) == 0) {
//                success = true;
//            }
//        } catch (SQLException e) {
//            System.err.println(e.getMessage());
//        }
//        return success;
//    }
    //  ---------------------------------------  CRUD DOCUMENTO  (NO COMPROBADO ADD NI UPDATE)

    public boolean addDoc(int idcon, String date_doc, String description, String fileattached) {
        boolean success = false;
        try {
            //Llamada a la funcion
            String sql = "{ ? = call addDoc (?,?,?,?) }";
            CallableStatement cStmt = this.getConexion().prepareCall(sql);
            //establezco la salida de la funcion
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            //establezco los parámetros de entrada
            cStmt.setInt(2, idcon);
            cStmt.setString(3, date_doc);
            cStmt.setString(4, description);
            cStmt.setString(5, fileattached);
            //se ejecuta la funcion
            cStmt.execute();
            if (cStmt.getInt(1) == 0) {
                success = true;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return success;
    }

    public boolean updateDoc(int iddoc, int idcon, String date_doc, String description, String fileattached) {
        boolean success = false;
        try {
            //Llamada a la funcion
            String sql = "{ ? = call updateDoc (?,?,?,?,?) }";
            CallableStatement cStmt = this.getConexion().prepareCall(sql);
            //establezco la salida de la funcion
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            //establezco los parámetros de entrada
            cStmt.setInt(2, iddoc);
            cStmt.setInt(3, idcon);
            cStmt.setString(4, date_doc);
            cStmt.setString(5, description);
            cStmt.setString(6, fileattached);
            //se ejecuta la funcion
            cStmt.execute();
            if (cStmt.getInt(1) == 0) {
                success = true;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return success;
    }

    public boolean deleteDoc(int iddoc) {
        boolean success = false;
        try {
            //Llamada a la funcion
            String sql = "{ ? = call deleteDoc (?) }";
            CallableStatement cStmt = this.getConexion().prepareCall(sql);
            //establezco la salida de la funcion
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            //establezco los parámetros de entrada
            cStmt.setInt(2, iddoc);
            //se ejecuta la funcion
            cStmt.execute();
            if (cStmt.getInt(1) == 0) {
                success = true;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return success;
    }
    //  ---------------------------------------  CRUD PRODUCTOS  (SIN PROBAR)

    public boolean addProducts(String name_pr, double price_pr, int taxes_pr) {
        boolean success = false;
        try {
            //Llamada a la funcion
            String sql = "{ ? = call addProducts (?,?,?) }";
            CallableStatement cStmt = this.getConexion().prepareCall(sql);
            //establezco la salida de la funcion
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            //establezco los parámetros de entrada
            cStmt.setString(2, name_pr);
            cStmt.setDouble(3, price_pr);
            cStmt.setInt(4, taxes_pr);
            //se ejecuta la funcion
            cStmt.execute();
            if (cStmt.getInt(1) == 0) {
                success = true;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return success;
    }

    public boolean updateProducts(int idproducts, String name_pr, double price_pr, int taxes_pr) {
        boolean success = false;
        try {
            //Llamada a la funcion
            String sql = "{ ? = call updateProducts (?,?,?,?) }";
            CallableStatement cStmt = this.getConexion().prepareCall(sql);
            //establezco la salida de la funcion
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            //establezco los parámetros de entrada
            cStmt.setInt(2, idproducts);
            cStmt.setString(3, name_pr);
            cStmt.setDouble(4, price_pr);
            cStmt.setInt(5, taxes_pr);
            //se ejecuta la funcion
            cStmt.execute();
            if (cStmt.getInt(1) == 0) {
                success = true;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return success;
    }

    public boolean deleteProducts(int idproducts) {
        boolean success = false;
        try {
            //Llamada a la funcion
            String sql = "{ ? = call deleteProducts (?) }";
            CallableStatement cStmt = this.getConexion().prepareCall(sql);
            //establezco la salida de la funcion
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            //establezco los parámetros de entrada
            cStmt.setInt(2, idproducts);
            //se ejecuta la funcion
            cStmt.execute();
            if (cStmt.getInt(1) == 0) {
                success = true;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return success;
    }

    //  ---------------------------------------  CRUD BILL  (SIN PROBAR)
    public boolean addBill(String idper_b, String date_b, String observations_b) {
        boolean success = false;
        try {
            //Llamada a la funcion
            String sql = "{ ? = call addBill (?,?,?) }";
            CallableStatement cStmt = this.getConexion().prepareCall(sql);
            //establezco la salida de la funcion
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            //establezco los parámetros de entrada
            cStmt.setString(2, idper_b);
            cStmt.setString(3, date_b);
            cStmt.setString(4, observations_b);
            //se ejecuta la funcion
            cStmt.execute();
            if (cStmt.getInt(1) == 0) {
                success = true;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return success;
    }

    public boolean updateBill(int idbill, String idper_b, String date_b, String observations_b) {
        boolean success = false;
        try {
            //Llamada a la funcion
            String sql = "{ ? = call updateBill (?,?,?,?) }";
            CallableStatement cStmt = this.getConexion().prepareCall(sql);
            //establezco la salida de la funcion
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            //establezco los parámetros de entrada
            cStmt.setInt(2, idbill);
            cStmt.setString(3, idper_b);
            cStmt.setString(4, date_b);
            cStmt.setString(5, observations_b);
            //se ejecuta la funcion
            cStmt.execute();
            if (cStmt.getInt(1) == 0) {
                success = true;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return success;
    }

    public boolean deleteBill(int idbill) {
        boolean success = false;
        try {
            //Llamada a la funcion
            String sql = "{ ? = call deleteBill (?) }";
            CallableStatement cStmt = this.getConexion().prepareCall(sql);
            //establezco la salida de la funcion
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            //establezco los parámetros de entrada
            cStmt.setInt(2, idbill);
            //se ejecuta la funcion
            cStmt.execute();
            if (cStmt.getInt(1) == 0) {
                success = true;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return success;
    }
    //  ---------------------------------------  CRUD BILL_LINES  (SIN PROBAR)

    public boolean addBillLines(int idbill, int idproduct, int quantity, double price, int taxes, int discount, int idpet, String observations) {
        boolean success = false;
        try {
            //Llamada a la funcion
            String sql = "{ ? = call addBillLines (?,?,?,?,?,?,?,?) }";
            CallableStatement cStmt = this.getConexion().prepareCall(sql);
            //establezco la salida de la funcion
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            //establezco los parámetros de entrada
            cStmt.setInt(2, idbill);
            cStmt.setInt(3, idproduct);
            cStmt.setInt(4, quantity);
            cStmt.setDouble(5, price);
            cStmt.setInt(6, taxes);
            cStmt.setInt(7, discount);
            cStmt.setInt(8, idpet);
            cStmt.setString(9, observations);
            //se ejecuta la funcion
            cStmt.execute();
            if (cStmt.getInt(1) == 0) {
                success = true;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return success;
    }

    public boolean updateBillLines(int idbill_lines, int idbill, int idproduct, int quantity, double price, int taxes, int discount, int idpet, String observations) {
        boolean success = false;
        try {
            //Llamada a la funcion
            String sql = "{ ? = call updateBillLines (?,?,?,?,?,?,?,?,?) }";
            CallableStatement cStmt = this.getConexion().prepareCall(sql);
            //establezco la salida de la funcion
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            //establezco los parámetros de entrada
            cStmt.setInt(2, idbill_lines);
            cStmt.setInt(3, idbill);
            cStmt.setInt(4, idproduct);
            cStmt.setInt(5, quantity);
            cStmt.setDouble(6, price);
            cStmt.setInt(7, taxes);
            cStmt.setInt(8, discount);
            cStmt.setInt(9, idpet);
            cStmt.setString(10, observations);
            //se ejecuta la funcion
            cStmt.execute();
            if (cStmt.getInt(1) == 0) {
                success = true;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return success;
    }

    public boolean deleteBillLines(int idbill_lines) {
        boolean success = false;
        try {
            //Llamada a la funcion
            String sql = "{ ? = call deleteBillLines (?) }";
            CallableStatement cStmt = this.getConexion().prepareCall(sql);
            //establezco la salida de la funcion
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            //establezco los parámetros de entrada
            cStmt.setInt(2, idbill_lines);
            //se ejecuta la funcion
            cStmt.execute();
            if (cStmt.getInt(1) == 0) {
                success = true;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return success;
    }

    //  ---------------------------------------  CRUD VACCINECAL  (SIN PROBAR)
    public boolean addVaccinecal(String name, String typeanimal, String periodicity) {
        boolean success = false;
        try {
            //Llamada a la funcion
            String sql = "{ ? = call addVaccinecal (?,?,?) }";
            CallableStatement cStmt = this.getConexion().prepareCall(sql);
            //establezco la salida de la funcion
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            //establezco los parámetros de entrada
            cStmt.setString(2, name);
            cStmt.setString(3, typeanimal);
            cStmt.setString(4, periodicity);
            //se ejecuta la funcion
            cStmt.execute();
            if (cStmt.getInt(1) == 0) {
                success = true;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return success;
    }

    public boolean updateVaccinecal(String name, String typeanimal, String periodicity) {
        boolean success = false;
        try {
            //Llamada a la funcion
            String sql = "{ ? = call updateVaccinecal (?,?,?) }";
            CallableStatement cStmt = this.getConexion().prepareCall(sql);
            //establezco la salida de la funcion
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            //establezco los parámetros de entrada
            cStmt.setString(2, name);
            cStmt.setString(3, typeanimal);
            cStmt.setString(4, periodicity);
            //se ejecuta la funcion
            cStmt.execute();
            if (cStmt.getInt(1) == 0) {
                success = true;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return success;
    }

    public boolean deleteVaccinecal(String name) {
        boolean success = false;
        try {
            //Llamada a la funcion
            String sql = "{ ? = call deleteVaccinecal (?) }";
            CallableStatement cStmt = this.getConexion().prepareCall(sql);
            //establezco la salida de la funcion
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            //establezco los parámetros de entrada
            cStmt.setString(2, name);
            //se ejecuta la funcion
            cStmt.execute();
            if (cStmt.getInt(1) == 0) {
                success = true;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return success;
    }
//  ---------------------------------------  CRUD VACINES  (SIN PROBAR)

    public boolean addVacines(int idpet, String date, String observations, String name) {
        boolean success = false;
        try {
            //Llamada a la funcion
            String sql = "{ ? = call addVacines (?,?,?,?) }";
            CallableStatement cStmt = this.getConexion().prepareCall(sql);
            //establezco la salida de la funcion
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            //establezco los parámetros de entrada
            cStmt.setInt(2, idpet);
            cStmt.setString(3, date);
            cStmt.setString(4, observations);
            cStmt.setString(5, name);
            //se ejecuta la funcion
            cStmt.execute();
            if (cStmt.getInt(1) == 0) {
                success = true;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return success;
    }

    public boolean updateVacines(int idvac, int idpet, String date, String observations, String name) {
        boolean success = false;
        try {
            //Llamada a la funcion
            String sql = "{ ? = call updateVacines (?,?,?,?,?) }";
            CallableStatement cStmt = this.getConexion().prepareCall(sql);
            //establezco la salida de la funcion
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            //establezco los parámetros de entrada
            cStmt.setInt(2, idvac);
            cStmt.setInt(3, idpet);
            cStmt.setString(4, date);
            cStmt.setString(5, observations);
            cStmt.setString(6, name);
            //se ejecuta la funcion
            cStmt.execute();
            if (cStmt.getInt(1) == 0) {
                success = true;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return success;
    }

    public boolean deleteVacines(String idvac) {
        boolean success = false;
        try {
            //Llamada a la funcion
            String sql = "{ ? = call deleteVacines (?) }";
            CallableStatement cStmt = this.getConexion().prepareCall(sql);
            //establezco la salida de la funcion
            cStmt.registerOutParameter(1, java.sql.Types.INTEGER);
            //establezco los parámetros de entrada
            cStmt.setString(2, idvac);
            //se ejecuta la funcion
            cStmt.execute();
            if (cStmt.getInt(1) == 0) {
                success = true;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return success;
    }

    /**
     * Método main para la prueba de los métodos
     *
     * A ELIMINAR
     *
     * @param args
     */
    public static void main(String[] args) {
        ModeloCrud m = new ModeloCrud();
        //System.out.println(m.deletePerson("root"));
        //System.out.println(m.addPet("miau2", "gata", 0, "angola", "verde", "2015-01-01", "01234567A"));
        //System.out.println(m.addDate("2017-02-20", "12:30", "01234567A", 0, ""));
        //System.out.println(m.updateDate(6, "2017-02-20", "12:00", "01234567A", 0, ""));
        //System.out.println(m.deleteDate(6));
        //NO FUNCIONA
        //System.out.println(m.addConsultation(2, "2017-02-02", "convulsiones", "epilepsia felina", "estaca cuadrada en la espalda", "vender estaca de 30x30"));
        //insert into consultation (idpet, date, reason, diagnosis, treatment, observation) values ('1', '2017-02-20', 'convulsiones', 'epilepsia', 'estaca cuadrada', 'vender estaca');
        //SELECT `addConsultation`('2', '2017-01-01', 'no lo se', 'no soy 100tifiko', 'pagame', 'enga')
        //System.out.println(m.updateConsultation(3, 1, "2017-01-01", "nada", "", "", ""));
        //NO FUNCIONA
        //System.out.println(m.deleteConsultation(12));
        //NO FUNCIONA ADD AND UPDATE DE DOC
        //System.out.println(m.deleteDoc(3));
    }

}
