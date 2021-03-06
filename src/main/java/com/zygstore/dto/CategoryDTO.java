package com.zygstore.dto;

import java.util.ArrayList;
import java.util.List;

public class CategoryDTO {
    private Long id;
    private Long parentId;
    private String text;
    private String link;
    private List<CategoryDTO> childsList;
    private List<String> breadCrumbs;//TODO it is Frontend related in category. Should it be here?
    private String linkToPicture;

    public CategoryDTO(Long id, Long parentId, String text, String linkToPicture) {
        this.id = id;
        this.parentId = parentId;
        this.text = text;
        this.linkToPicture = linkToPicture;
        this.childsList = new ArrayList<>();
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
