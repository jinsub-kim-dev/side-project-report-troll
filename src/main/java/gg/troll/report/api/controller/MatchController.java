package gg.troll.report.api.controller;

import gg.troll.report.api.match.model.ReducedMatchDto;
import gg.troll.report.api.match.model.ReducedMatchlistDto;
import gg.troll.report.api.match.service.MatchService;
import gg.troll.report.base.model.CodeResponse;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/match")
public class MatchController {

    @Autowired
    MatchService matchService;

    @CrossOrigin("*")
    @GetMapping("/id")
    @ResponseBody
    @ApiOperation(value = "매치 아이디로 운영용 매치 세부 정보 조회.", response = ReducedMatchDto.class)
    @ApiImplicitParams({@ApiImplicitParam(name = "Riot-API-Key",  required = true, dataType = "string", paramType = "header")})
    public CodeResponse getReducedMatchById(@ApiParam(hidden = true) String riotApiKey, @RequestParam long matchId) throws Exception {
        ReducedMatchDto reducedMatchDto = matchService.getReducedMatchById(riotApiKey, matchId);
        return CodeResponse.successResult(reducedMatchDto);
    }

    @CrossOrigin("*")
    @GetMapping("/list/summonerName")
    @ResponseBody
    @ApiOperation(value = "닉네임으로 매치 세부 정보 리스트 조회.", response = ReducedMatchlistDto.class)
    @ApiImplicitParams({@ApiImplicitParam(name = "Riot-API-Key",  required = true, dataType = "string", paramType = "header")})
    public CodeResponse getReducedMatchListBySummonerName(
            @ApiParam(hidden = true) String riotApiKey,
            @RequestParam String summonerName,
            @RequestParam(required = false, defaultValue = "0") int beginIndex,
            @RequestParam(required = false, defaultValue = "0") int endIndex) throws Exception {
        ReducedMatchlistDto reducedMatchlistDto = matchService.getReducedMatchListBySummonerName(riotApiKey, summonerName, beginIndex, endIndex);
        return CodeResponse.successResult(reducedMatchlistDto);
    }
}
