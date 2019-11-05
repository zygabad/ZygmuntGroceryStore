package com.zygstore.model;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class Category {
    private Long id;
    private Long parentId;
    private String text;
    private String linkToPicture;

    public Category(Long id, Long parentId, String text, String linkToPicture) {
        this.id = id;
        this.parentId = parentId;
        this.text = text;
        this.linkToPicture = linkToPicture;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLinkToPicture() {
        return linkToPicture;
    }

    public void setLinkToPicture(String linkToPicture) {
        this.linkToPicture = linkToPicture;
    }
}
