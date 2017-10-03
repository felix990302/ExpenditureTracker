/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

public class Consumer {

    private int ConsID;
    private String ConsName;
    private String ConsPassword;

    public int getConsID() {
        return ConsID;
    }

    public void setConsID(int ConsID) {
        this.ConsID = ConsID;
    }

    public String getConsName() {
        return ConsName;
    }

    public void setConsName(String ConsName) {
        this.ConsName = ConsName;
    }

    public String getConsPassword() {
        return ConsPassword;
    }

    public void setConsPassword(String ConsPassword) {
        this.ConsPassword = ConsPassword;
    }

    @Override
    public String toString() {
        return "Consumer [ConsID=" + ConsID + ", ConsName=" + ConsName + "]";
    }
}

/**
 *
 * @author chang
 */
