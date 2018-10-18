/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import data.Order;
import data.Stykliste;
import data.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.HTMLGenerator;
import logic.LogicFacade;
import logic.LoginSampleException;

/**
 *
 * @author Jonatan
 */
public class OrderDetails extends Command {

    private HTMLGenerator gen = new HTMLGenerator();

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        request.setAttribute("menu", gen.generateMenu(request));
        String height_str = request.getParameter("height");
        try {

            int height = Integer.parseInt(height_str);
            String lenX_str = request.getParameter("lenX");
            int lenX = Integer.parseInt(lenX_str);
            String lenY_str = request.getParameter("lenY");
            int lenY = Integer.parseInt(lenY_str);
            Stykliste house = LogicFacade.createHouse(height, lenX, lenY);
            int[] dimensions = {height, lenX, lenY};
            Order order = new Order(height, lenX, lenY);
            request.setAttribute("dimensions", dimensions);
            request.getSession().setAttribute("order", order);
            request.setAttribute("table", gen.generateStykliste(house, request));
            return "orderdetails";
        } catch (NumberFormatException e) {
            request.setAttribute("error", "NumberFormatException");
            return "errorpage";
        } catch (ArrayIndexOutOfBoundsException a) {
            request.setAttribute("error", "Length has to be a minimum of 4");
            return "errorpage";
        }

    }

}
