package koreatech.cse.service.client;

import koreatech.cse.domain.Client.ClientPOJO;
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
                    .map(key -> key + "=" + encodeValue(param.get(key)))
                    .collect(joining("&", "http://testappelasticbeanstalk-env.hhm2ctb7ye.ap-northeast-2.elasticbeanstalk.com/api/json/job?", ""));

//            String apiURL = "http://testappelasticbeanstalk-env.hhm2ctb7ye.ap-northeast-2.elasticbeanstalk.com/api/json/job?";
//            if (workNetSearchable.getType().length() >0) apiURL += "type="+workNetSearchable.getType();
//            if (workNetSearchable.getSdate() >0) apiURL += "&startDate=" + workNetSearchable.getSdate();
//            if (workNetSearchable.getEdate() >0) apiURL += "&endDate = "+ workNetSearchable.getEdate();
//            if (workNetSearchable.getName().length() >0) apiURL += "&name = " + workNetSearchable.getName();

            ResponseEntity<ClientPOJO> responseEntity = restTemplate.getForEntity(encodedURL, ClientPOJO.class);
            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                ClientPOJO clientPOJO = responseEntity.getBody();
                System.out.println(clientPOJO.toString());
                return clientPOJO;
            }else {
                System.out.println(responseEntity.getStatusCode());
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;

    }

}
