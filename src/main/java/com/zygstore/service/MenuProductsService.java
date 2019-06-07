package com.zygstore.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


import com.zygstore.dto.MenuItemDTO;
import com.zygstore.dto.MenuProductsDTO;
import com.zygstore.utils.ReadCSVFileWithAllCategories;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class MenuProductsService {
    //@Autowired
    private static
    MenuProductsDTO menuProductsDTO;
    List<MenuProductsDTO> newMenuProductsItemsList;
    private ArrayList<String> linesFromFile = new ArrayList<>();

    public ArrayList<MenuProductsDTO> getCategories(String filePath) {
        ReadCSVFileWithAllCategories readCSVFileWithAllCategories = new ReadCSVFileWithAllCategories(filePath);
        linesFromFile = readCSVFileWithAllCategories.getList();
        ArrayList<MenuProductsDTO> listOfAllMenuItemsDTO = new ArrayList<>();
        ArrayList<MenuProductsDTO> listOfRootMenuItemsDTO = new ArrayList<>();
        listOfAllMenuItemsDTO = getAllMenuItemsDTO(linesFromFile);
        listOfRootMenuItemsDTO = getSelectedMenuItemsDTO(listOfAllMenuItemsDTO,"0");

        //TODO ustaw liste rootelementow i przy ustawianiu ich childow odwolaj sie do metody getselectedmenuitems
        //warunek stopu bedzie taki, ze nie ma elementow, ktore maja dane parentid


        //a co jesli taa liste linii zamienie na liste obiektow
        // a potem bede sobie z tej listy robil krotsze listy
        //to bedzie lista wszystkich menuitemow jakie wystepuja


        return listOfRootMenuItemsDTO;
    }

    private ArrayList<MenuProductsDTO> getSelectedMenuItemsDTO(ArrayList<MenuProductsDTO> listOfMenuItems, String parentId){
        ArrayList<MenuProductsDTO> listOfSelectedMenuItems = new ArrayList<>();
        for (int i=0; i< listOfMenuItems.size(); i++){
            MenuProductsDTO currentMenuItemDTO = listOfMenuItems.get(i);
            if (currentMenuItemDTO.getParentId().equals(Long.parseLong(parentId))){
                int j = 0;
                String currentItemID = Long.toString(currentMenuItemDTO.getID());
                //set childs for this current object
                List<MenuProductsDTO> childsList = getSelectedMenuItemsDTO(listOfMenuItems, currentItemID);
                currentMenuItemDTO.setChildsList(childsList);
//                for (int x =0 ; x < childsList.size(); x++){
//                    MenuProductsDTO currentMenuItemChildListDTO = childsList.get(j);
//                    String currentMenuChildItemId = Long.toString(childsList.get(j).getID());
//                    List<MenuProductsDTO> childsChildList = getSelectedMenuItemsDTO((ArrayList<MenuProductsDTO>) childsList, currentMenuChildItemId);
//                    currentMenuItemChildListDTO.setChildsList(childsChildList);
//                }
                listOfSelectedMenuItems.add(j,currentMenuItemDTO);
                j++;
            }
        }

        return listOfSelectedMenuItems;
    }

    private ArrayList<MenuProductsDTO> getAllMenuItemsDTO(ArrayList<String> linesFromFile) {
        ArrayList<MenuProductsDTO> menuItemsDTOList = new ArrayList<>();

        for (int i = 0; i < linesFromFile.size(); i++) {
            String line = linesFromFile.get(i);
            String[] values = line.split(";");
            MenuProductsDTO menuItemDTO = new MenuProductsDTO();
            menuItemDTO.setId(Long.parseLong(values[0]));
            menuItemDTO.setParentId(Long.parseLong(values[1]));
            menuItemDTO.setText(values[2]);
            //childlists will be null - I'll feed childs in another function
            menuItemDTO.setChildsList(null);
            menuItemDTO.setLink(null);
            menuItemsDTOList.add(i,menuItemDTO);
        }
        return menuItemsDTOList;
    }

    private String[][] getDistinguishedCategories(String[][] categoriesArray, String parentID) {
        String[][] tempCategoriesArray = new String[categoriesArray.length][3];
        for (int i = 0; i < categoriesArray.length; i++) {
            if (categoriesArray[i][1].equals(parentID)) {
                int j = 0;
                tempCategoriesArray[j][0] = categoriesArray[i][0];
                tempCategoriesArray[j][1] = categoriesArray[i][1];
                tempCategoriesArray[j][2] = categoriesArray[i][2];
                j++;
            }
        }
        return tempCategoriesArray;
    }

    public String[][] getAllCategoriesArray(List<String> linesList) {
        String[][] categoriesArray = new String[linesList.size()][3];

        for (int i = 0; i < linesList.size(); i++) {
            String line = linesList.get(i);
            String[] values = line.split(";");
            categoriesArray[i][0] = values[0];
            categoriesArray[i][1] = values[1];
            categoriesArray[i][2] = values[2];
        }

        return categoriesArray;
    }

}
