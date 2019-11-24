/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

/**
 *
 * @author Negra
 */
public interface StorageUser {
    String save(String username, String password, String name, String surname, String email) throws Exception;
}
