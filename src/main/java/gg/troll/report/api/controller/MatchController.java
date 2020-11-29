package gg.troll.report.api.controller;

import gg.troll.report.api.match.model.ReducedMatchDto;
import gg.troll.report.api.match.service.MatchService;
import gg.troll.report.base.model.CodeResponse;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/v1/match")
public class MatchController {

    @Autowired
    MatchService matchService;

    @GetMapping("/id")
    @ResponseBody
    @ApiOperation(value = "매치 아이디로 운영용 매치 세부 정보 조회.", response = ReducedMatchDto.class)
    @ApiImplicitParams({@ApiImplicitParam(name = "Riot-API-Key",  required = true, dataType = "string", paramType = "header")})
    public CodeResponse getReducedMatchById(String riotApiKey, @RequestParam long matchId) throws Exception {
        ReducedMatchDto reducedMatchDto = matchService.getReducedMatchById(riotApiKey, matchId);
        return CodeResponse.successResult(reducedMatchDto);
    }
}
