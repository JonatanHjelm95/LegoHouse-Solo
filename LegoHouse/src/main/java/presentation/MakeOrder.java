/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import data.Order;
import data.User;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.LogicFacade;
import logic.LoginSampleException;

/**
 *
 * @author Jonatan
 */
public class MakeOrder extends Command {
    
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        try {
            int[] extras = (int[]) request.getSession().getAttribute("extras");
            User user = (User) request.getSession(false).getAttribute("user");
            
            Order order = (Order) request.getSession().getAttribute("order");
            order.setNoBricks(extras[0]);
            order.setTotalPrice(extras[1]);
            order.setStatus("finished");
            LogicFacade.createOrder(order, user);
            return "index";
        } catch (Exception e) {
            request.setAttribute("error", e);
            return "errorpage";
        }
        
    }
    
}
