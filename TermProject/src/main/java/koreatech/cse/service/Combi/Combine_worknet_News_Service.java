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
import java.util.Map;

import static javafx.beans.binding.Bindings.select;

@Service
public class Combine_worknet_News_Service {

    @Inject
    WorknetMapper worknetMapper;
    @Inject
    NewsMapper newsMapper;

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

    public List<Combi_worknet_navernews> getAllCombi(){
        //get all job name
        List<Job> jobList =  worknetMapper.selectAllJobName();
        List<Combi_worknet_navernews> cwnList = new ArrayList<>();
        for(Job j : jobList){
            cwnList.add(combineWorknetNewsByJobName(j.getName()));
        }
        return cwnList;
    }

    //타입검색
    public List<Combi_worknet_navernews> combineWorknetNewsByJobType(String jobtype){
        List<Combi_worknet_navernews> cwnList = new ArrayList<>() ;

        WorkNetSearchable workNetSearchable = new WorkNetSearchable();
        workNetSearchable.setType(jobtype);
        List<WorkNetSearchable> foundWork = worknetMapper.select(workNetSearchable);
        for (WorkNetSearchable w : foundWork){
            cwnList.add(combineWorknetNewsByJobName(w.getName()));
        }
        return cwnList;
    }
    //날짜검색
    public List<Combi_worknet_navernews> combineWorknetNewsByDate (int start, int end){
        List <Combi_worknet_navernews> cwnList = new ArrayList<>();

        WorkNetSearchable workNetSearchable = new WorkNetSearchable();
        workNetSearchable.setSdate(start);
        workNetSearchable.setEdate(end);
        List <WorkNetSearchable> foundWork = worknetMapper.select(workNetSearchable);

        for(WorkNetSearchable w : foundWork){
            cwnList.add(combineWorknetNewsByJobName(w.getName()));
        }
        return cwnList;
    }

    public List<Combi_worknet_navernews> combineWorknetNewsByMap (Map map){
        List<Combi_worknet_navernews> cwnList = new ArrayList<>();

        WorkNetSearchable workNetSearchable = new WorkNetSearchable();

        if (map.containsKey("name"))
            workNetSearchable.setName((String)map.get("name"));
        if(map.containsKey("startDate"))
            workNetSearchable.setSdate(Integer.parseInt((String)map.get("startDate")));
        if(map.containsKey("endDate"))
            workNetSearchable.setEdate(Integer.parseInt((String)map.get("endDate")));
        if(map.containsKey("type"))
            workNetSearchable.setType((String)map.get("type"));

        List <WorkNetSearchable> foundWork = worknetMapper.select(workNetSearchable);


        for(WorkNetSearchable w : foundWork){
            cwnList.add(combineWorknetNewsByJobName(w.getName()));
        }
        return cwnList;
    }
}
