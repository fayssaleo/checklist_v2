package com.checklist.TA.controller;

import com.checklist.TA.bo.User;
import com.checklist.TA.service.JwtUserDetailsService;
import com.checklist.TA.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @PostMapping("/add")
    public User add(@RequestBody User user){
        user.setPassword("123");
        Date currentDate = new Date();
        //   LocalDateTime myDateObj = LocalDateTime.now();

//        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        //    String formattedDate = myDateObj.format(myFormatObj);

        user.setCreatedDate(currentDate);


        System.out.println("date");
        System.out.println(currentDate);
        return userDetailsService.save(user);

    }

    @CrossOrigin
    @GetMapping("/")
    public List<User> findAll(){
        List<User> users = userService.findAll();
        return users;
    }

    @PostMapping("/delete/{id}")
    public Optional<User> DeleteId(@PathVariable("id") User user){
        return userService.DeleteId(user);
    }

    @PutMapping("/update")
    public Optional<User> UpdateUser(@RequestBody User user){
        return userService.UpdateUser(user);
    }

    @PutMapping("/passwordChange")
    public Optional<User>  changePassword(@RequestBody User user)
    {
        return userService.changePassword(user);
    }

    @GetMapping("/count")
    public Long countUsers(){
        return userService.countUsers();
    }


}
