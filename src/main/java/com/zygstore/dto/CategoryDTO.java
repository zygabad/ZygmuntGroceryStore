package com.zygstore.dto;

import java.util.List;

public interface CategoryDTO {  //TODO do I need interface here? - Wywalic
    void setId (String ID); //TODO Long ew duzy int Int
    void setParentId (String ParentID);
    void setText(String text);
    void setLink (String link);
    void setChildsList(List<MenuProductsDTO> list);
    void setBreadCrumbs(List<String> breadCrumbs);

    String getId();
    String getParentId();
    String getText();
    String getLink();
    List getChildsList();
    List getBreadCrumbs();
}
