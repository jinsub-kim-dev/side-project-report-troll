package gg.troll.report.api.home.service;

import gg.troll.report.api.assessment.model.dto.AssessmentListDto;
import gg.troll.report.api.assessment.model.dto.SummonerAssessmentMetaDto;
import gg.troll.report.api.assessment.service.AssessmentService;
import gg.troll.report.api.home.model.AssessmentsRequest;
import gg.troll.report.api.home.model.MatchesRequest;
import gg.troll.report.api.home.model.dto.HomeResponseDto;
import gg.troll.report.api.match.model.ReducedMatchlistDto;
import gg.troll.report.api.match.service.MatchService;
import gg.troll.report.api.summoner.model.LeagueSummonerDTO;
import gg.troll.report.api.summoner.model.SummonerDTO;
import gg.troll.report.api.summoner.service.SummonerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService {
    @Autowired
    SummonerService summonerService;
    @Autowired
    MatchService matchService;
    @Autowired
    AssessmentService assessmentService;

    public HomeResponseDto getHomeResponseDto(String summonerName, AssessmentsRequest assessmentsRequest, MatchesRequest matchesRequest) throws Exception {
        SummonerDTO summonerDTO = summonerService.getSummonerByName(summonerName);
        SummonerAssessmentMetaDto summonerAssessmentMetaDto = assessmentService.getSummonerAssessmentMetaDto(summonerDTO.getAccountId());
        AssessmentListDto assessmentListDto = assessmentService.getAssessmentListDtoByAccountId(summonerDTO.getAccountId(), assessmentsRequest.getFromAssessmentId(), assessmentsRequest.getSize());
        LeagueSummonerDTO leagueSummonerDTO = summonerService.getLeagueSummonerBySummonerDto(summonerDTO);
        ReducedMatchlistDto reducedMatchlistDto = matchService.getReducedMatchListBySummonerDto(summonerDTO, matchesRequest.getBeginIndex(), matchesRequest.getEndIndex());

        return HomeResponseDto.builder()
                .summonerAssessmentMeta(summonerAssessmentMetaDto)
                .assessments(assessmentListDto)
                .leagueSummoner(leagueSummonerDTO)
                .matches(reducedMatchlistDto)
                .build();
    }
}
