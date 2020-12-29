package gg.troll.report.api.spectator.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Observer implements Serializable {
    private static final long serialVersionUID = -7967692582346420251L;

    private String encryptionKey;
}
