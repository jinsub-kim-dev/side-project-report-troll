package gg.troll.report.api.summoner.model;

import gg.troll.report.api.league.model.ReducedLeagueEntryDTO;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LeagueSummonerDTO implements Serializable {
    private static final long serialVersionUID = -4467860473289866111L;

    private String accountId;
    private String id;
    private String name;
    private long summonerLevel;
    private ReducedLeagueEntryDTO leagueEntry;
}
