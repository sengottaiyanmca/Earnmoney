package com.example.EarnMoney.controller;

import com.example.EarnMoney.model.User;
import com.example.EarnMoney.service.AdminService;
import com.example.EarnMoney.service.ContestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@Api(tags = "Admin Management Controller")
public class AdminController {


    private final AdminService adminService;

    public  AdminController(AdminService adminService){
        this.adminService = adminService;
    }

    @ApiOperation("Create a Dashboard")
    @GetMapping("/dashboard")
    public String adminDashboard() {
        return "Welcome to Admin Dashboard";
    }

    @ApiOperation("Create a new users")
    @PostMapping("/users")
    public ResponseEntity<String> createUser(@RequestBody User userRequest) {
        adminService.createUser(userRequest);
        return ResponseEntity.ok("User created successfully");
    }

    @ApiOperation("Update a users")
    @PutMapping("/users/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody User userRequest) {
        adminService.updateUser(id,userRequest);
        return ResponseEntity.ok("User updated successfully");
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        adminService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}

