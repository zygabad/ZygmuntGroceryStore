package com.zygstore.dto;

import java.util.List;

public class MenuProductsDTO implements MenuItemDTO {
    private Long Id;
    private Long ParentId;
    private String text;
    private String link;
    private List<MenuProductsDTO> childsList;

    public Long getID() {
        return Id;
    }

    @Override
    public void setId(Long id) {
        Id = id;
    }

    @Override
    public Long getParentId() {
        return ParentId;
    }

    @Override
    public void setParentId(Long parentId) {
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
    public List<MenuProductsDTO> getChildsList() {
        return childsList;
    }

    @Override
    public void setChildsList(List<MenuProductsDTO> childsList) {
        this.childsList = childsList;
    }
}
