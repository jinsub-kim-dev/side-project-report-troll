package gg.troll.report.api.spectator.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReducedBannedChampion implements Serializable {
    private static final long serialVersionUID = 7740931256788240882L;

    private int pickTurn;
    private long championId;
    private long teamId;

    public static ReducedBannedChampion of(BannedChampion bannedChampion) {
        return ReducedBannedChampion.builder()
                .pickTurn(bannedChampion.getPickTurn())
                .championId(bannedChampion.getChampionId())
                .teamId(bannedChampion.getTeamId())
                .build();
    }
}
