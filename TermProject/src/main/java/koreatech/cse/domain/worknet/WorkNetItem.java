package koreatech.cse.domain.worknet;

public class WorkNetItem {

    public int getJobid() {
        return jobid;
    }

    public void setJobid(int jobid) {
        this.jobid = jobid;
    }

    private int jobid;
    private String total;

    private String empWantedTypeNm;

    private String empWantedHomepgDetail;

    private String empWantedEndt;

    private String empBusiNm;

    private String coClcdNm;

    private String regLogImgNm;

    private String empSeqno;

    private String empWantedTitle;

    private String display;

    private String startPage;

    private String empWantedStdt;

    public String getTotal ()
    {
        return total;
    }

    public void setTotal (String total)
    {
        this.total = total;
    }

    public String getEmpWantedTypeNm ()
    {
        return empWantedTypeNm;
    }

    public void setEmpWantedTypeNm (String empWantedTypeNm)
    {
        this.empWantedTypeNm = empWantedTypeNm;
    }

    public String getEmpWantedHomepgDetail ()
    {
        return empWantedHomepgDetail;
    }

    public void setEmpWantedHomepgDetail (String empWantedHomepgDetail)
    {
        this.empWantedHomepgDetail = empWantedHomepgDetail;
    }

    public String getEmpWantedEndt ()
    {
        return empWantedEndt;
    }

    public void setEmpWantedEndt (String empWantedEndt)
    {
        this.empWantedEndt = empWantedEndt;
    }

    public String getEmpBusiNm ()
    {
        return empBusiNm;
    }

    public void setEmpBusiNm (String empBusiNm)
    {
        this.empBusiNm = empBusiNm;
    }

    public String getCoClcdNm ()
    {
        return coClcdNm;
    }

    public void setCoClcdNm (String coClcdNm)
    {
        this.coClcdNm = coClcdNm;
    }

    public String getRegLogImgNm ()
    {
        return regLogImgNm;
    }

    public void setRegLogImgNm (String regLogImgNm)
    {
        this.regLogImgNm = regLogImgNm;
    }

    public String getEmpSeqno ()
    {
        return empSeqno;
    }

    public void setEmpSeqno (String empSeqno)
    {
        this.empSeqno = empSeqno;
    }

    public String getEmpWantedTitle ()
    {
        return empWantedTitle;
    }

    public void setEmpWantedTitle (String empWantedTitle)
    {
        this.empWantedTitle = empWantedTitle;
    }

    public String getDisplay ()
    {
        return display;
    }

    public void setDisplay (String display)
    {
        this.display = display;
    }

    public String getStartPage ()
    {
        return startPage;
    }

    public void setStartPage (String startPage)
    {
        this.startPage = startPage;
    }

    public String getEmpWantedStdt ()
    {
        return empWantedStdt;
    }

    public void setEmpWantedStdt (String empWantedStdt)
    {
        this.empWantedStdt = empWantedStdt;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [total = "+total+", empWantedTypeNm = "+empWantedTypeNm+", empWantedHomepgDetail = "+empWantedHomepgDetail+", empWantedEndt = "+empWantedEndt+", empBusiNm = "+empBusiNm+", coClcdNm = "+coClcdNm+", regLogImgNm = "+regLogImgNm+", empSeqno = "+empSeqno+", empWantedTitle = "+empWantedTitle+", display = "+display+", startPage = "+startPage+", empWantedStdt = "+empWantedStdt+"]";
    }
}
