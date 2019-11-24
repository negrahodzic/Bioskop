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
    public String save(User user) throws Exception {
        return storageUser.save(user.getUsername(), user.getPassword(), user.getName(), user.getSurname(), user.getEmail());
    }

}
