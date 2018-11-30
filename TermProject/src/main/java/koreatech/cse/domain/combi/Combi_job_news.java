package koreatech.cse.domain.combi;

import koreatech.cse.domain.job.Job;
import koreatech.cse.domain.news.News;
import koreatech.cse.domain.news.NewsItems;

import java.util.List;

public class Combi_job_news {
    private List<NewsItems> newsItemsList;
    private Job job;

    public List<NewsItems> getNewsItemsList() {
        return newsItemsList;
    }

    public void setNewsItemsList(List<NewsItems> newsItemsList) {
        this.newsItemsList = newsItemsList;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
