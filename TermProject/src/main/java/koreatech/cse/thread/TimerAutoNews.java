package koreatech.cse.thread;

import koreatech.cse.domain.worknet.WorkNetItem;
import koreatech.cse.repository.WorknetMapper;
import koreatech.cse.service.news.NaverNewsGet;
import koreatech.cse.domain.job.Job;
import koreatech.cse.repository.JobMapper;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.util.List;


public class TimerAutoNews implements Runnable {

    private static int number = 0;
    @Inject
    private NaverNewsGet naverNewsGet;
    @Inject
    private WorknetMapper worknetMapper;

    private Logger logger = org.apache.logging.log4j.LogManager.getLogger(LogControl.class);

    @Override
    public void run() {
        //logControl.func();
        logger.info("DB NEWS Updated | " + number++ + " times");
//        List<Job> jobList =  jobMapper.findAllJob();
//        for(Job job : jobList){
//            naverNewsGet.getNewsByQuery(job.getName());
//        }

        List<Job> jobList = worknetMapper.selectAllJobName();
       // System.out.println(jobList);
        for(Job j : jobList){
            naverNewsGet.getNewsByQuery(j.getName());
        }
//        System.out.println("run" + number++);
    }
}


