package gg.troll.report.api.spectator.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BannedChampion implements Serializable {
    private static final long serialVersionUID = 3411814155281059310L;

    private int pickTurn;
    private long championId;
    private long teamId;
}
