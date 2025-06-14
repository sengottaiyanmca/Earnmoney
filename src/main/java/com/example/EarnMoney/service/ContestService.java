package com.example.EarnMoney.service;

import com.example.EarnMoney.model.*;
import com.example.EarnMoney.repository.ContestRepository;
import com.example.EarnMoney.repository.ContestVideoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContestService {

    private final ContestRepository contestRepository;
    private final ContestVideoRepository contestVideoRepository;

    public ContestService(ContestRepository contestRepository, ContestVideoRepository contestVideoRepository) {
        this.contestRepository = contestRepository;
        this.contestVideoRepository = contestVideoRepository;
    }

    public void createContest(ContestRequest contestRequest) {
        Contest contest = new Contest();
        contest.setName(contestRequest.getName());
        contest.setDescription(contestRequest.getDescription());
        contest.setStartDate(contestRequest.getStartDate());
        contest.setEndDate(contestRequest.getEndDate());
        contestRepository.save(contest);
    }

    public List<ContestResponse> getAllContests() {
        return contestRepository.findAll().stream().map(this::mapToResponse).toList();
    }

    public ContestResponse getContestById(Long contestId) {
        Contest contest = contestRepository.findById(contestId)
                .orElseThrow(() -> new RuntimeException("Contest not found"));
        return mapToResponse(contest);
    }

    public void updateContest(Long contestId, ContestRequest contestRequest) {
        Contest contest = contestRepository.findById(contestId)
                .orElseThrow(() -> new RuntimeException("Contest not found"));

        contest.setName(contestRequest.getName());
        contest.setDescription(contestRequest.getDescription());
        contest.setStartDate(contestRequest.getStartDate());
        contest.setEndDate(contestRequest.getEndDate());
        contestRepository.save(contest);
    }

    public void deleteContest(Long contestId) {
        if (!contestRepository.existsById(contestId)) {
            throw new RuntimeException("Contest not found");
        }
        contestRepository.deleteById(contestId);
    }

    public void addVideoToContest(Long contestId, ContestVideoRequest videoRequest) {
        Contest contest = contestRepository.findById(contestId)
                .orElseThrow(() -> new RuntimeException("Contest not found"));

        ContestVideo contestVideo = new ContestVideo();
        contestVideo.setTitle(videoRequest.getVideoTitle());
        contestVideo.setVideoUrl(videoRequest.getVideoUrl());
        contestVideo.setDescription(videoRequest.getDescription());
        contestVideo.setContest(contest);

        contestVideoRepository.save(contestVideo);
    }

    private ContestResponse mapToResponse(Contest contest) {
        ContestResponse response = new ContestResponse();
        response.setId(contest.getId());
        response.setName(contest.getName());
        response.setDescription(contest.getDescription());
        response.setStartDate(contest.getStartDate());
        response.setEndDate(contest.getEndDate());
        response.setVideos(contest.getVideos().stream().map(this::mapToVideoResponse).toList());
        return response;
    }

    private ContestVideoResponse mapToVideoResponse(ContestVideo video) {
        ContestVideoResponse response = new ContestVideoResponse();
        response.setId(video.getId());
        response.setVideoTitle(video.getTitle());
        response.setVideoUrl(video.getVideoUrl());
        response.setDescription(video.getDescription());
        return response;
    }
}

