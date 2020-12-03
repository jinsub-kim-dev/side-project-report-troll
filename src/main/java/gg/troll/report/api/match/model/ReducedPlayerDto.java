package gg.troll.report.api.match.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReducedPlayerDto implements Serializable {
    private static final long serialVersionUID = -5928650172414186371L;

    private int profileIcon;
    private String accountId;
    private String currentAccountId;
    private String summonerName;
    private String summonerId;

    public static ReducedPlayerDto of(PlayerDto playerDto) {
        return ReducedPlayerDto.builder()
                .profileIcon(playerDto.getProfileIcon())
                .accountId(playerDto.getAccountId())
                .currentAccountId(playerDto.getCurrentAccountId())
                .summonerName(playerDto.getSummonerName())
                .summonerId(playerDto.getSummonerId())
                .build();
    }
}
