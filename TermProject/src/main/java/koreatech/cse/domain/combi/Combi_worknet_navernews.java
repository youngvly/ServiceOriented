package koreatech.cse.domain.combi;

import koreatech.cse.domain.news.NewsItems;
import koreatech.cse.domain.worknet.WorkNetItem;

import java.util.List;

public class Combi_worknet_navernews {
    private List<WorkNetItem> workNetItemList;
    private List<NewsItems> newsItemsList;

    public List<WorkNetItem> getWorkNetItemList() {
        return workNetItemList;
    }

    public void setWorkNetItemList(List<WorkNetItem> workNetItemList) {
        this.workNetItemList = workNetItemList;
    }

    public List<NewsItems> getNewsItemsList() {
        return newsItemsList;
    }

    public void setNewsItemsList(List<NewsItems> newsItemsList) {
        this.newsItemsList = newsItemsList;
    }
}
