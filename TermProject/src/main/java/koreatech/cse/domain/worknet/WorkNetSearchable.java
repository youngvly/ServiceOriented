package koreatech.cse.domain.worknet;

public class WorkNetSearchable {

    public int getJobid() {
        return jobid;
    }

    public void setJobid(int jobid) {
        this.jobid = jobid;
    }

    private int jobid;
    private String type;     //type

    private int edate;
    private int sdate;

    private String name;       //name

    private String title;  //title

    private String logo;
    private String url;

//    private String orderParam;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getEdate() {
        return edate;
    }

    public void setEdate(int edate) {
        this.edate = edate;
    }

    public int getSdate() {
        return sdate;
    }

    public void setSdate(int sdate) {
        this.sdate = sdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

//    public String getOrderParam() {
//        return orderParam;
//    }

//    public void setOrderParam(String orderParam) {
//        this.orderParam = orderParam;
//    }

    @Override
    public String toString() {
        return "WorkNetSearchable{" +
                "jobid=" + jobid +
                ", type='" + type + '\'' +
                ", edate='" + edate + '\'' +
                ", sdate='" + sdate + '\'' +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", logo='" + logo + '\'' +
                ", url='" + url + '\'' +
//                ", orderParam='" + orderParam + '\'' +
                '}';
    }
}
