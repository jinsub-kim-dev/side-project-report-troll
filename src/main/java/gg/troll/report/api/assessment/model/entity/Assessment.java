package gg.troll.report.api.assessment.model.entity;

import gg.troll.report.api.assessment.enums.AssessmentType;
import gg.troll.report.base.converter.BooleanToYNConverter;
import gg.troll.report.base.model.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_assessment")
public class Assessment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long assessmentId;

    @Column
    private long gameId;

    @Column
    private String accountId;

    @Column
    @Enumerated(EnumType.ORDINAL)
    AssessmentType assessmentType;

    @Column
    private String comment;

    @Column
    private String hashedPassword;

    @Column
    @Convert(converter = BooleanToYNConverter.class)
    private boolean deleted;
}
