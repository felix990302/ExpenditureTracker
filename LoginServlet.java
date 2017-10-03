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
import javax.servlet.ServletException;
import Controllers.Controller;
import Objects.Consumer;
import Objects.Spending;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author chang
 *
 *
 */
@WebServlet("/first-page")
public class LoginServlet extends HttpServlet {

    Controller controller = new Controller();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<body>");

        String identifier = request.getServletPath();

        String username;
        String password;

        if (identifier.equals("/login")) {

            username = request.getParameter("username");
            if (username == null) {
                username = request.getSession(false).getAttribute("username").toString();
            }
            password = request.getParameter("password");
            if (password == null) {
                password = request.getSession(false).getAttribute("password").toString();
            }

            try {
                login(request, response, username, password);
            } catch (ServletException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (identifier.equals("/createUser")) {

            username = request.getParameter("newUsername");
            password = request.getParameter("newPassword");

            createUser(response, username, password);

        }

        out.println("</body>");
        out.println("</html>");

    }

    public void login(HttpServletRequest request, HttpServletResponse response, String username, String password)
            throws ServletException, IOException {
        ArrayList<Spending> expenditure;

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<h1>Using login method to log in</h1>");

        Consumer consumer = controller.login(username, password);

        
        out.println();

        int total = 0;
        if (consumer != null) {
            out.println("<p>Welcome " + consumer.getConsName() + "</p>");
            
            try {
                expenditure = controller.getExpenditure(consumer);

                for (int k = expenditure.size()-1; k >-1 ; k--) {
                    Spending temp = expenditure.get(k);
                    total += temp.getAmount();

                    out.println("<p>You spent $" + temp.getAmount() + " of " + temp.getType() + " on " + temp.getDate() + "</p>");
                }

            } catch (SQLException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            out.println("<p>You spent a total of $" + total + "</p>");

            out.println("<p><a href='/ExpenditureTracker/updateExp.jsp'>Update info</a></p>");

            out.println("<p><a href='/ExpenditureTracker/index.jsp'>Log out</a></p>");

            request.getSession(true).setAttribute("username", username);
            request.getSession(true).setAttribute("password", password);

        } else {
            out.println("<p>log in failed!</p>");

            out.println("<p><a href='/ExpenditureTracker/index.jsp'>Try Again</a></p>");

        }

    }

    public void createUser(HttpServletResponse response, String username, String password) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<h1>Using createUser method to create your account</h1>");

        controller.newUser(username, password);

        out.print("<p><a href='/ExpenditureTracker/index.jsp'>Login</a></p>");

    }

}
