package gg.troll.report.api.assessment.model.request;

import gg.troll.report.api.assessment.enums.AssessmentType;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssessmentCreateRequest implements Serializable {
    private static final long serialVersionUID = -6519091212811093464L;

    private long gameId;
    private String accountId;
    private AssessmentType assessmentType;
    private String comment;
    private String password;
}
