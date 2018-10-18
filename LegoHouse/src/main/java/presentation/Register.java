package presentation;

import logic.LogicFacade;
import logic.LoginSampleException;
import data.User;
import presentation.Command;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.HTMLGenerator;

public class Register extends Command {

    private HTMLGenerator gen = new HTMLGenerator();

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String email = request.getParameter("email");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        String role = "Customer";
        if (password1.equals(password2)) {
            User user = LogicFacade.createUser(email, password1, role);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            request.setAttribute("menu", gen.generateMenu(request));

//            session.setAttribute( "role", user.getRole() );
            return "index";
        } else {
            throw new LoginSampleException("the two passwords did not match");
        }
    }

}
