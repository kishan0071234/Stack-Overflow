
package com.stackoverflow.pojo;

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
    "tags",
    "owner",
    "is_answered",
    "view_count",
    "answer_count",
    "score",
    "last_activity_date",
    "creation_date",
    "last_edit_date",
    "question_id",
    "link",
    "title",
    "closed_date",
    "closed_reason",
    "accepted_answer_id"
})
public class Item {

    @JsonProperty("tags")
    private List<String> tags = null;
    @JsonProperty("owner")
    private Owner owner;
    @JsonProperty("is_answered")
    private Boolean isAnswered;
    @JsonProperty("view_count")
    private Integer viewCount;
    @JsonProperty("answer_count")
    private Integer answerCount;
    @JsonProperty("score")
    private Integer score;
    @JsonProperty("last_activity_date")
    private Integer lastActivityDate;
    @JsonProperty("creation_date")
    private Integer creationDate;
    @JsonProperty("last_edit_date")
    private Integer lastEditDate;
    @JsonProperty("question_id")
    private Integer questionId;
    @JsonProperty("link")
    private String link;
    @JsonProperty("title")
    private String title;
    @JsonProperty("closed_date")
    private Integer closedDate;
    @JsonProperty("closed_reason")
    private String closedReason;
    @JsonProperty("accepted_answer_id")
    private Integer acceptedAnswerId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("tags")
    public List<String> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @JsonProperty("owner")
    public Owner getOwner() {
        return owner;
    }

    @JsonProperty("owner")
    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @JsonProperty("is_answered")
    public Boolean getIsAnswered() {
        return isAnswered;
    }

    @JsonProperty("is_answered")
    public void setIsAnswered(Boolean isAnswered) {
        this.isAnswered = isAnswered;
    }

    @JsonProperty("view_count")
    public Integer getViewCount() {
        return viewCount;
    }

    @JsonProperty("view_count")
    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    @JsonProperty("answer_count")
    public Integer getAnswerCount() {
        return answerCount;
    }

    @JsonProperty("answer_count")
    public void setAnswerCount(Integer answerCount) {
        this.answerCount = answerCount;
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

    @JsonProperty("creation_date")
    public Integer getCreationDate() {
        return creationDate;
    }

    @JsonProperty("creation_date")
    public void setCreationDate(Integer creationDate) {
        this.creationDate = creationDate;
    }

    @JsonProperty("last_edit_date")
    public Integer getLastEditDate() {
        return lastEditDate;
    }

    @JsonProperty("last_edit_date")
    public void setLastEditDate(Integer lastEditDate) {
        this.lastEditDate = lastEditDate;
    }

    @JsonProperty("question_id")
    public Integer getQuestionId() {
        return questionId;
    }

    @JsonProperty("question_id")
    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    @JsonProperty("link")
    public String getLink() {
        return link;
    }

    @JsonProperty("link")
    public void setLink(String link) {
        this.link = link;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("closed_date")
    public Integer getClosedDate() {
        return closedDate;
    }

    @JsonProperty("closed_date")
    public void setClosedDate(Integer closedDate) {
        this.closedDate = closedDate;
    }

    @JsonProperty("closed_reason")
    public String getClosedReason() {
        return closedReason;
    }

    @JsonProperty("closed_reason")
    public void setClosedReason(String closedReason) {
        this.closedReason = closedReason;
    }

    @JsonProperty("accepted_answer_id")
    public Integer getAcceptedAnswerId() {
        return acceptedAnswerId;
    }

    @JsonProperty("accepted_answer_id")
    public void setAcceptedAnswerId(Integer acceptedAnswerId) {
        this.acceptedAnswerId = acceptedAnswerId;
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
