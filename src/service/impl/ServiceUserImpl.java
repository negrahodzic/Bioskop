/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import domain.User;
import service.ServiceUser;
import storage.StorageUser;
import storage.impl.database.StorageDatabaseUser;

/**
 *
 * @author Negra
 */
public class ServiceUserImpl implements ServiceUser {

    private final StorageUser storageUser;

    public ServiceUserImpl() {
        this.storageUser = new StorageDatabaseUser();
    }
    
    @Override
    public User createUser(User user)throws Exception{
        return storageUser.createUser(user);
    }

    @Override
    public User saveUser(User user) throws Exception {
        return storageUser.saveUser(user);
    }

    @Override
    public User loginUser(User user) throws Exception {
        return storageUser.loginUser(user);
    }

    @Override
    public User updateUser(User user) throws Exception {
        return storageUser.updateUser(user);
        
    }

    @Override
    public void deleteUser() throws Exception {
        storageUser.deleteUser();
    }

}
