package presentation;

import logic.LoginSampleException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.HTMLGenerator;

abstract class Command {

    private static HashMap<String, Command> commands;
    private HTMLGenerator gen;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put("login", new Login());
        commands.put("register", new Register());
        commands.put("registerpage", new Registerpage());
        commands.put("loginpage", new Loginpage());
        commands.put("Home", new Indexpage());
        commands.put("createHouse", new CreateHouse());
        commands.put("logout", new Logout());
        commands.put("orderpage", new Orderpage());
        commands.put("orderdetails", new OrderDetails());
        commands.put("makeOrder", new MakeOrder());
        commands.put("employee", new Orderpage());
    }

    static Command from(HttpServletRequest request) {
        String commandName = request.getParameter("command");
        if (commands == null) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand());
    }

    abstract String execute(HttpServletRequest request, HttpServletResponse response)
            throws LoginSampleException;

}
