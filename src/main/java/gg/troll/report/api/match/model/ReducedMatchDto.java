package gg.troll.report.api.match.model;

import gg.troll.report.api.match.enums.QueueType;
import lombok.*;

import java.io.Serializable;
import java.util.Comparator;
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
    private int queueId;
    private String queueDescription;
    private List<ReducedParticipantDto> participants;

    public static ReducedMatchDto of(MatchDto matchDto) {
        ReducedMatchDto reducedMatchDto = ReducedMatchDto.builder()
                .gameId(matchDto.getGameId())
                .gameDuration(matchDto.getGameDuration())
                .queueId(matchDto.getQueueId())
                .queueDescription(QueueType.of(matchDto.getQueueId()).getDescription())
                .build();

        List<ReducedParticipantIndentityDto> participantIdentities = matchDto.getParticipantIdentities().stream()
                .map(participantIdentityDto -> {
                    return ReducedParticipantIndentityDto.builder()
                            .participantId(participantIdentityDto.getParticipantId())
                            .player(ReducedPlayerDto.of(participantIdentityDto.getPlayer()))
                            .build();
                })
                .sorted(Comparator.comparing(ReducedParticipantIndentityDto::getParticipantId))
                .collect(Collectors.toList());

        List<ReducedParticipantDto> participants = matchDto.getParticipants().stream()
                .map(ReducedParticipantDto::of)
                .sorted(Comparator.comparing(ReducedParticipantDto::getParticipantId))
                .collect(Collectors.toList());

        for (int i = 0; i < participants.size(); i++) {
            participants.get(i).setPlayer(participantIdentities.get(i).getPlayer());
        }

        reducedMatchDto.setParticipants(participants);
        return reducedMatchDto;
    }
}
