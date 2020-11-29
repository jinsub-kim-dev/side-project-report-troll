package gg.troll.report.api.match.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParticipantStatsDto implements Serializable {
    private static final long serialVersionUID = 8120867355030095249L;

    private int participantId;

    private int item0;
    private int item1;
    private int item2;
    private int item3;
    private int item4;
    private int item5;
    private int item6;

    private int kills;
    private int doubleKills;
    private int tripleKills;
    private int quadraKills;
    private int pentaKills;
    private int largestMultiKill;
    private int deaths;
    private int assists;

    private int champLevel;
    private int goldEarned;
    private int goldSpent;

    private int totalMinionsKilled;
    private int inhibitorKills;
    private int turretKills;
    private int wardsKilled;
    private int wardsPlaced;

    private long totalDamageDealt;
    private long totalDamageDealtToChampions;
    private long trueDamageDealt;
    private long trueDamageDealtToChampions;
    private long physicalDamageDealt;
    private long physicalDamageDealtToChampions;
    private long magicDamageDealt;
    private long magicDamageDealtToChampions;
    private long damageDealtToObjectives;
    private long damageDealtToTurrets;
    private long timeCCingOthers;
    private long visionScore;

    private long totalHeal;
    private int totalUnitsHealed;

    private long totalDamageTaken;
    private long trueDamageTaken;
    private long physicalDamageTaken;
    private long magicalDamageTaken;

    private boolean win;
    private boolean firstBloodKill;
    private boolean firstBloodAssist;
    private boolean firstTowerKill;
    private boolean firstTowerAssist;
    private boolean firstInhibitorKill;
    private boolean firstInhibitorAssist;

    private int nodeCapture;
    private int nodeCaptureAssist;
    private int nodeNeutralize;
    private int neutralMinionsKilled;
    private int nodeNeutralizeAssist;
    private int neutralMinionsKilledTeamJungle;
    private long damageSelfMitigated;
    private int largestCriticalStrike;
    private int totalTimeCrowdControlDealt;
    private int largestKillingSpree;
    private int visionWardsBoughtInGame;
    private int totalScoreRank;
    private int totalPlayerScore;
    private int objectivePlayerScore;
    private int combatPlayerScore;
    private int teamObjective;
    private int altarsNeutralized;
    private int altarsCaptured;
    private int unrealKills;
    private int longestTimeSpentLiving;
    private int killingSprees;
    private int sightWardsBoughtInGame;
    private int neutralMinionsKilledEnemyJungle;

    private int playerScore0;
    private int playerScore1;
    private int playerScore2;
    private int playerScore3;
    private int playerScore4;
    private int playerScore5;
    private int playerScore6;
    private int playerScore7;
    private int playerScore8;
    private int playerScore9;
    private int perk0;
    private int perk0Var1;
    private int perk0Var2;
    private int perk0Var3;
    private int perk1;
    private int perk1Var1;
    private int perk1Var2;
    private int perk1Var3;
    private int perk2;
    private int perk2Var1;
    private int perk2Var2;
    private int perk2Var3;
    private int perk3;
    private int perk3Var1;
    private int perk3Var2;
    private int perk3Var3;
    private int perk4;
    private int perk4Var1;
    private int perk4Var2;
    private int perk4Var3;
    private int perk5;
    private int perk5Var1;
    private int perk5Var2;
    private int perk5Var3;
    private int perkPrimaryStyle;
    private int perkSubStyle;
    private int statPerk0;
    private int statPerk1;
    private int statPerk2;
}
