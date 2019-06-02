package com.zygstore.dto;

import java.util.List;

public interface NewMenuItemDTO {
    void setId (int ID);
    void setParentId (int ParentID);
    void setText(String text);
    void setLink (String link);
    void setChildsList(List<NewMenuProductsDTO> list);

    int getID();
    int getParentId();
    String getText();
    String getLink();
    List getChildsList();
}
