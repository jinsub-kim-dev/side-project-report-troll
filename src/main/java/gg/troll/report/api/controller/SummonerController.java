package gg.troll.report.api.controller;

import gg.troll.report.api.summoner.service.SummonerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/summoner")
public class SummonerController {

    @Autowired
    SummonerService summonerService;


}
