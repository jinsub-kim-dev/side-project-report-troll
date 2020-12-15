package gg.troll.report.api.home.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssessmentsRequest {
    private long fromAssessmentId;
    private int size;
}
