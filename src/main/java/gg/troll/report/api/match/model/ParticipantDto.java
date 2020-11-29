package gg.troll.report.api.match.model;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParticipantDto implements Serializable {
    private static final long serialVersionUID = -458763112277995551L;

    private int participantId;
    private int championId;
    private List<RuneDto> runes;
    private ParticipantStatsDto stats;
    private int teamId;
    private ParticipantTimelineDto timeline;
    private int spell1Id;
    private int spell2Id;
    private String highestAchievedSeasonTier;
    private List<MasteryDto> masteries;
}
