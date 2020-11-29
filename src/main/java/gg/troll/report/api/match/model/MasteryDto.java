package gg.troll.report.api.match.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MasteryDto implements Serializable {
    private static final long serialVersionUID = 2126162973660610319L;

    private int masteryId;
    private int rank;
}
