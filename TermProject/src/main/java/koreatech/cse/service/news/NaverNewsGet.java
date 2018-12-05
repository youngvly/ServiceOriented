package koreatech.cse.service.news;

import koreatech.cse.domain.job.Job;
import koreatech.cse.domain.news.News;
import koreatech.cse.domain.news.NewsItems;
import koreatech.cse.domain.news.NewsSearchable;
import koreatech.cse.domain.oauth2.kakao.Properties;
import koreatech.cse.domain.worknet.WorkNetItem;
import koreatech.cse.repository.JobMapper;
import koreatech.cse.repository.NewsMapper;
import koreatech.cse.repository.WorknetMapper;
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
import java.util.List;

@Controller
@RequestMapping("/news")
public class NaverNewsGet {
    @Value( "${navernews.clientid}" )
    private String clientId;
    @Value("${navernews.secret}")
    private String clientSecret;
    @Inject
    private NewsMapper newsMapper;
    @Inject
    private JobMapper jobMapper;
    @Inject
    private WorknetMapper worknetMapper;
    @Inject
    private NewsService newsService;

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    @RequestMapping("/getandinsert/{query}")
    public String getNewsByQuery(@PathVariable  String query){

//        System.out.println(query);
//        Job job = jobMapper.findByJobName(query);
//        if (job == null) {
//            jobMapper.insert(query);
//        }

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
                newsService.deleteOldNewsByJobName(news.getnewsItems(), query);
                for (NewsItems item : news.getnewsItems()) {
                    //동일한 기사가 존재하는지 검색 (중복 삽입 방지)
                    NewsSearchable newsSearchable = new NewsSearchable();
                    newsSearchable.setOriginalLink(item.getOriginallink());

                    if (newsMapper.findByProvider(newsSearchable).size() == 0) {
//                        item.setJobid(job.getJobid());
                        item.setJobname(query);
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


}
