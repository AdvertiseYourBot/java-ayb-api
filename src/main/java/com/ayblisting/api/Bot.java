package com.ayblisting.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


/**
 * Model representing details of a bot.
 *
 * @author nekokatt
 */
@EqualsAndHashCode(of = {"clientId"}, callSuper = false)
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
public final class Bot extends Response {

    /**
     * Client ID.
     */
    @JsonProperty("clientid")
    private String clientId;

    /**
     * Owner ID.
     */
    @JsonProperty("ownerid")
    private String ownerId;

    /**
     * Owner username.
     */
    @JsonProperty("botname")
    private String botName;

    /**
     * Avatar for the bot.
     */
    @JsonProperty("botavatar")
    private String botAvatarUrl;

    /**
     * Score.
     */
    @JsonProperty("score")
    private long score;


    /**
     * Vote count.
     */
    @JsonProperty("votes")
    private long voteCount;

    /**
     * ID of the category that this bot is part of.
     */
    @JsonProperty("category")
    private long categoryId;

    /**
     * <code>true</code> if the bot is approved, <code>false</code> otherwise.
     */
    @JsonProperty("approved")
    private boolean approved;

    /**
     * <code>true</code> if the bot is premium, <code>false</code> otherwise.
     */
    @JsonProperty("premium")
    private boolean premium;

    /**
     * <code>true</code> if the bot is certified, <code>false</code> otherwise.
     */
    @JsonProperty("certified")
    private boolean certified;

    /**
     * Bot command prefix used to invoke it.
     */
    @JsonProperty("prefix")
    private String botPrefix;

    /**
     * Permissions that this bot requires to use.
     */
    @JsonProperty("permissions")
    private String botPermissions;

    /**
     * Library that this bot is built with.
     */
    @JsonProperty("library")
    private String botLibrary;

    /**
     * Brief description of this bot.
     */
    @JsonProperty("brief")
    private String briefDescription;

    /**
     * Long description of this bot.
     */
    @JsonProperty("description")
    @ToString.Exclude
    private String longDescription;

    /**
     * Website for this bot.
     */
    @JsonProperty("website")
    private String websiteUrl;

    /**
     * GitHub repository for this bot.
     */
    @JsonProperty("github")
    private String githubRepoUrl;

    /**
     * Discord server invite slug for the bot's support server.
     */
    @JsonProperty("supportservercode")
    private String supportServerInviteCode;

    // Internal response details.
    @Getter(AccessLevel.PACKAGE)
    @JsonProperty("success")
    private boolean success;

    @Getter(AccessLevel.PACKAGE)
    @JsonProperty("note")
    private String note;
}
