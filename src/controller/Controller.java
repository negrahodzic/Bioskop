/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.User;
import java.util.HashMap;
import java.util.Map;
import service.ServiceUser;
import service.impl.ServiceUserImpl;
import storage.impl.database.StorageDatabaseUser;

/**
 *
 * @author Negra
 */
public class Controller {

    private static Controller instance;
    private ServiceUser serviceUser;
    private Map<String, Object> map;

    public Controller() {
        serviceUser = new ServiceUserImpl();
        map = new HashMap<>();
        
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public StorageDatabaseUser getStorageAllUsers() {
//        return storageDatabaseUser;
        return new StorageDatabaseUser();
    }
    public User createUser(User user)throws Exception{
        return serviceUser.createUser(user);
    }

    public User saveUser(User user) throws Exception {
        return serviceUser.saveUser(user);
    }

    public void getAllMovies() {
        // VratiListuFilmova(List<Film>);
    }

    public void searchMovies() {
        //PronadjiFilmove(Kriterijum, List<Film>);
    }

    public void getMovie() {
        //PrikaziFilm(Film);
    }

    public void getAllMovieProjections() {
        // VratiListuProjekcija(List<Projekcija>);
    }

    public void searchMovieProjections() {
        // PronadjiProjekcije(Kriterijum, List<Projekcija>);
    }

    public void getMovieProjection() {
        //PrikaziProjekciju(Projekcija);
    }
    
    public void createReservation(){
        
    }
    
    public void saveReservation(){
                //10. signal ZapamtiRezervaciju(Rezervacija);

    }
    
    public void createReview(){
//11. signal KreirajOcenu(Ocena);

    }

    public void saveReview(){
       // 12. signal ZapamtiOcenu(Ocena);

    }
    
    public User loginUser(User user) throws Exception{ // prebaci metodu u void, ne treba da vraca User nigde
        map.put("logedUser", serviceUser.loginUser(user));
        return (User)map.get("logedUser"); 

    }
    
    public void updateUser(User user) throws Exception{
        serviceUser.updateUser(user);
        map.put("logedUser", serviceUser.loginUser(user));
    }
    
    public void logoutUser(){
        map.put("logedUser", null);
    }
    
    public void deleteUser() throws Exception{
        serviceUser.deleteUser();
    }

    public User getLoggedUser() {
        return (User) map.get("logedUser");
    }


}
