/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage.impl.database;

import controller.Controller;
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
        List<User> users = new ArrayList<>();
        try {
            Connection connection = ConnectionCinema.getInstance().getConnection();
            
            Statement statement = connection.createStatement(); 
            String query = "SELECT * FROM korisnik"; //todo: da uzima samo ulogovanog korisnika, a ne listu
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Long id = rs.getLong("korisnikID");
                String username = rs.getString("korisnickoIme");
                String password = rs.getString("sifra");
                String name = rs.getString("ime");
                String surname = rs.getString("prezime");
                String email = rs.getString("email");
                User user = new User(id, username, password,name, surname, email);
                users.add(user);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionCinema.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    @Override
    public User createUser(User user) throws Exception{
        
            Connection connection = ConnectionCinema.getInstance().getConnection();
            String query = "INSERT INTO korisnik (korisnickoIme, sifra, ime, prezime, email) VALUES (?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getName());
            ps.setString(4, user.getSurname());
            ps.setString(5, user.getEmail());
            ps.executeUpdate();
            System.out.println("Ubaceni podaci");

            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                Long id = rs.getLong(1);
                user.setId(id);
            }
            connection.commit();
                        System.out.println("ubacen id");

            System.out.println("Korisnik je uspesno sacuvan u bazi bioskopa.");
            ps.close();

        return user;
    }
    @Override
    public User saveUser(User user) throws Exception {
       return null;
    }

    @Override
    public User loginUser(User user) throws Exception {
 
            Connection connection = ConnectionCinema.getInstance().getConnection();
            
            Statement statement = connection.createStatement(); 
            String query = "SELECT * FROM korisnik WHERE korisnickoIme=? AND sifra=?"; 
            PreparedStatement ps = connection.prepareStatement(query);
            
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                user.setId(rs.getLong("korisnikID"));
                user.setUsername(rs.getString("korisnickoIme"));
                user.setPassword(rs.getString("sifra"));
                user.setName(rs.getString("ime"));
                user.setSurname(rs.getString("prezime"));
                user.setEmail(rs.getString("email"));
                
                rs.close();
                ps.close();
                return user;
            } 
            
            rs.close();
            ps.close();
            throw new Exception("Korisnik ne postoji u bazi.");

    }

    @Override
    public User updateUser(User user) throws Exception {
        try {
            Connection connection = ConnectionCinema.getInstance().getConnection();
            
            Statement statement = connection.createStatement();       
            String query = "UPDATE korisnik SET "
                    + "korisnickoIme='"+user.getUsername()
                    + "', sifra='"+user.getPassword()
                    + "', ime='"+user.getName()
                    + "', prezime='"+user.getSurname()
                    + "', email='"+user.getEmail()
                    + "' WHERE korisnikID="+user.getId();
            
            PreparedStatement ps = connection.prepareStatement(query);
            ps.executeUpdate();
            connection.commit();
            ps.close();
            System.out.println("Korisnik je uspesno sacuvan u bazi bioskopa.");

        } catch (Exception e) {
            throw new Exception("Doslo je do greske pri update metodi");
        }
        return user;

    }

    @Override
    public void deleteUser() throws Exception {
               try {
            Connection connection = ConnectionCinema.getInstance().getConnection();
            
            Statement statement = connection.createStatement();       
            String query = "DELETE FROM korisnik WHERE korisnikID="+Controller.getInstance().getLoggedUser().getId();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.executeUpdate();
            connection.commit();
            ps.close();
            System.out.println("Korisnik je uspesno izbrisan iz baze bioskopa.");

        } catch (Exception e) {
            throw new Exception("Doslo je do greske tokom brisanja korisnika.");
        }

    }
    
}
