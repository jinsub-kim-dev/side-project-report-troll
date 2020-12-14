package gg.troll.report.api.controller;

import gg.troll.report.api.home.model.AssessmentsRequest;
import gg.troll.report.api.home.model.MatchesRequest;
import gg.troll.report.api.home.model.dto.HomeResponseDto;
import gg.troll.report.api.home.service.HomeService;
import gg.troll.report.base.model.CodeResponse;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/home")
public class HomeController {
    @Autowired
    HomeService homeService;

    @CrossOrigin("*")
    @GetMapping("")
    @ResponseBody
    @ApiImplicitParams({@ApiImplicitParam(name = "Riot-API-Key",  required = true, dataType = "string", paramType = "header")})
    public CodeResponse getHomeResponse(
            @ApiParam(hidden = true) String riotApiKey,
            @RequestParam String summonerName,
            @RequestParam(defaultValue = "0") long fromAssessmentId,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false, defaultValue = "0") int beginIndex,
            @RequestParam(required = false, defaultValue = "5") int endIndex) throws Exception {
        AssessmentsRequest assessmentsRequest = AssessmentsRequest.builder().fromAssessmentId(fromAssessmentId).size(size).build();
        MatchesRequest matchesRequest = MatchesRequest.builder().beginIndex(beginIndex).endIndex(endIndex).build();
        HomeResponseDto homeResponseDto = homeService.getHomeResponseDto(riotApiKey, summonerName, assessmentsRequest, matchesRequest);
        return CodeResponse.successResult(homeResponseDto);
    }
}
