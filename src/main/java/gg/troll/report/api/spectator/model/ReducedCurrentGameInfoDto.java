package gg.troll.report.api.spectator.model;

import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReducedCurrentGameInfoDto implements Serializable {
    private static final long serialVersionUID = -2255781091041292871L;

    private long gameId;
    private String gameType;
    private long gameStartTime;
    private long mapId;
    private long gameLength;
    private String platformId;
    private String gameMode;
    private List<ReducedBannedChampion> bannedChampions;
    private List<ReducedCurrentGameParticipant> participants;

    public static ReducedCurrentGameInfoDto of(CurrentGameInfoDto currentGameInfoDto) {
        List<ReducedBannedChampion> reducedBannedChampions = currentGameInfoDto.getBannedChampions().stream()
                .map(ReducedBannedChampion::of)
                .collect(Collectors.toList());

        List<ReducedCurrentGameParticipant> reducedCurrentGameParticipants = currentGameInfoDto.getParticipants().stream()
                .map(ReducedCurrentGameParticipant::of)
                .collect(Collectors.toList());

        return ReducedCurrentGameInfoDto.builder()
                .gameId(currentGameInfoDto.getGameId())
                .gameType(currentGameInfoDto.getGameType())
                .gameStartTime(currentGameInfoDto.getGameStartTime())
                .mapId(currentGameInfoDto.getMapId())
                .gameLength(currentGameInfoDto.getGameLength())
                .platformId(currentGameInfoDto.getPlatformId())
                .gameMode(currentGameInfoDto.getGameMode())
                .bannedChampions(reducedBannedChampions)
                .participants(reducedCurrentGameParticipants)
                .build();
    }
}
