package AZBank;

import AZBank.model.Customer;
import AZBank.util.DBUtil;
import org.apache.log4j.Logger;

import java.sql.*;

public class CustomerManagement {

    private final static Logger logger = Logger.getLogger(CustomerManagement.class);
    public void addnewCustomer(Customer customer) throws Exception {
        try {
            System.out.println("Before getting connection");
            Connection conn = DBUtil.getConnection();
            System.out.println("After....");
            PreparedStatement pstmt = conn.prepareStatement(
                    "INSERT INTO Customer(Name, City ,Country ,Phone , Email) VALUES (?,?,?,?,?)");
            pstmt.setString(1, customer.getName());
            pstmt.setString(2, customer.getCity());
            pstmt.setString(3, customer.getCountry());
            pstmt.setString(4, customer.getPhone());
            pstmt.setString(5, customer.getEmail());
            int update = pstmt.executeUpdate();
            if (update > 0) {
                logInfo("Insert Customer success!!!");
            }
        }
        catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void updateCustomer(int id) throws Exception {
        try {

            Customer updatingCustomer = this.getCustomerByIdStored(id);
            if (updatingCustomer != null) {
                //input new data of Customer
                updatingCustomer.inputData();
                // UPDATE Customer into Database

                Connection conn = DBUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement("UPDATE Customer SET Name = ?, City = ?, Country = ?, Phone = ?, Email = ? WHERE CustomerId = ?");

                pstmt.setString(1, updatingCustomer.getName());
                pstmt.setString(2, updatingCustomer.getCity());
                pstmt.setString(3, updatingCustomer.getCountry());
                pstmt.setString(4, updatingCustomer.getPhone());
                pstmt.setString(5, updatingCustomer.getEmail());
                pstmt.setInt(6, updatingCustomer.getId());
                int updated = pstmt.executeUpdate();
                if (updated > 0 ) {
                    logInfo("Update Customer success!!!");

                }

                pstmt.close();
                conn.close();
            } else {
                logWarn("Customer not found");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());

        }
    }

    public Customer getCustomerByIdStored(int id) throws Exception {

        Customer cus = null;

        try {
            Connection conn = DBUtil.getConnection();
            CallableStatement cstmt = conn.prepareCall("{call spGetCustomer(?)}");

            cstmt.setInt(1, id);

            ResultSet rs = cstmt.executeQuery();
            if (rs.next()) {
                cus = new Customer(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)
                );
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return cus;
    }

    public void getAllCustomer() {
        try {
            Connection conn = DBUtil.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT CustomerId , Name , City , Country , Phone , Email FROM Customer");

            while (rs.next()) {
                Customer cus = new Customer(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)
                );

                System.out.println(cus.toString());
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteCustomer(int id) throws Exception {
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM Customer WHERE CustomerId = ?");
            pstmt.setInt(1, id);
            int deleted = pstmt.executeUpdate();
            if (deleted > 0) {
                logInfo("Delete Customer success!!!");
            } else {
                logWarn("Customer not found");
            }
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    private static void logInfo(String message) {
        logger.info("This is info : "+message);

    }
    private static void logWarn(String message) {
        logger.warn("This is warn : "+message);
    }

}
