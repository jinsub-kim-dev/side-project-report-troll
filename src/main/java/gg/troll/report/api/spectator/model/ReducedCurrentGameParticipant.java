package gg.troll.report.api.spectator.model;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReducedCurrentGameParticipant implements Serializable {
    private static final long serialVersionUID = 2659310310249249095L;

    private String summonerId;
    private String summonerName;
    private long teamId;
    private long championId;
    private ReducedPerks perks;
    private long profileIconId;
    private boolean bot;
    private long spell1Id;
    private long spell2Id;

    public static ReducedCurrentGameParticipant of(CurrentGameParticipant currentGameParticipant) {
        return ReducedCurrentGameParticipant.builder()
                .summonerId(currentGameParticipant.getSummonerId())
                .summonerName(currentGameParticipant.getSummonerName())
                .teamId(currentGameParticipant.getTeamId())
                .championId(currentGameParticipant.getChampionId())
                .perks(ReducedPerks.of(currentGameParticipant.getPerks()))
                .profileIconId(currentGameParticipant.getProfileIconId())
                .bot(currentGameParticipant.isBot())
                .spell1Id(currentGameParticipant.getSpell1Id())
                .spell2Id(currentGameParticipant.getSpell2Id())
                .build();
    }
}
