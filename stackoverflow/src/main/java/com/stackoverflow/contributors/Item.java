
package com.stackoverflow.contributors;

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
    "owner",
    "is_accepted",
    "score",
    "last_activity_date",
    "last_edit_date",
    "creation_date",
    "answer_id",
    "question_id"
})
public class Item {

    @JsonProperty("owner")
    private Owner owner;
    @JsonProperty("is_accepted")
    private Boolean isAccepted;
    @JsonProperty("score")
    private Integer score;
    @JsonProperty("last_activity_date")
    private Integer lastActivityDate;
    @JsonProperty("last_edit_date")
    private Integer lastEditDate;
    @JsonProperty("creation_date")
    private Integer creationDate;
    @JsonProperty("answer_id")
    private Integer answerId;
    @JsonProperty("question_id")
    private Integer questionId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("owner")
    public Owner getOwner() {
        return owner;
    }

    @JsonProperty("owner")
    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @JsonProperty("is_accepted")
    public Boolean getIsAccepted() {
        return isAccepted;
    }

    @JsonProperty("is_accepted")
    public void setIsAccepted(Boolean isAccepted) {
        this.isAccepted = isAccepted;
    }

    @JsonProperty("score")
    public Integer getScore() {
        return score;
    }

    @JsonProperty("score")
    public void setScore(Integer score) {
        this.score = score;
    }

    @JsonProperty("last_activity_date")
    public Integer getLastActivityDate() {
        return lastActivityDate;
    }

    @JsonProperty("last_activity_date")
    public void setLastActivityDate(Integer lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    @JsonProperty("last_edit_date")
    public Integer getLastEditDate() {
        return lastEditDate;
    }

    @JsonProperty("last_edit_date")
    public void setLastEditDate(Integer lastEditDate) {
        this.lastEditDate = lastEditDate;
    }

    @JsonProperty("creation_date")
    public Integer getCreationDate() {
        return creationDate;
    }

    @JsonProperty("creation_date")
    public void setCreationDate(Integer creationDate) {
        this.creationDate = creationDate;
    }

    @JsonProperty("answer_id")
    public Integer getAnswerId() {
        return answerId;
    }

    @JsonProperty("answer_id")
    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    @JsonProperty("question_id")
    public Integer getQuestionId() {
        return questionId;
    }

    @JsonProperty("question_id")
    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
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
