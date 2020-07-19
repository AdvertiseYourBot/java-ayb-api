package com.ayblisting.api;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Bot {
    public Boolean success;
    public String note;

    public String clientID;
    public String ownerID;
    public String username;
    public String avatarURL;
    public long votes;
    public long categoryID;
    public Boolean approved;
    public Boolean premium;
    public Boolean certified;
    public String prefix;
    public String permissions;
    public String library;
    public String briefDesc;
    public String longDesc;
    public String website;
    public String githubURL;
    public String supportServerInvite;

    public Bot (JSONObject obj) {
        this.success = (Boolean) obj.get("success");

        if (this.success) {
            this.clientID = (String) obj.get("clientid");
            this.ownerID = (String) obj.get("ownerid");
            this.username = (String) obj.get("botname");
            this.avatarURL = (String) obj.get("botavatar");
            this.votes = (long) obj.get("score");
            this.categoryID = (long) obj.get("category");
            this.approved = (Boolean) obj.get("approved");
            this.premium = (Boolean) obj.get("premium");
            this.certified = (Boolean) obj.get("certified");
            this.prefix = (String) obj.get("prefix");
            this.permissions = (String) obj.get("permissions");
            this.library = (String) obj.get("library");
            this.briefDesc = (String) obj.get("brief");
            this.longDesc = (String) obj.get("description");
            this.website = (String) obj.get("websiteurl");
            this.githubURL = (String) obj.get("github");
            this.supportServerInvite = (String) obj.get("supportservercode");
        } else {
            this.note = (String) obj.get("note");
        }
    }

    public Category fetchCategory() throws IOException, ParseException, RuntimeException {
        String id = String.valueOf(this.categoryID);
        if (id.length() < 1) throw new RuntimeException("Cannot fetch category of invalid bot (bot has no categoryID property");

        return Client.fetchCategory(id);
    }
}
