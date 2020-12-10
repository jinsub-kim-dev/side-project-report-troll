package gg.troll.report.api.league.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import gg.troll.report.api.league.model.LeagueEntryDTO;
import gg.troll.report.api.league.model.ReducedLeagueEntryDTO;
import gg.troll.report.api.match.model.MatchlistDto;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class LeagueService {

    public List<LeagueEntryDTO> getLeagueEntryDTOList(String riotApiKey, String encryptedSummonerId) throws Exception {
        String requestURL = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/"+ encryptedSummonerId + "?api_key=" + riotApiKey;

        HttpResponse response = HttpClientBuilder.create().build().execute(new HttpGet(requestURL));
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String body = new BasicResponseHandler().handleResponse(response);
            List<LeagueEntryDTO> leagueEntryDTOList = new ObjectMapper().readValue(body, new TypeReference<List<LeagueEntryDTO>>(){});
            return leagueEntryDTOList;
        } else {
            throw new Exception();
        }
    }

    public List<ReducedLeagueEntryDTO> getReducedLeagueEntryDTOList(String riotApiKey, String encryptedSummonerId) throws Exception {
        List<LeagueEntryDTO> leagueEntryDTOList = getLeagueEntryDTOList(riotApiKey, encryptedSummonerId);
        return leagueEntryDTOList.stream()
                .map(ReducedLeagueEntryDTO::of)
                .collect(Collectors.toList());
    }
}