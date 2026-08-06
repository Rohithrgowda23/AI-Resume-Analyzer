package com.ai.Resume.analyser.dto;


import com.ai.Resume.analyser.external.Job;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultsDto {

    private int score;
    private int atsoptimizationscore;
    private String summary;
    private String experienceLevel;
    private List<String> skills;
    private List<String> missingSkills;
    private List<String> strengths;
    private List<String> weaknesses;
    private List<String> interviewTips;
    private List<String> pros;
    private List<String> cons;
    private List<String> suggestions;
    private List<Job> jobs;

    // =====================================================================
    // NEW fields, appended at the end so the existing field order/positions
    // above are completely unchanged for anything still constructing this
    // DTO the old way.
    // =====================================================================

    /** Echoes the existing Job Role field back to the frontend (was previously not returned at all). */
    private String jobRole;

    /** The raw job description the user supplied, if any. */
    private String jobDescription;

    /** Experience level extracted from the job description (distinct from the candidate's `experienceLevel` above). */
    private String jdExperienceLevel;

    private List<String> jdSkills;
    private List<String> jdTechnologies;
    private List<String> jdKeywords;
    private List<String> jdResponsibilities;
    private List<String> jdQualifications;
    private String jdLocation;

    /**
     * Null when jobs were found. When non-null, the frontend should show this
     * instead of (or alongside) an empty job list - e.g. "no jobs matched" vs
     * "the job search service is temporarily unavailable".
     */
    private String jobSearchMessage;
}
