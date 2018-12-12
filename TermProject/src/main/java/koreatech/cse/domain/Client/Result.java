package koreatech.cse.domain.Client;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "employList",
        "newsList"
})
public class Result {

    @JsonProperty("employList")
    private List<EmployList> employList = null;
    @JsonProperty("newsList")
    private List<NewsList> newsList = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("employList")
    public List<EmployList> getEmployList() {
        return employList;
    }

    @JsonProperty("employList")
    public void setEmployList(List<EmployList> employList) {
        this.employList = employList;
    }

    @JsonProperty("newsList")
    public List<NewsList> getNewsList() {
        return newsList;
    }

    @JsonProperty("newsList")
    public void setNewsList(List<NewsList> newsList) {
        this.newsList = newsList;
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
        return "Result{" +
                "employList=" + employList +
                ", newsList=" + newsList +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}