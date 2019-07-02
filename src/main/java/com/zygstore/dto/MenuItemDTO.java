package com.zygstore.dto;

import java.util.List;

public interface MenuItemDTO {
    void setId (String ID); //Long ew duzy int Int
    void setParentId (String ParentID);
    void setText(String text);
    void setLink (String link);
    void setChildsList(List<MenuProductsDTO> list);
    void setBreadCrumbs(List<String> breadCrumbs);

    String getID();
    String getParentId();
    String getText();
    String getLink();
    List getChildsList();
    List getBreadCrumbs();
}
