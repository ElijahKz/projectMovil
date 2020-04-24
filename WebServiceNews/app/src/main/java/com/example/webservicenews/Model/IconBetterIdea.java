package com.example.webservicenews.Model;

import java.util.List;

/* Icon betterIdea is a service which get the icon from a img coming from url*/
public class IconBetterIdea {
    private String url;
    private List<Icon> icons;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Icon> getIcons() {
        return icons;
    }

    public void setIcons(List<Icon> icons) {
        this.icons = icons;
    }
}
