/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.DAO;
import data.Order;
import data.Stykliste;
import data.User;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jonatan
 */
public class LogicFacade {

    public LogicFacade() {

    }

    public static User login(String email, String password) throws LoginSampleException {
        return DAO.login(email, password);
    }

    public static User getUser(String email) throws Exception {
        return DAO.getUser(email);
    }

    public static User createUser(String email, String password, String role) throws LoginSampleException {
        User user = new User(email, password, role);
        DAO.createUser(user);
        return user;
    }

    public boolean correctPassword(User user) throws Exception {
        User user1 = DAO.getUser(user.getEmail());
        return user1.getPassword().equals(user.getPassword());
    }

    public static Stykliste createHouse(int height, int lenX, int lenY) throws ArrayIndexOutOfBoundsException {
        LegoLogic ll = new LegoLogic();
        if (lenX >= 3 && lenY >= 3) {
            return ll.createHouse(height, lenX, lenY);
        }
        return null;
    }
    
    public static void createOrder(Order order, User user) throws Exception{
        DAO.createOrder(order, user);
    }
    
}
