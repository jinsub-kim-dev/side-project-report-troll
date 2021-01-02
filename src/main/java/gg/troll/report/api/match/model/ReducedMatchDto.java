package gg.troll.report.api.match.model;

import gg.troll.report.api.match.enums.QueueType;
import gg.troll.report.base.exception.BaseException;
import gg.troll.report.base.exception.ErrorCode;
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
    private long gameCreation;
    private int queueId;
    private String queueDescription;
    private List<ReducedParticipantDto> participants;

    public static ReducedMatchDto of(MatchDto matchDto) {
        ReducedMatchDto reducedMatchDto = ReducedMatchDto.builder()
                .gameId(matchDto.getGameId())
                .gameDuration(matchDto.getGameDuration())
                .gameCreation(matchDto.getGameCreation())
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

    public ReducedParticipantDto getParticipantBySummonerId(String summonerId) {
        for (ReducedParticipantDto participant : this.participants) {
            if (participant.getPlayer().getSummonerId().equals(summonerId)) {
                return participant;
            }
        }
        throw new BaseException(ErrorCode.SUMMONER_NOT_PARTICIPATED_IN_MATCH, "there is no valid summoner id");
    }
}
