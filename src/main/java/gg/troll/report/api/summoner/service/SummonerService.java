package gg.troll.report.api.summoner.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import gg.troll.report.api.league.model.ReducedLeagueEntryDTO;
import gg.troll.report.api.league.service.LeagueService;
import gg.troll.report.api.summoner.model.LeagueSummonerDTO;
import gg.troll.report.api.summoner.model.SummonerDTO;
import gg.troll.report.base.exception.ErrorCode;
import gg.troll.report.base.exception.RiotRestApiTemplateException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SummonerService {

    @Autowired
    LeagueService leagueService;

    public SummonerDTO getSummonerByName(String riotApiKey, String summonerName) throws Exception {
        summonerName = summonerName.replaceAll(" ", "%20");
        String requestURL = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/"+ summonerName + "?api_key=" + riotApiKey;

        HttpResponse response = HttpClientBuilder.create().build().execute(new HttpGet(requestURL));
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String body = new BasicResponseHandler().handleResponse(response);
            SummonerDTO summonerDTO = new ObjectMapper().readValue(body, SummonerDTO.class);
            return summonerDTO;
        } else {
            String message = String.format("%d %s", response.getStatusLine().getStatusCode(), response.getStatusLine().getReasonPhrase());
            throw new RiotRestApiTemplateException(ErrorCode.RIOT_REST_API_TEMPLATE_FAIL, message);
        }
    }

    public LeagueSummonerDTO getLeagueSummonerByName(String riotApiKey, String summonerName) throws Exception {
        SummonerDTO summonerDTO = getSummonerByName(riotApiKey, summonerName);
        String encryptedSummonerId = summonerDTO.getId();
        List<ReducedLeagueEntryDTO> reducedLeagueEntryDTOList = leagueService.getReducedLeagueEntryDTOList(riotApiKey, encryptedSummonerId);
        return LeagueSummonerDTO.builder()
                .accountId(summonerDTO.getAccountId())
                .id(summonerDTO.getId())
                .name(summonerDTO.getName())
                .profileIconId(summonerDTO.getProfileIconId())
                .summonerLevel(summonerDTO.getSummonerLevel())
                .leagueEntries(reducedLeagueEntryDTOList)
                .build();
    }
}
