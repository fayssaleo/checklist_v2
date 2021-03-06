package com.checklist.TA.controller;

import com.checklist.TA.bo.Damage;
import com.checklist.TA.service.DamageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class DamageController {
    @Autowired
    private DamageService damageService;

    @PostMapping("/add")
    public Optional<Damage> add(@RequestBody Damage damage){
        //  Optional<UserDao> userCreated=userService.userSave(user);
        return damageService.damageSave(damage);

    }

    @GetMapping("/")
    public List<Damage> findAll(){
        List<Damage> damages= damageService.findAll();
        return damages;
    }

    @PostMapping("/delete/{id}")
    public Optional<Damage> DeleteId(@PathVariable("id") Damage damage){
        return damageService.DeleteId(damage);
    }

    @PutMapping("/update")
    public Optional<Damage>  UpdateDamage(@RequestBody Damage damage){
        return damageService.UpdateDamage(damage);
    }

    @GetMapping("/count")
    public Long countDamages(){
        return damageService.countDamages();
    }
}
