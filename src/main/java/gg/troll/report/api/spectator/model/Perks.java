package gg.troll.report.api.spectator.model;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Perks implements Serializable {
    private static final long serialVersionUID = 1878393235467355797L;

    private List<Long> perkIds;
    private long perkStyle;
    private long perkSubStyle;
}
