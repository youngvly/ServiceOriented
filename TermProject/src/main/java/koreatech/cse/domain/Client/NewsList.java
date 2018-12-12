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
        "title",
        "originallink",
        "description",
        "pubDate",
        "newsid",
        "jobname"
})
public class NewsList {

    @JsonProperty("title")
    private String title;
    @JsonProperty("originallink")
    private String originallink;
    @JsonProperty("description")
    private String description;
    @JsonProperty("pubDate")
    private String pubDate;
    @JsonProperty("newsid")
    private Integer newsid;
    @JsonProperty("jobname")
    private String jobname;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("originallink")
    public String getOriginallink() {
        return originallink;
    }

    @JsonProperty("originallink")
    public void setOriginallink(String originallink) {
        this.originallink = originallink;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("pubDate")
    public String getPubDate() {
        return pubDate;
    }

    @JsonProperty("pubDate")
    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    @JsonProperty("newsid")
    public Integer getNewsid() {
        return newsid;
    }

    @JsonProperty("newsid")
    public void setNewsid(Integer newsid) {
        this.newsid = newsid;
    }

    @JsonProperty("jobname")
    public String getJobname() {
        return jobname;
    }

    @JsonProperty("jobname")
    public void setJobname(String jobname) {
        this.jobname = jobname;
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
        return "NewsList{" +
                "title='" + title + '\'' +
                ", originallink='" + originallink + '\'' +
                ", description='" + description + '\'' +
                ", pubDate='" + pubDate + '\'' +
                ", newsid=" + newsid +
                ", jobname='" + jobname + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}