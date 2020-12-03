package gg.troll.report.api.match.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReducedParticipantIndentityDto implements Serializable {
    private static final long serialVersionUID = -253287215687741231L;

    private int participantId;
    private ReducedPlayerDto player;
}
