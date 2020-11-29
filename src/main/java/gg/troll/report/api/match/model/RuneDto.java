package gg.troll.report.api.match.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RuneDto implements Serializable {
    private static final long serialVersionUID = 2308007050251442365L;

    private int runeId;
    private int rank;
}
