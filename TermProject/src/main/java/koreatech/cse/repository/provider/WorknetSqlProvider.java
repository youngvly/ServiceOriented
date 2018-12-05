package koreatech.cse.repository.provider;

import koreatech.cse.domain.news.NewsSearchable;
import org.apache.ibatis.jdbc.SQL;

public class NewsSqlProvider {

    public String findAllByProvider(final NewsSearchable searchable) {
        return new SQL() {
            {
                SELECT("*");
                FROM("jobBoard_DB.news");
                if(searchable.getJobid() >0) {
                    WHERE("JOBID= #{jobid}");
                    if(searchable.getNewsid() >0) {
                        OR();
                        WHERE("NEWSID = #{newsid}");
                    }
                }
                if(searchable.getOriginalLink() != null) {
                    WHERE("ORIGINALLINK = #{originalLink}");
                }
                if(searchable.getOrderParam() != null) {

                    ORDER_BY(searchable.getOrderParam() + " DESC");
                }
            }
        }.toString();
    }
}
