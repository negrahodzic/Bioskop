/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.User;
import java.util.List;
import storage.StorageUser;
import storage.impl.database.StorageDatabaseUser;
import java.sql.ResultSet;

/**
 *
 * @author Negra
 */
public class Controller  {
    private static Controller instance;
    private StorageDatabaseUser storageDatabaseUser;

    public Controller() {
        storageDatabaseUser = new StorageDatabaseUser();
    }

    public static Controller getInstance(){
        if(instance==null){
            instance=new Controller();
        }
        return instance;
    }
    public User prijaviSe(String korisnickoIme, String korisnickaSifra) throws Exception{
        List<User> users = storageDatabaseUser.getAllUsers(); 
        for (User user : users) {
            if(user.getUsername().equalsIgnoreCase(korisnickoIme)){
                if(user.getPassword().equals(korisnickaSifra)){
                   return user;
                }else{
                    throw new Exception("Pogresna lozinka!");
                }
            }
        } throw new Exception("Korisnicko ime ne postoji!");
    }
    public StorageDatabaseUser getStorageAllUsers() {
        return storageDatabaseUser;
    }
    
}
