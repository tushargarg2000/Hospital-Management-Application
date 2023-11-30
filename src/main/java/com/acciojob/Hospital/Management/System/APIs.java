package com.acciojob.Hospital.Management.System;

import com.acciojob.Hospital.Management.System.Models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class APIs {

    Map<Integer,User> userDb = new HashMap<>();

    @GetMapping("/IntroToMathsWorld")
    public String introPage(){

        return "Hi Welcome to the Maths world;";
    }

    @GetMapping("/addTwoNo")
    public String addNo(@RequestParam("no1")int no1,@RequestParam("no2")Integer no2){

        int result = no1+no2;
        return "The sum of numbers is "+result;
    }


    @PostMapping("/addUserViaReqBody")
    public String addUser(@RequestBody User user){

        System.out.println("User Object entered is "+user);

        System.out.println(user.toString());

        int key = user.getUserId();


        userDb.put(key,user);
        return "Adding user to the database";
    }

    @GetMapping("/getInfo")
    public User getUserInfo(@RequestParam("userId")Integer userId){

        User user = userDb.get(userId);

        return user;
    }

    @GetMapping("/getInfo/{userId}")
    public User getUserInfoViaPath(@PathVariable("userId")Integer userId){

        User user = userDb.get(userId);
        return user;
    }








    @PostMapping("/addUser")
    public String addUser(@RequestParam("userId")Integer userId,
                          @RequestParam("name")String name,
                          @RequestParam("age")Integer age){

        User user = new User(userId,name,age);
        userDb.put(userId,user);
        return "User with UserId "+userId+" has been saved to dB";
    }

    @GetMapping("/getUser")
    public String getUser(@RequestParam("userId")Integer userId) {

        User user = userDb.get(userId);
        return user.getName();
    }



}
