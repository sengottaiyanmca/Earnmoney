package com.example.EarnMoney.service;

import com.example.EarnMoney.model.Contest;
import com.example.EarnMoney.model.ContestVideo;
import com.example.EarnMoney.repository.ContestRepository;
import com.example.EarnMoney.repository.ContestVideoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ContestVideoService {

    private final ContestRepository contestRepository;
    private final ContestVideoRepository contestVideoRepository;

    public ContestVideoService(ContestRepository contestRepository, ContestVideoRepository contestVideoRepository) {
        this.contestRepository = contestRepository;
        this.contestVideoRepository = contestVideoRepository;
    }

    public ContestVideo addVideoToContest(Long contestId, String videoUrl, String title, String description) {
        Contest contest = contestRepository.findById(contestId)
                .orElseThrow(() -> new EntityNotFoundException("Contest not found"));

        ContestVideo contestVideo = new ContestVideo(contest, videoUrl, title, description);
        return contestVideoRepository.save(contestVideo);
    }
}
