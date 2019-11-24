/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage.impl.database;

import database.connection.ConnectionCinema;
import domain.User;
import java.sql.Connection;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import storage.StorageUser;

/**
 *
 * @author Negra
 */
public class StorageDatabaseUser implements StorageUser {

    public List<User> getAllUsers() throws SQLException {
        Connection connection = ConnectionCinema.getInstance().getConnection();
        ResultSet rs = null;
        User user = new User();
        List<User> users = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM korisnik";
            rs = statement.executeQuery(query);
            
            while (rs.next()) {
                user.setId(rs.getLong("korisnikID"));
                user.setUsername(rs.getString("korisnickoIme"));
                user.setPassword(rs.getString("sifra"));
                user.setName(rs.getString("ime"));
                user.setSurname(rs.getString("prezime"));
                user.setEmail(rs.getString("email"));
                users.add(user);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionCinema.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    @Override
    public String save(String username, String password, String name, String surname, String email) throws Exception {
        try {
            Connection connection = ConnectionCinema.getInstance().getConnection();
            String query = "INSERT INTO korisnik (korisnickoIme, sifra, ime, prezime, email) VALUES (?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, name);
            ps.setString(4, surname);
            ps.setString(5, email);
            ps.executeUpdate();
            System.out.println("Korisnik je ubacen u bazu!");
            ps.close();
            return "Korisnik je uspesno sacuvan u bazi bioskopa.";
        } catch (SQLException ex) {
            return "Korisnik nije sacuvan. Doslo je do greske.";
        }
    }
}
