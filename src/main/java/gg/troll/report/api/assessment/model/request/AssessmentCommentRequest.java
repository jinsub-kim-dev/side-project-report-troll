package gg.troll.report.api.assessment.model.request;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssessmentCommentRequest implements Serializable {
    private static final long serialVersionUID = 377690574944476833L;

    private long assessmentId;
    private String comment;
    private String password;
}
