package com.zygstore.dto;

import java.util.List;

public class MenuProductsDTO implements CategoryDTO {
    private String id;//TODO change to Long
    private String parentId;
    private String text;
    private String link;
    private List<MenuProductsDTO> childsList;
    private List<String> breadCrumbs;//TODO it is Frontend related in category. Should it be here?
    private String linkToPicture;

    @Override
    public void setChildsList(List<MenuProductsDTO> childsList) {
        this.childsList = childsList;
    }

    @Override
    public void setBreadCrumbs(List<String> breadCrumbs) {
        this.breadCrumbs = breadCrumbs;
    }

    public MenuProductsDTO getParent() {
        return parent;
    }

    public void setParent(MenuProductsDTO parent) {
        this.parent = parent;
    }

    private MenuProductsDTO parent;

    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getParentId() {
        return parentId;
    }

    @Override
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getLink() {
        return link;
    }

    @Override
    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public List<MenuProductsDTO> getChildsList() {
        return childsList;
    }

    @Override
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
