package gg.troll.report.api.controller;

import gg.troll.report.api.summoner.model.SummonerDTO;
import gg.troll.report.api.summoner.service.SummonerService;
import gg.troll.report.base.model.CodeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/summoner")
public class SummonerController {

    @Autowired
    SummonerService summonerService;

    @GetMapping("/name")
    @ResponseBody
    public CodeResponse getSummonerByName(@RequestParam String riotApiKey, @RequestParam String summonerName) throws Exception {
        SummonerDTO summonerDTO = summonerService.getSummonerByName(riotApiKey, summonerName);
        return CodeResponse.successResult(summonerDTO);
    }
}
