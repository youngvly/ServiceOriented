package koreatech.cse.repository;

import koreatech.cse.domain.job.Job;
import koreatech.cse.domain.news.NewsItems;
import koreatech.cse.domain.worknet.WorkNetItem;
import koreatech.cse.domain.worknet.WorkNetSearchable;
import koreatech.cse.repository.provider.WorknetSqlProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorknetMapper {
    @Insert("INSERT INTO jobBoard_DB.worknet (TITLE, NAME, SDATE, EDATE, TYPE, LOGO, URL) VALUES (#{empWantedTitle}, #{empBusiNm}, #{empWantedStdt}, #{empWantedEndt}, #{empWantedTypeNm}, #{regLogImgNm}, #{empWantedHomepgDetail})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "jobid", before = false, resultType = int.class)
    void insert(WorkNetItem workNetItem);

    @SelectProvider(method = "findAllByProvider" , type = WorknetSqlProvider.class)
    List<WorkNetSearchable> select(WorkNetSearchable workNetSearchable);
    //WorkNetItem DTO와 DB index 불일치, 가져오기불가능 -> WorkNetSearchable로 가져와야함

    @Select("SELECT DISTINCT NAME FROM jobBoard_DB.worknet")
    List<Job> selectAllJobName();
}
