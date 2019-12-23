/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import domain.User;

/**
 *
 * @author Negra
 */
public interface StorageUser {
    User saveUser(User user) throws Exception;
    User createUser(User user) throws Exception;
    User loginUser(User user) throws Exception;
    User updateUser(User user) throws Exception;
    void deleteUser() throws Exception;

}
