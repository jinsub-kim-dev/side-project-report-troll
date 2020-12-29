package gg.troll.report.api.spectator.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import gg.troll.report.api.league.model.LeagueEntryDTO;
import gg.troll.report.api.spectator.model.CurrentGameInfoDto;
import gg.troll.report.base.exception.RiotRestApiTemplateException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpectatorService {

    @Value("${riot.api.key}")
    String riotApiKey;

    public CurrentGameInfoDto getCurrentGameInfoDto(String encryptedSummonerId) throws Exception {
        String requestURL = "https://kr.api.riotgames.com/lol/spectator/v4/active-games/by-summoner/"+ encryptedSummonerId + "?api_key=" + riotApiKey;

        HttpResponse response = HttpClientBuilder.create().build().execute(new HttpGet(requestURL));
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String body = new BasicResponseHandler().handleResponse(response);
            CurrentGameInfoDto currentGameInfoDto = new ObjectMapper().readValue(body, CurrentGameInfoDto.class);
            return currentGameInfoDto;
        } else {
            throw RiotRestApiTemplateException.of(response);
        }
    }
}
