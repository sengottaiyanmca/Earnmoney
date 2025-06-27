package com.example.EarnMoney.service;


import com.example.EarnMoney.model.Contest;
import com.example.EarnMoney.model.User;
import com.example.EarnMoney.model.Video;
import com.example.EarnMoney.repository.ContestRepository;
import com.example.EarnMoney.repository.UserRepository;
import com.example.EarnMoney.repository.VideoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminDashboardService {

    private final ContestRepository contestRepository;
    private final UserRepository userRepository;
    private final VideoRepository videoRepository;

    public AdminDashboardService(ContestRepository contestRepository, UserRepository userRepository, VideoRepository videoRepository) {
        this.contestRepository = contestRepository;
        this.userRepository = userRepository;
        this.videoRepository = videoRepository;
    }

    public List<Contest> getAllContests() {
        return contestRepository.findAll();
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }
}
