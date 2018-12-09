package koreatech.cse.controller;

import koreatech.cse.domain.combi.Combi_job_news;
import koreatech.cse.domain.combi.Combi_worknet_navernews;
import koreatech.cse.repository.JobMapper;
import koreatech.cse.repository.NewsMapper;
import koreatech.cse.service.Combi.Combine_job_News_Service;
import koreatech.cse.service.Combi.Combine_worknet_News_Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class APIController {

    @Value("${env.text}")
    private String envText;
//    @Inject
//    Combine_job_News_Service combine_job_news_service;
    @Inject
    Combine_worknet_News_Service combine_worknet_news_service;



    @RequestMapping("/about")
    public String apiAbout() {return "apiAbout";}

    @Transactional
    @RequestMapping(value="/json/all" ,method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Combi_worknet_navernews>> json_getAll (){
        List<Combi_worknet_navernews> cwnList = combine_worknet_news_service.getAllCombi();
        if (cwnList == null){
            return new ResponseEntity<List<Combi_worknet_navernews>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Combi_worknet_navernews>>(cwnList,HttpStatus.OK);
    }
    //직업명 검색
    @Transactional
    @RequestMapping(value="/json/jobname/{jobname}" ,method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Combi_worknet_navernews> json_findByName (@PathVariable  String jobname){
        Combi_worknet_navernews cwn = combine_worknet_news_service.combineWorknetNewsByJobName(jobname);
        if (cwn == null){
            return new ResponseEntity<Combi_worknet_navernews>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Combi_worknet_navernews>(cwn,HttpStatus.OK);
    }
    //타입검색 (정규직..)
    @Transactional
    @RequestMapping(value="/json/jobtype/{jobtype}" ,method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Combi_worknet_navernews>> json_findByType (@PathVariable  String jobtype){
        List<Combi_worknet_navernews> cwnList = combine_worknet_news_service.combineWorknetNewsByJobType(jobtype);
        if (cwnList == null){
            return new ResponseEntity<List<Combi_worknet_navernews>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Combi_worknet_navernews>>(cwnList,HttpStatus.OK);
    }
    //날짜검색
    @Transactional
    @RequestMapping(value="/json/date/{start}/{end}", method=RequestMethod.GET , produces = "application/json")
    public ResponseEntity<List<Combi_worknet_navernews>> json_findByDate (@PathVariable int start, @PathVariable int end){
        //날짜검색 미완성상태
        List<Combi_worknet_navernews> cwnList = new ArrayList<>();
        if(cwnList == null){
            return new ResponseEntity<List<Combi_worknet_navernews>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Combi_worknet_navernews>>(cwnList,HttpStatus.OK);
    }

    //진짜 get 방식으로 가져오는 api
    //pramMap -> startDate , endDate , name, type 받을 수 있음.
    @Transactional
    @RequestMapping(value="/json/job" , method=RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Combi_worknet_navernews>> json_totalSearch (@RequestParam HashMap<String, Object> pramMap){
        List<Combi_worknet_navernews> cwnList = combine_worknet_news_service.combineWorknetNewsByMap(pramMap);
        if(cwnList == null) {
            return new ResponseEntity<List<Combi_worknet_navernews>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Combi_worknet_navernews>>(cwnList,HttpStatus.OK);
    }
}
