package gg.troll.report.api.assessment.model.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SummonerAssessmentMetaDto implements Serializable {
    private static final long serialVersionUID = -2258625573933501794L;

    private long totalComplimentAssessments;
    private long totalReportAssessments;
}
