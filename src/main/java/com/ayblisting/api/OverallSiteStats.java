package com.ayblisting.api;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


/**
 * Model for overall site statistics.
 *
 * @author nekokatt
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class OverallSiteStats extends Response {
    /**
     * Number of bots being tracked by the API.
     */
    @JsonProperty(value = "bots")
    private long botCount;

    /**
     * Number of pending approvals.
     */
    @JsonProperty(value = "pending_approvals")
    private long pendingApprovalsCount;

    /**
     * Number of unread reports.
     */
    @JsonProperty(value = "unread_reports")
    private long unreadReportsCount;

    // Internal response details.
    @Getter(AccessLevel.PACKAGE)
    @JsonProperty("success")
    private boolean success;

    @Getter(AccessLevel.PACKAGE)
    @JsonProperty("note")
    private String note;
}
