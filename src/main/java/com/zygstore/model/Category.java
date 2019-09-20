package com.zygstore.model;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class Category {
    private long id;
    private long parentId;
    private String text;
    private String link;
    private String linkToPicture;


    public Category(long id, long parentId, String text, String link, String linkToPicture) {
        this.id = id;
        this.parentId = parentId;
        this.text = text;
        this.link = link;
        this.linkToPicture = linkToPicture;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLinkToPicture() {
        return linkToPicture;
    }

    public void setLinkToPicture(String linkToPicture) {
        this.linkToPicture = linkToPicture;
    }
}
