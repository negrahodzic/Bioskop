/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/**
 *
 * @author Negra
 */
public class ConnectionCinema {

    private Connection connection;
    public static ConnectionCinema instance;

    public ConnectionCinema() throws SQLException {
        try {
            String url = "jdbc:mysql://127.0.0.1:3306/bioskop";
            String username = "root";
            String password = "";
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);
            System.out.println("Veza sa bazom bioskopa je uspostavljena!");
        } catch (SQLException sqlex) {
            throw new SQLException("Veza sa bazom bioskopa nije uspostavljena.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Nije pronadjen drajver.");
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static ConnectionCinema getInstance() throws SQLException {
        if (instance == null) {
            instance = new ConnectionCinema();
        }
        return instance;
    }
}
