package com.example.UserManagementSystem.controller;


import com.example.UserManagementSystem.model.Management;
import com.example.UserManagementSystem.service.Details;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user-management-service")
public class UserController {

//    @Autowired
    private final Details details;

    public UserController(Details details) {
        this.details = details;
    }

    @PostMapping("add-users")
    public void addManagement(@RequestBody Management manages){
        details.addManagement(manages);
    }
    @GetMapping("getUsers/userId/{userId}")
    public Management findManagementUserId(@PathVariable int userId){
        return details.findByUserId(userId);
    }
     // http://localhost:8080/api/v1/user-management-service/getAllUsers
    @GetMapping("getAllUsers")
    public List<Management> findAllManages(){
        return details.findAll();
    }
    @PutMapping("update-user-info/userId/{userId}")
    public void updateManagement(@PathVariable int userId,@RequestBody Management manages){
        details.updateManagement(userId,manages);
    }
    @DeleteMapping("delete-user-info/userId/{userId}")
    public void deleteManagement(@PathVariable int userId){
        details.deleteManagemaent(userId);
    }
}
