package gg.troll.report.api.match.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReducedParticipantStatsDto implements Serializable {
    private static final long serialVersionUID = -5125887124566767006L;

    private int participantId;

    private boolean win;

    private int item0;
    private int item1;
    private int item2;
    private int item3;
    private int item4;
    private int item5;
    private int item6;

    private int kills;
    private int deaths;
    private int assists;
    private int largestMultiKill;

    private int champLevel;
    private int goldEarned;
    private int totalMinionsKilled;
    private long totalDamageDealtToChampions;
    private long visionScore;

    private int perkPrimaryStyle;
    private int perkSubStyle;
    private int perk0;
    private int perk0Var1;
    private int perk0Var2;
    private int perk0Var3;
    private int perk1;
    private int perk1Var1;
    private int perk1Var2;
    private int perk1Var3;
    private int perk2;
    private int perk2Var1;
    private int perk2Var2;
    private int perk2Var3;
    private int perk3;
    private int perk3Var1;
    private int perk3Var2;
    private int perk3Var3;
    private int perk4;
    private int perk4Var1;
    private int perk4Var2;
    private int perk4Var3;
    private int perk5;
    private int perk5Var1;
    private int perk5Var2;
    private int perk5Var3;

    public static ReducedParticipantStatsDto of(ParticipantStatsDto participantStatsDto) {
        return ReducedParticipantStatsDto.builder()
                .participantId(participantStatsDto.getParticipantId())
                .win(participantStatsDto.isWin())
                .item0(participantStatsDto.getItem0())
                .item1(participantStatsDto.getItem1())
                .item2(participantStatsDto.getItem2())
                .item3(participantStatsDto.getItem3())
                .item4(participantStatsDto.getItem4())
                .item5(participantStatsDto.getItem5())
                .item6(participantStatsDto.getItem6())
                .kills(participantStatsDto.getKills())
                .deaths(participantStatsDto.getDeaths())
                .assists(participantStatsDto.getAssists())
                .largestMultiKill(participantStatsDto.getLargestMultiKill())
                .champLevel(participantStatsDto.getChampLevel())
                .goldEarned(participantStatsDto.getGoldEarned())
                .totalMinionsKilled(participantStatsDto.getTotalMinionsKilled())
                .totalDamageDealtToChampions(participantStatsDto.getTotalDamageDealtToChampions())
                .visionScore(participantStatsDto.getVisionScore())
                .perkPrimaryStyle(participantStatsDto.getPerkPrimaryStyle())
                .perkSubStyle(participantStatsDto.getPerkSubStyle())
                .perk0(participantStatsDto.getPerk0())
                .perk0Var1(participantStatsDto.getPerk0Var1())
                .perk0Var2(participantStatsDto.getPerk0Var2())
                .perk0Var3(participantStatsDto.getPerk0Var3())
                .perk1(participantStatsDto.getPerk1())
                .perk1Var1(participantStatsDto.getPerk1Var1())
                .perk1Var2(participantStatsDto.getPerk1Var2())
                .perk1Var3(participantStatsDto.getPerk1Var3())
                .perk2(participantStatsDto.getPerk2())
                .perk2Var1(participantStatsDto.getPerk2Var1())
                .perk2Var2(participantStatsDto.getPerk2Var2())
                .perk2Var3(participantStatsDto.getPerk2Var3())
                .perk3(participantStatsDto.getPerk3())
                .perk3Var1(participantStatsDto.getPerk3Var1())
                .perk3Var2(participantStatsDto.getPerk3Var2())
                .perk3Var3(participantStatsDto.getPerk3Var3())
                .perk4(participantStatsDto.getPerk4())
                .perk4Var1(participantStatsDto.getPerk4Var1())
                .perk4Var2(participantStatsDto.getPerk4Var2())
                .perk4Var3(participantStatsDto.getPerk4Var3())
                .perk5(participantStatsDto.getPerk5())
                .perk5Var1(participantStatsDto.getPerk5Var1())
                .perk5Var2(participantStatsDto.getPerk5Var2())
                .perk5Var3(participantStatsDto.getPerk5Var3())
                .build();
    }
}
