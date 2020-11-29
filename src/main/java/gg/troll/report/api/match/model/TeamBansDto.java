package gg.troll.report.api.match.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeamBansDto implements Serializable {
    private static final long serialVersionUID = 4696557354718742516L;

    private int championId;
    private int pickTurn;
}
