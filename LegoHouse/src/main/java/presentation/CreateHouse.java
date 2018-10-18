/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import data.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.LoginSampleException;

/**
 *
 * @author Jonatan
 */
public class CreateHouse extends Command {

    public CreateHouse() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        User user = null;
        user = (User) request.getSession(false).getAttribute("user");
        if (user != null) {
            return "createHouse";
        }
        return "loginpage";
    }

}
