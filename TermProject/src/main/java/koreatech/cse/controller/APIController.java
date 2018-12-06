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

import javax.inject.Inject;

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

//    @Transactional
//    @RequestMapping(value="/json/jobname/{jobname}" ,method= RequestMethod.GET, produces = "application/json")
//    public ResponseEntity<Combi_job_news> json_findByJob (@PathVariable  String jobname){
//        Combi_job_news cjn = combine_job_news_service.combineJobNewsByJobName(jobname);
//        if (cjn == null){
//            return new ResponseEntity<Combi_job_news>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<Combi_job_news>(cjn,HttpStatus.OK);
//    }

    @Transactional
    @RequestMapping(value="/json/jobname/{jobname}" ,method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Combi_worknet_navernews> json_findByJob (@PathVariable  String jobname){
        Combi_worknet_navernews cwn = combine_worknet_news_service.combineWorknetNewsByJobName(jobname);
        if (cwn == null){
            return new ResponseEntity<Combi_worknet_navernews>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Combi_worknet_navernews>(cwn,HttpStatus.OK);
    }


}
