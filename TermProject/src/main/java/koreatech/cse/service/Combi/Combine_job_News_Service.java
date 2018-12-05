package koreatech.cse.service.Combi;

import koreatech.cse.domain.combi.Combi_job_news;
import koreatech.cse.domain.combi.Combi_worknet_navernews;
import koreatech.cse.domain.job.Job;
import koreatech.cse.domain.news.NewsItems;
import koreatech.cse.domain.news.NewsSearchable;
import koreatech.cse.repository.JobMapper;
import koreatech.cse.repository.NewsMapper;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;



@Service
public class Combine_job_News_Service {

    @Inject
    NewsMapper newsMapper;
    @Inject
    JobMapper jobMapper;

    public List<Combi_job_news> combineJobNewsAll() {
        List<Combi_job_news> cjnList = new ArrayList<Combi_job_news>();

        for(Job job : jobMapper.findAllJob()){
            Combi_job_news cjn = new Combi_job_news();
            cjn.setJob(job);

            NewsSearchable newsSearchable = new NewsSearchable();
            newsSearchable.setJobid(job.getJobid());
            cjn.setNewsItemsList(newsMapper.findByProvider(newsSearchable));
            cjnList.add(cjn);
        }
        return cjnList;
    }

    public Combi_job_news combineJobNewsByJobName(String jobname) {
        Combi_job_news cjb = new Combi_job_news();

        Job job = jobMapper.findByJobName(jobname);
        if (job.getJobid() == 0){
            return cjb;
        }
        cjb.setJob(job);
        NewsSearchable newsSearchable = new NewsSearchable();
        newsSearchable.setJobid(job.getJobid());
        List<NewsItems> newsList = newsMapper.findByProvider(newsSearchable);
        cjb.setNewsItemsList(newsList);

        return cjb;
    }

}
