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

    private String endDate;           //enddate

    private String name;       //name

    private String title;  //title

    private String startDate;           //startdate

    private String orderParam;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getOrderParam() {
        return orderParam;
    }

    public void setOrderParam(String orderParam) {
        this.orderParam = orderParam;
    }

    @Override
    public String toString() {
        return "WorkNetSearchable{" +
                "jobid=" + jobid +
                ", type='" + type + '\'' +
                ", endDate='" + endDate + '\'' +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", startDate='" + startDate + '\'' +
                ", orderParam='" + orderParam + '\'' +
                '}';
    }
}
