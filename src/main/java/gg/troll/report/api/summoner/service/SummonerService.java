package gg.troll.report.api.summoner.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import gg.troll.report.api.league.model.ReducedLeagueEntryDTO;
import gg.troll.report.api.league.service.LeagueService;
import gg.troll.report.api.summoner.model.LeagueSummonerDTO;
import gg.troll.report.api.summoner.model.SummonerDTO;
import gg.troll.report.base.exception.RiotRestApiTemplateException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SummonerService {

    @Autowired
    LeagueService leagueService;

    @Value("${riot.api.key}")
    String riotApiKey;

    public SummonerDTO getSummonerByName(String summonerName) throws Exception {
        summonerName = summonerName.replaceAll(" ", "%20");
        String requestURL = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/"+ summonerName + "?api_key=" + riotApiKey;

        HttpResponse response = HttpClientBuilder.create().build().execute(new HttpGet(requestURL));
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String body = new BasicResponseHandler().handleResponse(response);
            SummonerDTO summonerDTO = new ObjectMapper().readValue(body, SummonerDTO.class);
            return summonerDTO;
        } else {
            throw RiotRestApiTemplateException.of(response);
        }
    }

    public LeagueSummonerDTO getLeagueSummonerBySummonerDto(SummonerDTO summonerDTO) throws Exception {
        String encryptedSummonerId = summonerDTO.getId();
        List<ReducedLeagueEntryDTO> reducedLeagueEntryDTOList = leagueService.getReducedLeagueEntryDTOList(encryptedSummonerId);
        return LeagueSummonerDTO.builder()
                .accountId(summonerDTO.getAccountId())
                .id(summonerDTO.getId())
                .name(summonerDTO.getName())
                .profileIconId(summonerDTO.getProfileIconId())
                .summonerLevel(summonerDTO.getSummonerLevel())
                .leagueEntries(reducedLeagueEntryDTOList)
                .build();
    }

    public LeagueSummonerDTO getLeagueSummonerByName(String summonerName) throws Exception {
        SummonerDTO summonerDTO = getSummonerByName(summonerName);
        return getLeagueSummonerBySummonerDto(summonerDTO);
    }
}
