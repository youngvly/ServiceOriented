package koreatech.cse.repository.provider;

import koreatech.cse.domain.news.NewsSearchable;
import koreatech.cse.domain.worknet.WorkNetSearchable;
import org.apache.ibatis.jdbc.SQL;

public class WorknetSqlProvider {

    public String findAllByProvider(final WorkNetSearchable searchable) {
        return new SQL() {
            {
                SELECT("*");
                FROM("jobBoard_DB.worknet");
                if(searchable.getName() != null) {
                    WHERE("Name= #{name}");
                    if(searchable.getTitle() != null) {
                        OR();
                        WHERE("TITLE = #{title}");
                    }
                }
                else if(searchable.getStartDate() != null) {
                    WHERE("SDATE = #{startDate}");
                    if(searchable.getEndDate()!= null){
                        OR();
                        WHERE ("EDATE = #{endDate}");
                    }
                }
                if(searchable.getOrderParam() != null) {

                    ORDER_BY(searchable.getOrderParam() + " DESC");
                }
            }
        }.toString();
    }
}
