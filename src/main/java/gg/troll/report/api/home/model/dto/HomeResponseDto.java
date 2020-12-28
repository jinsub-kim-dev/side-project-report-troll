package gg.troll.report.api.home.model.dto;

import gg.troll.report.api.assessment.model.dto.AssessmentListDto;
import gg.troll.report.api.assessment.model.dto.SummonerAssessmentMetaDto;
import gg.troll.report.api.match.model.ReducedMatchlistDto;
import gg.troll.report.api.summoner.model.LeagueSummonerDTO;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HomeResponseDto implements Serializable {
    private static final long serialVersionUID = 154312209504708700L;

    SummonerAssessmentMetaDto summonerAssessmentMeta;
    AssessmentListDto assessments;
    LeagueSummonerDTO leagueSummoner;
    ReducedMatchlistDto matches;
}
