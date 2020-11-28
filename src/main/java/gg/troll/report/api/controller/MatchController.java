package gg.troll.report.api.controller;

import gg.troll.report.api.match.model.MatchDto;
import gg.troll.report.api.match.model.MatchlistDto;
import gg.troll.report.api.match.service.MatchService;
import gg.troll.report.base.model.CodeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/match")
public class MatchController {

    @Autowired
    MatchService matchService;

    @RequestMapping("/list/encryptedAccountId")
    @ResponseBody
    public CodeResponse getMatchListByEncryptedAccountId(
            @RequestParam String riotApiKey,
            @RequestParam String encryptedAccountId,
            @RequestParam(required = false, defaultValue = "0") int beginIndex,
            @RequestParam(required = false, defaultValue = "0") int endIndex) throws Exception {
        MatchlistDto matchlistDto = matchService.getMatchListByEncryptedAccountId(riotApiKey, encryptedAccountId, beginIndex, endIndex);
        return CodeResponse.successResult(matchlistDto);
    }

    @RequestMapping("/id")
    @ResponseBody
    public CodeResponse getMatchById(@RequestParam String riotApiKey, @RequestParam long matchId) throws Exception {
        MatchDto matchDto = matchService.getMatchById(riotApiKey, matchId);
        return CodeResponse.successResult(matchDto);
    }
}
