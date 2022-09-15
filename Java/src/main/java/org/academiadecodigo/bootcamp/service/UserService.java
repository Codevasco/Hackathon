package org.academiadecodigo.bootcamp.service;

import org.academiadecodigo.bootcamp.dao.UserDao;
import org.academiadecodigo.bootcamp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public User getUserById(Integer id) {
        return userDao.getById(id);
    }

    public List<User> getUserList() {
        return userDao.getAll();
    }

    @Transactional
    public User saveOrUpdate(User user) {
        return userDao.saveOrUpdate(user);
    }

    @Transactional
    public void delete(Integer id) {
        userDao.delete(id);
    }
}
