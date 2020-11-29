package gg.troll.report.api.assessment.model.dto;

import gg.troll.report.api.assessment.enums.AssessmentType;
import gg.troll.report.api.assessment.model.entity.Assessment;
import lombok.*;

import java.io.Serializable;
import java.time.ZoneOffset;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssessmentDto implements Serializable {
    private static final long serialVersionUID = 6784861945077896181L;

    private long assessmentId;
    private long gameId;
    private String accountId;
    private AssessmentType assessmentType;
    private String comment;
    private long createdAtEpochSecond;

    public static AssessmentDto of(Assessment assessment) {
        return AssessmentDto.builder()
                .assessmentId(assessment.getAssessmentId())
                .gameId(assessment.getGameId())
                .accountId(assessment.getAccountId())
                .assessmentType(assessment.getAssessmentType())
                .comment(assessment.getComment())
                .createdAtEpochSecond(assessment.getCreatedAt().toEpochSecond(ZoneOffset.of("+09:00")))
                .build();
    }
}
