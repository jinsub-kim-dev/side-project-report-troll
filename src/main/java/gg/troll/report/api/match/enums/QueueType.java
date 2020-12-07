package gg.troll.report.api.match.enums;

import lombok.Getter;

@Getter
public enum QueueType {
    RIFT_SOLO_RANK(420, "솔로랭크"),
    RIFT_FLEX_RANK(440, "자유 5:5 랭크"),
    ARAM(450, "무작위 총력전"),
    UNKNOWN(0, "지원하지 않는 타입");

    int queueId;
    String description;

    QueueType(int queueId, String description) {
        this.queueId = queueId;
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
}
