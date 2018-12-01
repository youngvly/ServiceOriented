package koreatech.cse.thread;

import koreatech.cse.controller.NaverNewsController;
import koreatech.cse.domain.job.Job;
import koreatech.cse.repository.JobMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.inject.Inject;
import java.util.List;

public class TimerAutoPull implements Runnable {

    private static int number = 0;
    @Inject
    private NaverNewsController naverNewsController;
    @Inject
    private JobMapper jobMapper;
    @Override
    public void run() {
        List<Job> jobList =  jobMapper.findAllJob();
        for(Job job : jobList){
            naverNewsController.getNewsByQuery(job.getName());
        }

        System.out.println("run" + number++);
    }
}


