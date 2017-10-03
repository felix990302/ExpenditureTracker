/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Model;
import Objects.Consumer;
import Objects.Spending;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author chang
 */
public class Controller {

    public Consumer login(String username, String password) {
        Consumer temp = Model.getConsumer(username, password);

        return temp;

    }

    public void updateExp(Consumer c, String type, int amount) {
        Model.updateExp(c, type, amount);
    }

    public void newUser(String username, String password) {
        Model.newConsumer(username, password);
    }

    public ArrayList<Spending> getExpenditure(Consumer c) throws SQLException {
        return Model.getExpenditure(c);
    }

}
