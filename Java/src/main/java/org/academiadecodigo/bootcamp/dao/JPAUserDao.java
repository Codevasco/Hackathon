package org.academiadecodigo.bootcamp.dao;

import org.academiadecodigo.bootcamp.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class JPAUserDao extends GenericDao<User> implements UserDao{

    public JPAUserDao() {
        super(User.class);
    }
}
