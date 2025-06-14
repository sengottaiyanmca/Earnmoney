package com.example.EarnMoney.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
public class ContestVideo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "contest_id", nullable = false)
    private Contest contest; // Links video to a specific contest.

    @Column(nullable = false, unique = true)
    private String videoUrl; // Stores the full YouTube video URL or the video ID.

    // Optional metadata
    private String title;      // Video title (optional, for UI display).
    private String description; // Video description (optional).

    public ContestVideo() {}

    public ContestVideo(Contest contest, String videoUrl, String title, String description) {
        this.contest = contest;
        this.videoUrl = videoUrl;
        this.title = title;
        this.description = description;
    }

    // Getters and setters...
}
