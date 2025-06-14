package com.example.EarnMoney.controller;

import com.example.EarnMoney.model.ContestRequest;
import com.example.EarnMoney.model.ContestResponse;
import com.example.EarnMoney.model.ContestVideoRequest;
import com.example.EarnMoney.service.ContestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/contests")
public class ContestController {

    private final ContestService contestService;

    public ContestController(ContestService contestService) {
        this.contestService = contestService;
    }

    @PostMapping
    public ResponseEntity<String> createContest(@RequestBody ContestRequest contestRequest) {
        contestService.createContest(contestRequest);
        return ResponseEntity.ok("Contest created successfully");
    }

    @GetMapping
    public ResponseEntity<List<ContestResponse>> getAllContests() {
        return ResponseEntity.ok(contestService.getAllContests());
    }

    @GetMapping("/{contestId}")
    public ResponseEntity<ContestResponse> getContestById(@PathVariable Long contestId) {
        return ResponseEntity.ok(contestService.getContestById(contestId));
    }

    @PutMapping("/{contestId}")
    public ResponseEntity<String> updateContest(
            @PathVariable Long contestId,
            @RequestBody ContestRequest contestRequest) {
        contestService.updateContest(contestId, contestRequest);
        return ResponseEntity.ok("Contest updated successfully");
    }

    @DeleteMapping("/{contestId}")
    public ResponseEntity<String> deleteContest(@PathVariable Long contestId) {
        contestService.deleteContest(contestId);
        return ResponseEntity.ok("Contest deleted successfully");
    }

    @PostMapping("/{contestId}/videos")
    public ResponseEntity<String> addVideoToContest(
            @PathVariable Long contestId,
            @RequestBody ContestVideoRequest videoRequest) {
        contestService.addVideoToContest(contestId, videoRequest);
        return ResponseEntity.ok("Video added successfully to the contest");
    }
}

