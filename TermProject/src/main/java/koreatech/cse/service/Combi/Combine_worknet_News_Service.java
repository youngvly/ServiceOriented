package koreatech.cse.service.Combi;

import koreatech.cse.domain.combi.Combi_worknet_navernews;
import koreatech.cse.domain.job.Job;
import koreatech.cse.domain.news.NewsSearchable;
import koreatech.cse.domain.worknet.WorkNetItem;
import koreatech.cse.domain.worknet.WorkNetSearchable;
import koreatech.cse.repository.NewsMapper;
import koreatech.cse.repository.WorknetMapper;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import static javafx.beans.binding.Bindings.select;

@Service
public class Combine_worknet_News_Service {

    @Inject
    WorknetMapper worknetMapper;
    @Inject
    NewsMapper newsMapper;

    public List<Combi_worknet_navernews> getAllCombi(){
        //get all job name
        List<Job> jobList =  worknetMapper.selectAllJobName();
        List<Combi_worknet_navernews> cwnList = new ArrayList<>();
        for(Job j : jobList){
            cwnList.add(combineWorknetNewsByJobName(j.getName()));
        }
        return cwnList;
    }
    public Combi_worknet_navernews combineWorknetNewsByJobName(String jobname){
        Combi_worknet_navernews cwn = new Combi_worknet_navernews();

        WorkNetSearchable workNetSearchable = new WorkNetSearchable();
        workNetSearchable.setName(jobname);
        cwn.setWorkNetItemList(worknetMapper.select(workNetSearchable));

        NewsSearchable newsSearchable = new NewsSearchable();
        //뉴스를 뭘로부르지 (jobid 하면 중복 너무많고 / jobname 하려면 news에 jobname이 들어가야한다?)
        newsSearchable.setJobname(jobname);
        cwn.setNewsItemsList(newsMapper.findByProvider(newsSearchable));

        return cwn;
    }
/*
    public List<Combi_worknet_navernews> combineWorknetNewsByJobType(String jobtype){
        List<Combi_worknet_navernews> cwn = new ArrayList<>() ;

        WorkNetSearchable workNetSearchable = new WorkNetSearchable();
        workNetSearchable.setType(jobtype);
        List<WorkNetSearchable> foundWork = worknetMapper.select(workNetSearchable);
        cwn.


        NewsSearchable newsSearchable = new NewsSearchable();


        return cwn;
    }*/
}
