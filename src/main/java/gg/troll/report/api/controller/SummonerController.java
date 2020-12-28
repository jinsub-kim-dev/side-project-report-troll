package gg.troll.report.api.controller;

import gg.troll.report.api.summoner.model.LeagueSummonerDTO;
import gg.troll.report.api.summoner.service.SummonerService;
import gg.troll.report.base.model.CodeResponse;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/summoner")
public class SummonerController {

    @Autowired
    SummonerService summonerService;

    @CrossOrigin("*")
    @GetMapping("/name")
    @ResponseBody
    public CodeResponse getLeagueSummonerByName(@ApiParam(hidden = true) String riotApiKey,  @RequestParam String summonerName) throws Exception {
        LeagueSummonerDTO leagueSummonerDTO = summonerService.getLeagueSummonerByName(summonerName);
        return CodeResponse.successResult(leagueSummonerDTO);
    }
}
