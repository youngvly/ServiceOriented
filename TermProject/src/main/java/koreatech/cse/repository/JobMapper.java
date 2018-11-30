package koreatech.cse.repository;

import koreatech.cse.domain.job.Job;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobMapper {

    @Select("SELECT * FROM jobBoard_DB.job")
    List<Job> findAllJob();

    @Select("SELECT * FROM jobBoard_DB.job WHERE name = #{jobname}")
    Job findByJobName(String jobname);

    @Insert("INSERT INTO jobBoard_DB.job(name) VALUES(#{jobname})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "jobid", before = false, resultType = int.class)
    void insert(String jobname);
}
