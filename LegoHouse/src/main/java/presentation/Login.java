package presentation;

import logic.LogicFacade;
import logic.LoginSampleException;
import data.User;
import java.util.logging.Level;
import java.util.logging.Logger;
import presentation.Command;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.HTMLGenerator;

/**
 * The purpose of Login is to...
 *
 * @author kasper
 */
public class Login extends Command {
        private HTMLGenerator gen = new HTMLGenerator();


    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user;
        try {
            user = LogicFacade.getUser(email);
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                User user1 = LogicFacade.login(user.getEmail(), user.getPassword());
                HttpSession session = request.getSession(true);
                session.setAttribute("user", user1);
                session.setAttribute("role", user1.getRole());
                request.setAttribute("menu", gen.generateMenu(request));
//                System.out.println("succesfully logged in as :" +user1.getEmail());

            }
        } catch (Exception ex) {
            request.setAttribute("error", "Wrong username/password");
            ex.printStackTrace();
        }
////        User user = LogicFacade.login( email, password );
//        HttpSession session = request.getSession();
//        session.setAttribute("user", user);
//        session.setAttribute("role", user.getRole());
        return "index";
    }

}
