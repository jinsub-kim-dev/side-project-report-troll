package gg.troll.report.api.assessment.model.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssessmentListDto implements Serializable {
    private static final long serialVersionUID = -5789798808504904343L;

    private List<AssessmentDto> assessments;
    private long lastAssessmentId;
    private boolean allowMore;
}
