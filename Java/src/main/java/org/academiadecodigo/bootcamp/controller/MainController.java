package org.academiadecodigo.bootcamp.controller;

import org.academiadecodigo.bootcamp.model.Challenge;
import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.service.ChallengeService;
import org.academiadecodigo.bootcamp.service.MultiplierService;
import org.academiadecodigo.bootcamp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/kingofthehill")
public class MainController {

    private UserService userService;
    private ChallengeService challengeService;

    private MultiplierService multiplierService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setChallengeService(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @Autowired
    public void setMultiplierService(MultiplierService multiplierService) {
        this.multiplierService = multiplierService;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/users/list"})
    public ResponseEntity<List<User>> listUsers() {
        return new ResponseEntity<>(userService.getUserList(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/challenges/list"})
    public ResponseEntity<List<Challenge>> listChallenges() {
        return new ResponseEntity<>(challengeService.getChallengeList(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, path = {"/user/add"})
    public ResponseEntity<User> addUser (@Valid @RequestBody User user) {
        userService.saveOrUpdate(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/challenges/{id}"})
    public ResponseEntity<Challenge> getChallenge(@PathVariable Integer id) {
        return new ResponseEntity<>(challengeService.getChallengeById(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/user/{id}"})
    public ResponseEntity<User> getUser(@PathVariable Integer id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/user/{id}/increment")
    public ResponseEntity<User> incrementRating(@PathVariable Integer id) {

        if (userService.getUserById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        User user = userService.getUserById(id);
        multiplierService.userRatingIncrement(user);
        userService.saveOrUpdate(user);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/user/{id}/decrement")
    public ResponseEntity<User> decrementRating(@PathVariable Integer id) {


        if (userService.getUserById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        User user = userService.getUserById(id);
        multiplierService.userRatingDecrement(user);
        userService.saveOrUpdate(user);

        return new ResponseEntity<>(HttpStatus.OK);
    }











}
