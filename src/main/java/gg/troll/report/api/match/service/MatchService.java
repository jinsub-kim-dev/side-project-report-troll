package gg.troll.report.api.match.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import gg.troll.report.api.match.model.MatchDto;
import gg.troll.report.api.match.model.MatchlistDto;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Service;

@Service
public class MatchService {

    public MatchlistDto getMatchListByEncryptedAccountId(String riotApiKey, String encryptedAccountId, int beginIndex, int endIndex) throws Exception {
        String requestURL = "https://kr.api.riotgames.com/lol/match/v4/matchlists/by-account/"+ encryptedAccountId + "?api_key=" + riotApiKey;
        requestURL = beginIndex > 0 ? requestURL + "&beginIndex=" + beginIndex : requestURL;
        requestURL = endIndex > 0 ? requestURL + "&endIndex=" + endIndex : requestURL;

        HttpResponse response = HttpClientBuilder.create().build().execute(new HttpGet(requestURL));
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String body = new BasicResponseHandler().handleResponse(response);
            MatchlistDto matchlistDto = new ObjectMapper().readValue(body, MatchlistDto.class);
            return matchlistDto;
        } else {
            throw new Exception();
        }
    }

    public MatchDto getMatchById(String riotApiKey, long matchId) throws Exception {
        String requestURL = "https://kr.api.riotgames.com/lol/match/v4/matches/"+ matchId + "?api_key=" + riotApiKey;

        HttpResponse response = HttpClientBuilder.create().build().execute(new HttpGet(requestURL));
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String body = new BasicResponseHandler().handleResponse(response);
            MatchDto matchDto = new ObjectMapper().readValue(body, MatchDto.class);
            return matchDto;
        } else {
            throw new Exception();
        }
    }
}
