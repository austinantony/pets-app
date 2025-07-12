package com.pets.ejb;

import jakarta.ejb.Remote;

@Remote
public interface UserService {

    boolean login(String username, String password);
}
