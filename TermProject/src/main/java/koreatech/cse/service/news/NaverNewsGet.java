package koreatech.cse.controller;

import koreatech.cse.domain.job.Job;
import koreatech.cse.domain.news.News;
import koreatech.cse.domain.news.NewsItems;
import koreatech.cse.domain.news.NewsSearchable;
import koreatech.cse.domain.oauth2.kakao.Properties;
import koreatech.cse.repository.JobMapper;
import koreatech.cse.repository.NewsMapper;
import koreatech.cse.service.news.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
@Controller
@RequestMapping("/news")
public class NaverNewsController {
    @Value( "${navernews.clientid}" )
    private String clientId;
    @Value("${navernews.secret}")
    private String clientSecret;
    @Inject
    private NewsMapper newsMapper;
    @Inject
    private JobMapper jobMapper;
    @Inject
    private NewsService newsService;

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    @RequestMapping("/getandinsert/{query}")
    public String getNewsByQuery(@PathVariable  String query){

        System.out.println(query);
        Job job = jobMapper.findByJobName(query);
        if (job == null) {
            jobMapper.insert(query);
        }

        RestTemplate restTemplate = new RestTemplate();
        try {
            String apiURL = "https://openapi.naver.com/v1/search/news.json?query=" + query + "&start=1&display=5";

            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("X-Naver-Client-Id", clientId);
            httpHeaders.set("X-Naver-Client-Secret", clientSecret);
            HttpEntity httpEntity = new HttpEntity(httpHeaders);
            ResponseEntity<News> responseEntity = restTemplate.exchange(apiURL, HttpMethod.GET,httpEntity,News.class);
            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                News news = responseEntity.getBody();
                //System.out.println(news.getnewsItems().get(0).getDescription());
                //오래된 뉴스 삭제
                newsService.deleteOldNews(news.getnewsItems(),job.getJobid());
                for (NewsItems item : news.getnewsItems()) {
                    //동일한 기사가 존재하는지 검색 (중복 삽입 방지)
                    NewsSearchable newsSearchable = new NewsSearchable();
                    newsSearchable.setOriginalLink(item.getOriginallink());

                    if (newsMapper.findByProvider(newsSearchable).size() == 0) {
                        item.setJobid(job.getJobid());
                        newsMapper.insert(item);
                    }
                }
            }else {
                System.out.println(responseEntity.getStatusCode());
            }
        }catch (Exception e){
            System.out.println("Exception : " + e);
        }
        return "";
    }
    /*
    public String getNewsByQuery(@PathVariable  String query){
        String clientId = "ShTtWbORirQo5IR2_QPQ";
        String clientSecret = "SyzJd7bevI";
        System.out.println(query);
        try {
            String text = URLEncoder.encode(query, "UTF-8");
            String apiURL = "https://openapi.naver.com/v1/search/news.json?query=" + query + "&start=1&display=5";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);

            int responseCode = con.getResponseCode();
            System.out.println("responseCode=" + responseCode);
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            System.out.println(response.toString());
        }catch (Exception e){
            System.out.println(e);
        }
        return "";
    }
*/


}
