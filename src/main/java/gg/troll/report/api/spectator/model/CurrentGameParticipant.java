package gg.troll.report.api.spectator.model;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurrentGameParticipant implements Serializable {
    private static final long serialVersionUID = 1566755033692210421L;

    private long championId;
    private Perks perks;
    private long profileIconId;
    private boolean bot;
    private long teamId;
    private String summonerName;
    private String summonerId;
    private long spell1Id;
    private long spell2Id;
    private List<GameCustomizationObject> gameCustomizationObjects;
}
