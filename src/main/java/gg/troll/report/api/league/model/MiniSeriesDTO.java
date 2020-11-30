package gg.troll.report.api.league.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MiniSeriesDTO implements Serializable {
    private static final long serialVersionUID = 4084372328483105739L;

    private int wins;
    private int losses;
    private String progress;
    private int target;
}
