package gg.troll.report.api.match.model;

import lombok.*;

import java.io.Serializable;
import java.util.Map;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParticipantTimelineDto implements Serializable {
    private static final long serialVersionUID = 243506195031760423L;

    private int participantId;
    private Map<String, Double> csDiffPerMinDeltas;
    private Map<String, Double> damageTakenPerMinDeltas;
    private String role;
    private Map<String, Double> damageTakenDiffPerMinDeltas;
    private Map<String, Double> xpPerMinDeltas;
    private Map<String, Double> xpDiffPerMinDeltas;
    private String lane;
    private Map<String, Double> creepsPerMinDeltas;
    private Map<String, Double> goldPerMinDeltas;
}
