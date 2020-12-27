package gg.troll.report.api.match.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import gg.troll.report.api.match.model.*;
import gg.troll.report.api.summoner.model.SummonerDTO;
import gg.troll.report.api.summoner.service.SummonerService;
import gg.troll.report.base.exception.RiotRestApiTemplateException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatchService {

    @Autowired
    SummonerService summonerService;

    @Value("${riot.api.key}")
    String riotApiKey;

    public MatchlistDto getMatchListByEncryptedAccountId(String encryptedAccountId, int beginIndex, int endIndex) throws Exception {
        String requestURL = "https://kr.api.riotgames.com/lol/match/v4/matchlists/by-account/"+ encryptedAccountId + "?api_key=" + riotApiKey;
        requestURL = beginIndex > 0 ? requestURL + "&beginIndex=" + beginIndex : requestURL;
        requestURL = endIndex > 0 ? requestURL + "&endIndex=" + endIndex : requestURL;

        HttpResponse response = HttpClientBuilder.create().build().execute(new HttpGet(requestURL));
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String body = new BasicResponseHandler().handleResponse(response);
            MatchlistDto matchlistDto = new ObjectMapper().readValue(body, MatchlistDto.class);
            return matchlistDto;
        } else {
            throw RiotRestApiTemplateException.of(response);
        }
    }

    public MatchDto getMatchById(long matchId) throws Exception {
        String requestURL = "https://kr.api.riotgames.com/lol/match/v4/matches/"+ matchId + "?api_key=" + riotApiKey;

        HttpResponse response = HttpClientBuilder.create().build().execute(new HttpGet(requestURL));
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String body = new BasicResponseHandler().handleResponse(response);
            MatchDto matchDto = new ObjectMapper().readValue(body, MatchDto.class);
            return matchDto;
        } else {
            throw RiotRestApiTemplateException.of(response);
        }
    }

    public ReducedMatchDto getReducedMatchById(long matchId) throws Exception {
        MatchDto matchDto = getMatchById(matchId);
        return ReducedMatchDto.of(matchDto);
    }

    public ReducedMatchlistDto getReducedMatchListBySummonerDto(SummonerDTO summonerDTO, int beginIndex, int endIndex) throws Exception {
        String encryptedAccountId = summonerDTO.getAccountId();

        MatchlistDto matchlistDto = getMatchListByEncryptedAccountId(encryptedAccountId, beginIndex, endIndex);
        List<ReducedMatchDto> matches = new ArrayList<>();
        for (MatchReferenceDto matchReferenceDto : matchlistDto.getMatches()) {
            matches.add(getReducedMatchById(matchReferenceDto.getGameId()));
        }

        return ReducedMatchlistDto.builder()
                .startIndex(matchlistDto.getStartIndex())
                .endIndex(matchlistDto.getEndIndex())
                .totalGames(matchlistDto.getTotalGames())
                .matches(matches)
                .build();
    }

    public ReducedMatchlistDto getReducedMatchListBySummonerName(String summonerName, int beginIndex, int endIndex) throws Exception {
        SummonerDTO summonerDTO = summonerService.getSummonerByName(summonerName);
        return getReducedMatchListBySummonerDto(summonerDTO, beginIndex, endIndex);
    }
}
