package gg.troll.report.api.summoner.model;

import gg.troll.report.api.league.model.ReducedLeagueEntryDTO;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LeagueSummonerDTO implements Serializable {
    private static final long serialVersionUID = -4467860473289866111L;

    private long complimentAssessments;
    private long reportAssessments;

    private String accountId;
    private String id;
    private String name;
    private int profileIconId;
    private long summonerLevel;
    private List<ReducedLeagueEntryDTO> leagueEntries;
}
