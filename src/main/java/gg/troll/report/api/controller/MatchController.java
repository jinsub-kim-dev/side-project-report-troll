package gg.troll.report.api.controller;

import gg.troll.report.api.match.model.MatchDto;
import gg.troll.report.api.match.model.MatchlistDto;
import gg.troll.report.api.match.service.MatchService;
import gg.troll.report.base.model.CodeResponse;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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

    @GetMapping("/list/encryptedAccountId")
    @ResponseBody
    @ApiOperation(value = "(Riot 제공 API) 계정 아이디로 매치 리스트 조회.", response = MatchlistDto.class)
    @ApiImplicitParams({@ApiImplicitParam(name = "Riot-API-Key",  required = true, dataType = "string", paramType = "header")})
    public CodeResponse getMatchListByEncryptedAccountId(
            @ApiParam(hidden = true) String riotApiKey,
            @RequestParam String encryptedAccountId,
            @RequestParam(required = false, defaultValue = "0") int beginIndex,
            @RequestParam(required = false, defaultValue = "0") int endIndex) throws Exception {
        MatchlistDto matchlistDto = matchService.getMatchListByEncryptedAccountId(riotApiKey, encryptedAccountId, beginIndex, endIndex);
        return CodeResponse.successResult(matchlistDto);
    }

    @GetMapping("/id")
    @ResponseBody
    @ApiOperation(value = "(Riot 제공 API) 매치 아이디로 세부 매치 정보 조회.", response = MatchDto.class)
    @ApiImplicitParams({@ApiImplicitParam(name = "Riot-API-Key",  required = true, dataType = "string", paramType = "header")})
    public CodeResponse getMatchById(@ApiParam(hidden = true) String riotApiKey, @RequestParam long matchId) throws Exception {
        MatchDto matchDto = matchService.getMatchById(riotApiKey, matchId);
        return CodeResponse.successResult(matchDto);
    }
}
