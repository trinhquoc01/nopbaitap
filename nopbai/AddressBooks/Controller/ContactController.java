package AddressBooks.Controller;

import AddressBooks.Contact;
import AddressBooks.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContactController {
    public static boolean addContact(Contact contact) {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean isSuccessful = false;

        try {
            conn = DBUtil.getConnection();
            stmt = conn.prepareStatement("INSERT INTO Contact(Name, Company, Email, Phone) VALUES(?, ?, ?, ?)");
            stmt.setString(1, contact.getName());
            stmt.setString(2, contact.getCompany());
            stmt.setString(3, contact.getEmail());
            stmt.setString(4, contact.getPhoneNumber());

            if (stmt.executeUpdate() > 0) {
                isSuccessful = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return isSuccessful;
    }

    public static List<Contact> getContact() {
        Connection conn = null;
        Statement stmt = null;
        List<Contact> contactList = new ArrayList<>();

        try {
            conn = DBUtil.getConnection();
            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM Contact");
            while (rs.next()) {
                String name = rs.getString(2);
                String company = rs.getString(3);
                String email = rs.getString(4);
                String phoneNumber = rs.getString(5);
                Contact contact = new Contact(name, company, email, phoneNumber);
                contactList.add(contact);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return contactList;
    }
}
