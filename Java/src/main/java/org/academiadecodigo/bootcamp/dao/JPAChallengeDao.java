package org.academiadecodigo.bootcamp.dao;

import org.academiadecodigo.bootcamp.model.Challenge;
import org.springframework.stereotype.Repository;

@Repository
public class JPAChallengeDao extends GenericDao<Challenge> implements ChallengeDao{

    public JPAChallengeDao() {
        super(Challenge.class);
    }
}
