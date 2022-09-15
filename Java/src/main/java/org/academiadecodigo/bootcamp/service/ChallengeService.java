package org.academiadecodigo.bootcamp.service;

import org.academiadecodigo.bootcamp.dao.ChallengeDao;
import org.academiadecodigo.bootcamp.model.Challenge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChallengeService {

    private ChallengeDao challengeDao;

    @Autowired
    public void setChallengeDao(ChallengeDao challengeDao) {
        this.challengeDao = challengeDao;
    }

    public List<Challenge> getChallengeList() {
        return challengeDao.getAll();
    }

    public Challenge getChallengeById(Integer id) {
        return challengeDao.getById(id);
    }

}
