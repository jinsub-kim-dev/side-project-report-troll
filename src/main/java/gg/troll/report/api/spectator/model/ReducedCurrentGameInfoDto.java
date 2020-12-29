package gg.troll.report.api.spectator.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReducedCurrentGameInfoDto implements Serializable {
    private static final long serialVersionUID = -2255781091041292871L;

    private int dummy;
}
