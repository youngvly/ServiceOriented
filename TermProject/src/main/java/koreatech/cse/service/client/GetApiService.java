package koreatech.cse.service.client;

import koreatech.cse.domain.Client.ClientPOJO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import static java.util.stream.Collectors.joining;

@Service
public class GetApiService {

    @Value("${aws.server.url}")
    private String serverURL;

    private String encodeValue(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    public ClientPOJO getApi (Map<String, String> param) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            String encodedURL = param.keySet().stream()
//                    .map(key -> key + "=" + encodeValue(param.get(key)))
                    .map(key -> key + "=" + param.get(key))
                    .collect(joining("&", serverURL + "/api/json/job?", ""));

            ResponseEntity<ClientPOJO> responseEntity = restTemplate.getForEntity(encodedURL,ClientPOJO.class);
//                ClientPOJO clientPOJO = restTemplate.getForObject(encodedURL,ClientPOJO.class);
            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                ClientPOJO clientPOJO = responseEntity.getBody();
//                System.out.println(clientPOJO.toString());
                return clientPOJO;
            }else {
                System.out.println(responseEntity.getStatusCode());
            }
//            return clientPOJO;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;

    }

}
