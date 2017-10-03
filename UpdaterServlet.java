/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Controllers.Controller;
import Objects.Consumer;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author chang
 */
@WebServlet("/second-page")
public class UpdaterServlet extends HttpServlet {

    Controller controller = new Controller();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");

        out.println("<html>");

        String username = request.getSession(false).getAttribute("username").toString();
        String password = request.getSession(false).getAttribute("password").toString();

        out.println("<h1>" + username + "</h1>");
        out.println("<h1>" + password + "</h1>");

        Consumer consumer = controller.login(username, password);

        out.println("<h1>" + consumer.getConsID() + "</h1>");

        if (consumer == null) {
            out.println("<h1>L</h1>");
        } else {

            try {
                controller.getExpenditure(consumer);
            } catch (SQLException ex) {
                Logger.getLogger(UpdaterServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            updateExp(request, response, consumer);
        }

        out.println("<body>");

        out.println("<p><a href='/ExpenditureTracker/updateExp.jsp?username=" + username + "&password=" + password + "'>Update more</a></p>");

        out.println("<p><a href='/ExpenditureTracker/index.jsp'>Log out</a></p>");

        out.println("</body>");
        out.println("</html>");

    }

    public void updateExp(HttpServletRequest request, HttpServletResponse response, Consumer c) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h1>Using updateExp method to update your information</h1>");

        int quantity = Integer.valueOf(request.getParameter("amount"));
        String type = request.getParameter("ExpType");

        out.println("<h1>" + quantity + "</h1>");
        out.println("<h1>" + type + "</h1>");

        controller.updateExp(c, type, quantity);

        out.println("<p><a href='/ExpenditureTracker/login'>Verify</p>");

    }

}
