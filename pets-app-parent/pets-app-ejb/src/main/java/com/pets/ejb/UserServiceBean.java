package com.pets.ejb;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class UserServiceBean implements UserService{
    @PersistenceContext
    private EntityManager em;


    public boolean login(String username, String password) {
        Long count = em.createQuery("SELECT COUNT(u) FROM User u WHERE u.username = :u AND u.password = :p", Long.class)
                .setParameter("u", username).setParameter("p", password).getSingleResult();
        return count > 0;
    }
}