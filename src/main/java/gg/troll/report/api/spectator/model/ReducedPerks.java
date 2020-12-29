package gg.troll.report.api.spectator.model;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReducedPerks implements Serializable {
    private static final long serialVersionUID = 6106282634714569099L;

    private List<Long> perkIds;
    private long perkStyle;
    private long perkSubStyle;

    public static ReducedPerks of(Perks perks) {
        return ReducedPerks.builder()
                .perkIds(perks.getPerkIds())
                .perkStyle(perks.getPerkStyle())
                .perkSubStyle(perks.getPerkSubStyle())
                .build();
    }
}
