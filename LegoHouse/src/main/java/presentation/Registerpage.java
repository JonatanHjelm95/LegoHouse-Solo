/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.HTMLGenerator;
import logic.LoginSampleException;

/**
 *
 * @author Jonatan
 */
public class Registerpage extends Command {

    private HTMLGenerator gen = new HTMLGenerator();

    public Registerpage() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        request.setAttribute("menu", gen.generateMenu(request));

        return "registerpage";
    }

}
