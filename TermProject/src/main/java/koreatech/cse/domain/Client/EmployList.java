package koreatech.cse.domain.Client;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "jobid",
        "type",
        "edate",
        "sdate",
        "name",
        "title",
        "logo",
        "url"
})
public class EmployList {

    @JsonProperty("jobid")
    private Integer jobid;
    @JsonProperty("type")
    private String type;
    @JsonProperty("edate")
    private Integer edate;
    @JsonProperty("sdate")
    private Integer sdate;
    @JsonProperty("name")
    private String name;
    @JsonProperty("title")
    private String title;
    @JsonProperty("logo")
    private String logo;
    @JsonProperty("url")
    private String url;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("jobid")
    public Integer getJobid() {
        return jobid;
    }

    @JsonProperty("jobid")
    public void setJobid(Integer jobid) {
        this.jobid = jobid;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("edate")
    public Integer getEdate() {
        return edate;
    }

    @JsonProperty("edate")
    public void setEdate(Integer edate) {
        this.edate = edate;
    }

    @JsonProperty("sdate")
    public Integer getSdate() {
        return sdate;
    }

    @JsonProperty("sdate")
    public void setSdate(Integer sdate) {
        this.sdate = sdate;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("logo")
    public String getLogo() {
        return logo;
    }

    @JsonProperty("logo")
    public void setLogo(String logo) {
        this.logo = logo;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "EmployList{" +
                "jobid=" + jobid +
                ", type='" + type + '\'' +
                ", edate=" + edate +
                ", sdate=" + sdate +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", logo='" + logo + '\'' +
                ", url='" + url + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}