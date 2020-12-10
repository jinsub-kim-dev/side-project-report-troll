package gg.troll.report.api.league.model;

import gg.troll.report.api.match.enums.QueueType;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReducedLeagueEntryDTO implements Serializable {
    private static final long serialVersionUID = 2595943090079081622L;

    private String leagueId;
    private String summonerId;
    private String summonerName;
    private String queueDescription;
    private String tier;
    private String rank;
    private int leaguePoints;
    private int wins;
    private int losses;

    public static ReducedLeagueEntryDTO of(LeagueEntryDTO leagueEntryDTO) {
        return ReducedLeagueEntryDTO.builder()
                .leagueId(leagueEntryDTO.getLeagueId())
                .summonerId(leagueEntryDTO.getSummonerId())
                .summonerName(leagueEntryDTO.getSummonerName())
                .queueDescription(QueueType.of(leagueEntryDTO.getQueueType()).getDescription())
                .tier(leagueEntryDTO.getTier())
                .rank(leagueEntryDTO.getRank())
                .leaguePoints(leagueEntryDTO.getLeaguePoints())
                .wins(leagueEntryDTO.getWins())
                .losses(leagueEntryDTO.getLosses())
                .build();
    }
}
