package com.zygstore.dto;

import java.util.List;

public interface MenuItemDTO {
    void setId (Long ID); //Long ew duzy int Int
    void setParentId (Long ParentID);
    void setText(String text);
    void setLink (String link);
    void setChildsList(List<MenuProductsDTO> list);

    Long getID();
    Long getParentId();
    String getText();
    String getLink();
    List getChildsList();
}
