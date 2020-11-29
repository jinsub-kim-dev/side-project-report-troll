package gg.troll.report.api.match.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParticipantIdentityDto implements Serializable {
    private static final long serialVersionUID = 3458092813330494912L;

    private int participantId;
    private PlayerDto player;
}
