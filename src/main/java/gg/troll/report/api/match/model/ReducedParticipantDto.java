package gg.troll.report.api.match.model;

import gg.troll.report.api.match.enums.Champion;
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
    private String championNameEn;
    private String championNameKr;
    private int spell1Id;
    private int spell2Id;
    private ReducedPlayerDto player;
    private ReducedParticipantStatsDto stats;

    public static ReducedParticipantDto of(ParticipantDto participantDto) {
        return ReducedParticipantDto.builder()
                .participantId(participantDto.getParticipantId())
                .teamId(participantDto.getTeamId())
                .championId(participantDto.getChampionId())
                .championNameEn(Champion.of(participantDto.getChampionId()).getChampionNameEn())
                .championNameKr(Champion.of(participantDto.getChampionId()).getChampionNameKr())
                .spell1Id(participantDto.getSpell1Id())
                .spell2Id(participantDto.getSpell2Id())
                .stats(ReducedParticipantStatsDto.of(participantDto.getStats()))
                .build();
    }
}
