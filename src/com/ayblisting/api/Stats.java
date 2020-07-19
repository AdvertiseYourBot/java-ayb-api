package com.ayblisting.api;

import org.json.simple.JSONObject;

public class Stats {
    public long bots;
    public long pendingApprovals;
    public long unreadReports;

    public Stats (JSONObject obj) {
        if (obj.get("pending_approvals") != null) this.pendingApprovals = (long) obj.get("pending_approvals");
        else this.pendingApprovals = 0;

        this.bots = (long) obj.get("bots");
        this.unreadReports = (long) obj.get("unread_reports");
    }
}
