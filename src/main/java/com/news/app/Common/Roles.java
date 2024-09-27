package com.news.app.Common;

public enum Roles {
    READERS("Readers", "Can view news articles, subscribe to content, and access limited features without login for public news"),
    JOURNALIST("Journalist", "Can view news articles, subscribe to content, and access limited features without login for public news"),
    PUBLISHER("Publisher", "Can review and publish articles, moderate content, and manage journalist submissions.");

    private String name;
    private String description;

    private Roles( String name, String description ){
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
