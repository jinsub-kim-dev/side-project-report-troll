package gg.troll.report.api.match.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecentGamesStatsDto implements Serializable {
    private static final long serialVersionUID = -8472293947082089186L;

    private int totalGames;
    private int totalKills;
    private int totalDeaths;
    private int totalAssists;
    private int totalWins;
}
