package com.zygstore.service;

import com.sun.org.apache.xerces.internal.xs.StringList;
import com.zygstore.dto.NewMenuProductsDTO;
import com.zygstore.utils.ReadFile;

import java.util.LinkedList;
import java.util.List;

public class NewMenuProductsService {

    NewMenuProductsDTO newProductsMenu;
    NewMenuProductsDTO newMenuProductsItems;
    NewMenuProductsDTO newMenuProductsVerticalDTO_1;
    List<NewMenuProductsDTO> newMenuProductsItemsList;

    public NewMenuProductsDTO getNewProductsMenu(String file) {
        NewMenuProductsDTO newMenuProductsDTO = new NewMenuProductsDTO();
        List<NewMenuProductsDTO> newMenuProductsItemsList = new LinkedList<>();
        newMenuProductsItemsList = getNewMenuProductsItemsList(file);
        newMenuProductsDTO.setChildsList(newMenuProductsItemsList);
        newMenuProductsDTO.setParentId(0);
        newMenuProductsDTO.setText("Menu główne");
        newMenuProductsDTO.setId(0);
        return newMenuProductsDTO;
    }

    public NewMenuProductsDTO getNewMenuProductsVerticalDTO_1(String file) {
        NewMenuProductsDTO newMenuProductsVerticalDTO_1 = new NewMenuProductsDTO();
        List<NewMenuProductsDTO> newMenuProductsItemsList = new LinkedList<>();
        newMenuProductsItemsList = getNewMenuProductsItemsList(file);
        newMenuProductsVerticalDTO_1.setChildsList(newMenuProductsItemsList);
        newMenuProductsVerticalDTO_1.setParentId(1);
        newMenuProductsVerticalDTO_1.setText("Test");
        newMenuProductsVerticalDTO_1.setId(1);
        return newMenuProductsVerticalDTO_1;
    }

    public List<NewMenuProductsDTO> getNewMenuProductsItemsList(String file) {
        ReadFile readFile = new ReadFile(file);
        List<String> menuItemNamesList = new LinkedList<>();
        List<NewMenuProductsDTO> newMenuProductsItemsList = new LinkedList<>();
        menuItemNamesList = readFile.getList();

        for (int i = 0; i < menuItemNamesList.size(); i++) {
            NewMenuProductsDTO newProductsMenu = new NewMenuProductsDTO();
            newProductsMenu.setId(i);
            newProductsMenu.setText(menuItemNamesList.get(i));
//            newProductsMenu.setLink();
            newProductsMenu.setParentId(0);
//            newProductsMenu.setChildsList();
            newMenuProductsItemsList.add(newProductsMenu);
        }
        return newMenuProductsItemsList;
    }

}
