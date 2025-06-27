package com.example.EarnMoney.controller;


import com.example.EarnMoney.model.Contest;
import com.example.EarnMoney.model.User;
import com.example.EarnMoney.model.Video;
import com.example.EarnMoney.service.AdminDashboardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/dashboards")
public class AdminDashboardController {

    private final AdminDashboardService dashboardService;

    public AdminDashboardController(AdminDashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/contests")
    public List<Contest> getAllContests() {
        return dashboardService.getAllContests();
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return dashboardService.getAllUsers();
    }

    @GetMapping("/videos")
    public List<Video> getAllVideos() {
        return dashboardService.getAllVideos();
    }
}
