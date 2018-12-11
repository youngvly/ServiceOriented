package koreatech.cse.service.news;

import koreatech.cse.domain.news.NewsItems;
import koreatech.cse.domain.news.NewsSearchable;
import koreatech.cse.repository.NewsMapper;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class NewsService {

    @Inject
    private NewsMapper newsMapper;

    private int getMonthByStr(String monthstr){
        switch (monthstr){
            case "Jan" : return 1;
            case "Feb" : return 2;
            case "Mar" : return 3;
            case "Apr" : return 4;
            case "May" : return 5;
            case "Jun" : return 6;
            case "July" :
            case "Jul" : return 7;
            case "Aug" : return 8;
            case "Sep" : return 9;
            case "Oct" : return 10;
            case "Nov" : return 11;
            case "Dec" : return 12;
            default: return 0;
        }
    }
    private boolean isOld (String date1,String date2){
        //pubdate 형식 : "Fri, 30 Nov 2018 23:44:00 +0900
        int date1_day = Integer.parseInt(date1.substring(5,6));
        int date2_day = Integer.parseInt(date2.substring(5,6));
        int date1_month = getMonthByStr(date1.substring(8,10));
        int date2_month = getMonthByStr(date2.substring(8,10));
        int date1_year = Integer.parseInt(date1.substring(12,15));
        int date2_year = Integer.parseInt(date2.substring(12,15));
        int date1_hour = Integer.parseInt(date1.substring(17,18));
        int date2_hour = Integer.parseInt(date2.substring(17,18));
        int date1_min = Integer.parseInt(date1.substring(20,21));
        int date2_min = Integer.parseInt(date2.substring(20,21));

        //date1이 더 오래됬으면(숫자가 작으면) true
        if (date1_year >= date2_year){
            if(date1_month >= date2_month){
                if(date1_day>=date2_day){
                    if(date1_hour>=date2_hour){
                        if(date1_min>=date2_min)
                            return false;                //date1이 더 최근 or 같으면
                    }
                }
            }
        }
        return true;
    }
    //가져온 뉴스들중 가장 오래된 뉴스 기준으로 더오래된 DB에있는 뉴스 삭제
    public void deleteOldNews(List<NewsItems> newsItems,int jobid) {
        String oldestPubdate = newsItems.get(0).getPubDate();
        NewsSearchable newsSearchable = new NewsSearchable();
        newsSearchable.setOrderParam("pubdate");
        List<NewsItems> newsItemsDB = newsMapper.findByProvider(newsSearchable);

        for(NewsItems item : newsItems){
            if (isOld(oldestPubdate,item.getPubDate())){
                oldestPubdate = item.getPubDate();
            }
        }
        for(NewsItems itemDB : newsItemsDB){
            if (isOld(itemDB.getPubDate(),oldestPubdate)){
                newsMapper.delete(itemDB.getNewsid());
            }
        }
    }

    //가져온 뉴스들중 가장 오래된 뉴스 기준으로 더오래된 DB에있는 뉴스 삭제
    public void deleteOldNewsByJobName(List<NewsItems> newsItems,String jobName) {
        String oldestPubdate = newsItems.get(0).getPubDate();
        NewsSearchable newsSearchable = new NewsSearchable();
        newsSearchable.setOrderParam("pubdate");
        newsSearchable.setJobname(jobName);
        List<NewsItems> newsItemsDB = newsMapper.findByProvider(newsSearchable);

        for(NewsItems item : newsItems){
            if (isOld(oldestPubdate,item.getPubDate())){
                oldestPubdate = item.getPubDate();
            }
        }
        for(NewsItems itemDB : newsItemsDB){
            if (isOld(itemDB.getPubDate(),oldestPubdate)){
                newsMapper.delete(itemDB.getNewsid());
            }
        }
    }
}
