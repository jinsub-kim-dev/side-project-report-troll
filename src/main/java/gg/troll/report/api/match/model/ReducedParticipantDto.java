package gg.troll.report.api.match.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReducedParticipantDto implements Serializable {
    private static final long serialVersionUID = 2514415846049928642L;

    private int participantId;
    private int teamId;
    private int championId;
    private int spell1Id;
    private int spell2Id;
    private ReducedParticipantStatsDto stats;

    public static ReducedParticipantDto of(ParticipantDto participantDto) {
        return ReducedParticipantDto.builder()
                .participantId(participantDto.getParticipantId())
                .teamId(participantDto.getTeamId())
                .championId(participantDto.getChampionId())
                .spell1Id(participantDto.getSpell1Id())
                .spell2Id(participantDto.getSpell2Id())
                .stats(ReducedParticipantStatsDto.of(participantDto.getStats()))
                .build();
    }
}
