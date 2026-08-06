package com.ai.Resume.analyser.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PreviousTable {

    @Id
    private String email;

    private int score;
    private int atsoptimizationscore;
    private String roles;

    @Column(length = 1000)
    private String summary;

    private String experienceLevel;

    @ElementCollection
    @CollectionTable(name = "previous_table_skills", joinColumns = @JoinColumn(name = "previous_table_email"))
    @Column(name = "skills", length = 450)
    private List<String> skills;

    @ElementCollection
    @CollectionTable(name = "previous_table_missing_skills", joinColumns = @JoinColumn(name = "previous_table_email"))
    @Column(name = "missing_skills", length = 450)
    private List<String> missingSkills;

    @ElementCollection
    @CollectionTable(name = "previous_table_strengths", joinColumns = @JoinColumn(name = "previous_table_email"))
    @Column(name = "strengths", length = 450)
    private List<String> strengths;

    @ElementCollection
    @CollectionTable(name = "previous_table_weaknesses", joinColumns = @JoinColumn(name = "previous_table_email"))
    @Column(name = "weaknesses", length = 450)
    private List<String> weaknesses;

    @ElementCollection
    @CollectionTable(name = "previous_table_interview_tips", joinColumns = @JoinColumn(name = "previous_table_email"))
    @Column(name = "interview_tips", length = 450)
    private List<String> interviewTips;

    @ElementCollection
    @CollectionTable(name = "previous_table_pros", joinColumns = @JoinColumn(name = "previous_table_email"))
    @Column(name = "pros", length = 450)
    private List<String> pros;

    @ElementCollection
    @CollectionTable(name = "previous_table_cons", joinColumns = @JoinColumn(name = "previous_table_email"))
    @Column(name = "cons", length = 450)
    private List<String> cons;

    @ElementCollection
    @CollectionTable(name = "previous_table_suggestions", joinColumns = @JoinColumn(name = "previous_table_email"))
    @Column(name = "suggestions", length = 450)
    private List<String> suggestions;

    // =====================================================================
    // NEW: Job Description support. These fields are purely additive -
    // "roles" (Job Role) above is completely untouched and still drives
    // the existing resume-scoring workflow on its own.
    //
    // NOTE: @OrderColumn added below on all NEW collection tables. Aiven's
    // MySQL enforces sql_require_primary_key, so every ElementCollection
    // table needs a real primary key. @OrderColumn makes Hibernate generate
    // a composite PK of (joinColumn, orderColumn) instead of a PK-less
    // table, while also preserving list order. The older fields above are
    // left as-is since their tables already exist and are working.
    // =====================================================================

    /**
     * Raw job description text as typed/pasted by the user. Optional -
     * existing flows that never send a job description simply store "".
     */
    @Column(length = 6000)
    private String jobDescription;

    /**
     * Experience level extracted from the job description (e.g. "Mid", "Senior").
     * Distinct from `experienceLevel` above, which is the CANDIDATE's level
     * inferred from their resume.
     */
    private String jdExperienceLevel;

    @ElementCollection
    @CollectionTable(name = "previous_table_jd_skills", joinColumns = @JoinColumn(name = "previous_table_email"))
    @Column(name = "jd_skill", length = 450)
    @OrderColumn(name = "jd_skill_order")
    private List<String> jdSkills;

    @ElementCollection
    @CollectionTable(name = "previous_table_jd_technologies", joinColumns = @JoinColumn(name = "previous_table_email"))
    @Column(name = "jd_technology", length = 450)
    @OrderColumn(name = "jd_technology_order")
    private List<String> jdTechnologies;

    @ElementCollection
    @CollectionTable(name = "previous_table_jd_keywords", joinColumns = @JoinColumn(name = "previous_table_email"))
    @Column(name = "jd_keyword", length = 450)
    @OrderColumn(name = "jd_keyword_order")
    private List<String> jdKeywords;

    @ElementCollection
    @CollectionTable(name = "previous_table_jd_responsibilities", joinColumns = @JoinColumn(name = "previous_table_email"))
    @Column(name = "jd_responsibility", length = 450)
    @OrderColumn(name = "jd_responsibility_order")
    private List<String> jdResponsibilities;

    @ElementCollection
    @CollectionTable(name = "previous_table_jd_qualifications", joinColumns = @JoinColumn(name = "previous_table_email"))
    @Column(name = "jd_qualification", length = 450)
    @OrderColumn(name = "jd_qualification_order")
    private List<String> jdQualifications;

    /**
     * Location extracted from the job description (e.g. "Bengaluru", "Remote"),
     * if any was mentioned. Used to optionally narrow Adzuna's `where` param.
     */
    private String jdLocation;
}