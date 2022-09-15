package org.academiadecodigo.bootcamp.service;

import org.academiadecodigo.bootcamp.dao.ChallengeDao;
import org.academiadecodigo.bootcamp.dao.UserDao;
import org.academiadecodigo.bootcamp.model.Challenge;
import org.academiadecodigo.bootcamp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

@Service
public class MultiplierService {

    private ChallengeDao challengeDao;
    private UserDao userDao;

    @Autowired
    public void setChallengeDao(ChallengeDao challengeDao) {
        this.challengeDao = challengeDao;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public ChallengeDao getChallengeDao() {
        return challengeDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void userRatingIncrement(User user) {
        user.setRating(Double.parseDouble(String.format("%.1f", user.getRating() * 1.03)));
    }

    public void userRatingDecrement(User user) {
        user.setRating(Double.parseDouble(String.format("%.1f", user.getRating() * 0.97)));
    }

    public void challengeRating(int difficultyLevel, Integer id) {

        User user = userDao.getById(id);

        if(difficultyLevel <= 2) {
            user.setRating(user.getRating() * 1.01);
        }
        if(difficultyLevel <= 4) {
            user.setRating(user.getRating() * 1.02);
        }
        if(difficultyLevel <= 6) {
            user.setRating(user.getRating() * 1.03);
        }
        if(difficultyLevel <= 8) {
            user.setRating(user.getRating() * 1.04);
        }
        if(difficultyLevel <= 10) {
            user.setRating(user.getRating() * 1.05);
        }
    }


}
