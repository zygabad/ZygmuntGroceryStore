package com.zygstore.dto;

import java.util.List;

public class NewMenuProductsDTO implements NewMenuItemDTO {
    private int Id;
    private int ParentId;
    private String text;
    private String link;
    private List<NewMenuProductsDTO> childsList;

    public int getID() {
        return Id;
    }

    @Override
    public void setId(int id) {
        Id = id;
    }

    @Override
    public int getParentId() {
        return ParentId;
    }

    @Override
    public void setParentId(int parentId) {
        ParentId = parentId;
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
    public List<NewMenuProductsDTO> getChildsList() {
        return childsList;
    }

    @Override
    public void setChildsList(List<NewMenuProductsDTO> childsList) {
        this.childsList = childsList;
    }
}
