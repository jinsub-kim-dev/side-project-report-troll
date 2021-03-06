package gg.troll.report.api.summoner.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import gg.troll.report.api.summoner.model.SummonerDTO;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Service;

@Service
public class SummonerService {

    public SummonerDTO getSummonerByName(String riotApiKey, String summonerName) throws Exception {
        summonerName = summonerName.replaceAll(" ", "%20");
        String requestURL = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/"+ summonerName + "?api_key=" + riotApiKey;

        HttpResponse response = HttpClientBuilder.create().build().execute(new HttpGet(requestURL));
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String body = new BasicResponseHandler().handleResponse(response);
            SummonerDTO summonerDTO = new ObjectMapper().readValue(body, SummonerDTO.class);
            return summonerDTO;
        } else {
            throw new Exception();
        }
    }
}
