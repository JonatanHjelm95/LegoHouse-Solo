/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import logic.LoginSampleException;

/**
 *
 * @author jonab
 */
public class DAO {

    private static final String NEW_USER = "INSERT INTO user (email, password, role) VALUES (?, ?, ?)";
    private static final String ADMIN_USER = "INSERT INTO user (email, password, role) VALUES (?, ?, ?)";
    private static final String USER_LOGIN = "SELECT * FROM user WHERE email=? AND password=?";
    private static final String GET_USER = "SELECT * FROM LegoDB.user where email =?;";
    private static final String ADD_ORDER = "INSERT INTO `Order` (Height, LenX, LenY, numberOfBricks, TotalPrice, user_id) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String GET_ORDERS = "SELECT * FROM LegoDB.`Order`";

    public static void createUser(User user) {
//        while (!user.getPassword().isEmpty() && !user.getEmail().isEmpty()) {
        try {
            Connection con = Connector.connection();
            PreparedStatement ps = con.prepareStatement(NEW_USER, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole());

            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            user.setId(id);
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
//        }
    }

    public static void createOrder(Order order, User user) throws Exception {
        try {
            Connection con = Connector.connection();
            PreparedStatement ps = con.prepareStatement(ADD_ORDER, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, order.getHeight());
            ps.setInt(2, order.getLenX());
            ps.setInt(3, order.getLenY());
            ps.setInt(4, order.getNoBricks());
            ps.setInt(5, order.getTotalPrice());
            ps.setInt(6, user.getId());

            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public static void createAdmin(User user) {
        try {
            Connection con = Connector.connection();
            PreparedStatement ps = con.prepareStatement(ADMIN_USER, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, "Employee");
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            user.setId(id);
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public static User login(String email, String password) throws LoginSampleException {
//        while (!email.isEmpty() && !password.isEmpty()) {
        try {
            Connection con = Connector.connection();
            PreparedStatement ps = con.prepareStatement(USER_LOGIN);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String em = rs.getString("email");
                String pwrd = rs.getString("password");
                String role = rs.getString("role");

                if (email.equals(em) && password.equals(pwrd)) {
                    User user = new User(email, password, role);
                    user.setId(id);
                    return user;
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
//        }
        return null;
    }

    public static User getUser(String email) throws Exception {
        try {
            Connection con = Connector.connection();
            PreparedStatement ps = con.prepareStatement(GET_USER);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String em = rs.getString("email");
                String pwrd = rs.getString("password");
                String role = rs.getString("role");
                User user = new User(em, pwrd, role);
                user.setId(id);
                return user;
            } else {
                throw new Exception("That user doesn't exist");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
