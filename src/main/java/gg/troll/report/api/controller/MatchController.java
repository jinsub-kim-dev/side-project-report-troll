package gg.troll.report.api.controller;

import gg.troll.report.api.match.service.MatchService;
import gg.troll.report.api.summoner.model.SummonerDTO;
import gg.troll.report.base.model.CodeResponse;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/v1/match")
public class MatchController {

    @Autowired
    MatchService matchService;
}
