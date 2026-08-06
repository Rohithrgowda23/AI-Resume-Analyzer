package com.ai.Resume.analyser.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Structured information extracted from a free-text Job Description via Gemini.
 * Internal to the service layer - not a request/response contract by itself,
 * but its values get persisted onto PreviousTable and surfaced through ResultsDto.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JdInsights {

    private String experienceLevel;
    private List<String> skills;
    private List<String> technologies;
    private List<String> keywords;
    private List<String> responsibilities;
    private List<String> qualifications;
    private String location;
}
