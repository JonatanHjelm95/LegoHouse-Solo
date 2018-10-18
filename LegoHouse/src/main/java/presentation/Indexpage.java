/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.HTMLGenerator;
import logic.LoginSampleException;

/**
 *
 * @author Jonatan
 */
public class Indexpage extends Command {

    public Indexpage() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HTMLGenerator gen = new HTMLGenerator();
        String menu = gen.generateMenu(request);
        HttpSession session = request.getSession();
        request.setAttribute("menu", menu);

        return "index";
    }

}
