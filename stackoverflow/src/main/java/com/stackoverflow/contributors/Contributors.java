
package com.stackoverflow.contributors;

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
    "items",
    "has_more",
    "quota_max",
    "quota_remaining"
})
public class Contributors {

    @JsonProperty("items")
    private List<Item> items = null;
    @JsonProperty("has_more")
    private Boolean hasMore;
    @JsonProperty("quota_max")
    private Integer quotaMax;
    @JsonProperty("quota_remaining")
    private Integer quotaRemaining;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("items")
    public List<Item> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(List<Item> items) {
        this.items = items;
    }

    @JsonProperty("has_more")
    public Boolean getHasMore() {
        return hasMore;
    }

    @JsonProperty("has_more")
    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }

    @JsonProperty("quota_max")
    public Integer getQuotaMax() {
        return quotaMax;
    }

    @JsonProperty("quota_max")
    public void setQuotaMax(Integer quotaMax) {
        this.quotaMax = quotaMax;
    }

    @JsonProperty("quota_remaining")
    public Integer getQuotaRemaining() {
        return quotaRemaining;
    }

    @JsonProperty("quota_remaining")
    public void setQuotaRemaining(Integer quotaRemaining) {
        this.quotaRemaining = quotaRemaining;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
