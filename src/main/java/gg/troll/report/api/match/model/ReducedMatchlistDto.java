package gg.troll.report.api.match.model;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReducedMatchlistDto implements Serializable {
    private static final long serialVersionUID = 680196275272825672L;

    private int startIndex;
    private int endIndex;
    private int totalGames;
    private List<ReducedMatchDto> matches;
}
