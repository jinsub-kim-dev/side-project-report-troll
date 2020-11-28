package gg.troll.report.api.match.model;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatchlistDto implements Serializable {
    private static final long serialVersionUID = -508069275757081801L;

    private int startIndex;
    private int endIndex;
    private int totalGames;
    private List<MatchReferenceDto> matches;
}
