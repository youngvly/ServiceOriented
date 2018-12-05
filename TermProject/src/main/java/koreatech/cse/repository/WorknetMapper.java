package koreatech.cse.repository;

import koreatech.cse.domain.news.NewsItems;
import koreatech.cse.domain.worknet.WorkNetItem;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Repository;

@Repository
public interface WorknetMapper {
    @Insert("INSERT INTO jobBoard_DB.worknet (TITLE, NAME, SDATE, EDATE, TYPE, LOGO, URL) VALUES (#{empWantedTitle}, #{empBusiNm}, #{empWantedStdt}, #{empWantedEndt}, #{empWantedTypeNm}, #{regLogImgNm}, #{empWantedHomepgDetail})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "jobid", before = false, resultType = int.class)
    void insert(WorkNetItem workNetItem);

}
