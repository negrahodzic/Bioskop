/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import database.connection.ConnectionCinema;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Negra
 */
public class Main {

    public static void main(String[] args) {
        try {
            ConnectionCinema cc = new ConnectionCinema();
            
            ConnectionCinema.getInstance();
            
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}