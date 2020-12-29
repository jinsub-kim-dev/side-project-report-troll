package gg.troll.report.api.controller;

import gg.troll.report.api.spectator.model.ReducedCurrentGameInfoDto;
import gg.troll.report.api.spectator.service.SpectatorService;
import gg.troll.report.base.model.CodeResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/spectator")
public class SpectatorController {

    @Autowired
    SpectatorService spectatorService;

    @CrossOrigin("*")
    @GetMapping("/currentGame/summonerId")
    @ResponseBody
    @ApiOperation(value = "소환사의 현재 인게임 정보를 조회한다.", response = ReducedCurrentGameInfoDto.class)
    public CodeResponse getCurrentGameInfoBySummonerId(@RequestParam String summonerId) throws Exception {
        ReducedCurrentGameInfoDto reducedCurrentGameInfoDto = spectatorService.getReducedCurrentGameInfoDto(summonerId);
        return CodeResponse.successResult(reducedCurrentGameInfoDto);
    }
}
