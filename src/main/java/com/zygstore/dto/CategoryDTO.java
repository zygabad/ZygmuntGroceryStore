package com.zygstore.dto;

import java.util.List;

public class CategoryDTO {
    private String id;//TODO change to Long
    private String parentId;
    private String text;
    private String link;
    private List<CategoryDTO> childsList;
    private List<String> breadCrumbs;//TODO it is Frontend related in category. Should it be here?
    private String linkToPicture;

    public CategoryDTO() { //TODO wywalic - zrobiony zeby test validatora przechodzil
    }

    public CategoryDTO(String id, String parentId, String text, String link, String linkToPicture) {
        this.id = id;
        this.parentId = parentId;
        this.text = text;
        this.link = link;
        this.linkToPicture = linkToPicture;
    }

    public void setChildsList(List<CategoryDTO> childsList) {
        this.childsList = childsList;
    }

    public void setBreadCrumbs(List<String> breadCrumbs) {
        this.breadCrumbs = breadCrumbs;
    }

    public CategoryDTO getParent() {
        return parent;
    }

    public void setParent(CategoryDTO parent) {
        this.parent = parent;
    }

    private CategoryDTO parent;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
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

    public List<CategoryDTO> getChildsList() {
        return childsList;
    }

    public List getBreadCrumbs() {
        return breadCrumbs;
    }

    public String getLinkToPicture() {
        return linkToPicture;
    }

    public void setLinkToPicture(String linkToPicture) {
        this.linkToPicture = linkToPicture;
    }
}
