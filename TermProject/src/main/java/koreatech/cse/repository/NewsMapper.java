package koreatech.cse.repository;


import koreatech.cse.domain.Searchable;
import koreatech.cse.domain.User;
import koreatech.cse.domain.news.NewsItems;
import koreatech.cse.domain.news.NewsSearchable;
import koreatech.cse.repository.provider.NewsSqlProvider;
import koreatech.cse.repository.provider.UserSqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsMapper {
    @Insert("INSERT INTO jobBoard_DB.news (TITLE, DESCRIPTION, NAVERLINK, ORIGINALLINK,PUBDATE,JOBID,JOBNAME) VALUES (#{title}, #{description}, #{link}, #{originallink}, #{pubDate},#{jobid},#{jobname})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "newsid", before = false, resultType = int.class)
    void insert(NewsItems newsNewsItems);

    /*@Update("UPDATE NEWS SET NAME = #{name}, EMAIL = #{email}, PASSWORD = #{password}, AGE = #{age} WHERE ID = #{id}")
    void update(User user);

    @Select("SELECT * FROM NEWS WHERE NEWSID = #{newsid}")
    NewsItems findOne(@Param("newsid") int newsid);

    @Select("SELECT * FROM NEWS WHERE JOBID = #{jobid}")
    NewsItems findByJobid(@Param("jobId") int jobid);
*/
    @SelectProvider(type = NewsSqlProvider.class, method = "findAllByProvider")
    List<NewsItems> findByProvider(NewsSearchable newsSearchable);

    @Delete("DELETE FROM jobBoard_DB.news WHERE NEWSID = #{newsid}")
    void delete(@Param("newsid") int newsid);

}
