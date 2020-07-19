package com.ayblisting.api;

import org.json.simple.JSONObject;

public class Category {
    public Boolean success;
    public String note;
    public String id;
    public String name;
    public String slug;

    public Category(JSONObject obj) {
        this.success = (Boolean) obj.get("success");

        if (this.success) {
            this.id = (String) obj.get("id");
            this.name = (String) obj.get("name");
            this.slug = (String) obj.get("slug");
        } else {
            this.note = (String) obj.get("note");
        }
    }
}
