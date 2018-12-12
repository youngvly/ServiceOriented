package koreatech.cse.domain.combi;

import koreatech.cse.domain.news.NewsItems;
import koreatech.cse.domain.worknet.WorkNetSearchable;

import java.util.List;

public class Combi_worknet_navernews {
    private List<WorkNetSearchable> employList;
    private List<NewsItems> newsList;

    public List<WorkNetSearchable> getEmployList() {
        return employList;
    }

    public void setEmployList(List<WorkNetSearchable> employList) {
        this.employList = employList;
    }

    public List<NewsItems> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<NewsItems> newsList) {
        this.newsList = newsList;
    }
}
