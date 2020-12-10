package gg.troll.report.api.match.enums;

import lombok.Getter;

@Getter
public enum QueueType {
    RIFT_SOLO_RANK(420,"RANKED_SOLO_5x5", "솔로랭크"),
    RIFT_BLIND_PICK(430, "", "일반"),
    RIFT_FLEX_RANK(440, "RANKED_FLEX_SR", "자유 5:5 랭크"),
    ARAM(450, "", "무작위 총력전"),
    AI_BOT(850, "", "Bot"),
    URF(900, "", "우르프"),
    UNKNOWN(0, "", "지원하지 않는 타입");

    int queueId;
    String queueTypeName;
    String description;

    QueueType(int queueId, String queueTypeName, String description) {
        this.queueId = queueId;
        this.queueTypeName = queueTypeName;
        this.description = description;
    }

    public static QueueType of(int queueId) {
        for (QueueType queueType : values()) {
            if (queueType.queueId == queueId) {
                return queueType;
            }
        }

        return UNKNOWN;
    }

    public static QueueType of(String queueTypeName) {
        for (QueueType queueType : values()) {
            if (queueType.getQueueTypeName().equals(queueTypeName)) {
                return queueType;
            }
        }

        return UNKNOWN;
    }
}
