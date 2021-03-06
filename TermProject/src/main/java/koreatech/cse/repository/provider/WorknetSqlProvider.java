package koreatech.cse.repository.provider;

import koreatech.cse.domain.news.NewsSearchable;
import koreatech.cse.domain.worknet.WorkNetSearchable;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class WorknetSqlProvider {

    public String findAllByProvider(final WorkNetSearchable searchable) {
        return new SQL() {
            {
                SELECT("*");
                FROM("jobBoard_DB.worknet");
//                FROM( " SELECT Cast(sdate as unsigned)as sdateInt , Cast(edate as unsigned)as edateInt , title,name,type,logo,url "
//                        +"FROM jobBoard_DB.worknet )");
                //이름검색
                if(searchable.getName() != null) {
                    WHERE("Name LIKE '%' #{name} '%'");
                    if(searchable.getTitle() != null) {
                        AND();
                        WHERE("TITLE = #{title}");
                    }
                    //날짜검색
                    if(searchable.getSdate() >0) {
                        //작으면 더 오래된거
                        AND();
                        WHERE("sdate >= #{sdate}" );
                        if(searchable.getEdate()>0){
                            AND();
                            WHERE ("edate <= #{edate}");
                        }
                    }
                    //type검색도 있을경우
                    if (searchable.getType() != null){
                        AND();
                        WHERE("TYPE LIKE '%' #{type} '%'");
                    }
                }
                //날짜검색
                else if(searchable.getSdate() >0) {
                    //작으면 더 오래된거
                    WHERE("sdate >= #{sdate}" );
                    if(searchable.getEdate()>0){
                        AND();
                        WHERE ("edate <= #{edate}");
                    }
                    //type검색도 있을경우
                    if (searchable.getType() != null){
                        AND();
                        WHERE("TYPE LIKE '%' #{type} '%'");
                    }
                }
                //타입(만)검색
                else if (searchable.getType() != null){
                    WHERE("TYPE LIKE '%' #{type} '%'");
                }

            }
        }.toString();
    }
}
