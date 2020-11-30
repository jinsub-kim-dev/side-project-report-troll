package gg.troll.report.api.assessment.model.request;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssessmentDeleteRequest implements Serializable {
    private static final long serialVersionUID = 8076758076919720282L;

    private long assessmentId;
    private String password;
}
