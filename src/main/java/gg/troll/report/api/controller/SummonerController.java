package gg.troll.report.api.controller;

import gg.troll.report.api.summoner.model.SummonerDTO;
import gg.troll.report.api.summoner.service.SummonerService;
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
@RequestMapping("/api/v1/summoner")
public class SummonerController {

    @Autowired
    SummonerService summonerService;

    @GetMapping("/name")
    @ResponseBody
    @ApiOperation(value = "(Riot 제공 API) 닉네임으로 계정 정보 조회.", response = SummonerDTO.class)
    @ApiImplicitParams({@ApiImplicitParam(name = "Riot-API-Key",  required = true, dataType = "string", paramType = "header")})
    public CodeResponse getSummonerByName(@ApiParam(hidden = true) String riotApiKey, @RequestParam String summonerName) throws Exception {
        SummonerDTO summonerDTO = summonerService.getSummonerByName(riotApiKey, summonerName);
        return CodeResponse.successResult(summonerDTO);
    }
}
