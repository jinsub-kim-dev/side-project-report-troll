package gg.troll.report.api.match.model;

import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReducedMatchDto implements Serializable {
    private static final long serialVersionUID = 7436500505386796950L;

    private long gameId;
    private long gameDuration;
    private int mapId;
    private List<ReducedParticipantDto> participants;

    public static ReducedMatchDto of(MatchDto matchDto) {
        ReducedMatchDto reducedMatchDto = ReducedMatchDto.builder()
                .gameId(matchDto.getGameId())
                .gameDuration(matchDto.getGameDuration())
                .mapId(matchDto.getMapId())
                .build();

        List<ReducedParticipantDto> participants = matchDto.getParticipants().stream()
                .map(ReducedParticipantDto::of)
                .collect(Collectors.toList());

        reducedMatchDto.setParticipants(participants);
        return reducedMatchDto;
    }
}
