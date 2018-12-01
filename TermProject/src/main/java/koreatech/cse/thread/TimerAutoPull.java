package koreatech.cse.thread;

import koreatech.cse.controller.NaverNewsController;
import koreatech.cse.domain.job.Job;
import koreatech.cse.repository.JobMapper;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.util.List;


public class TimerAutoPull implements Runnable {

    private static int number = 0;
    @Inject
    private NaverNewsController naverNewsController;
    @Inject
    private JobMapper jobMapper;

    private Logger logger = org.apache.logging.log4j.LogManager.getLogger(LogControl.class);

    @Override
    public void run() {
        //logControl.func();
        logger.info("DB Updated | " + number++ + " times");
        List<Job> jobList =  jobMapper.findAllJob();
        for(Job job : jobList){
            naverNewsController.getNewsByQuery(job.getName());
        }

//        System.out.println("run" + number++);
    }
}


