package gg.troll.report.api.spectator.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameCustomizationObject implements Serializable {
    private static final long serialVersionUID = 5808299723078184009L;

    private String category;
    private String content;
}
