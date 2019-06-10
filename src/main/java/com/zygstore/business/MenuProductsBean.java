package com.zygstore.business;

import java.util.ArrayList;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.zygstore.config.Context;
import com.zygstore.dto.*;
import com.zygstore.service.MenuProductsService;
import org.apache.log4j.Logger;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */
@ManagedBean(name = "menuProductsBean", eager = true)
@SessionScoped
public class MenuProductsBean{
    private String displayField;
    private Context context;
    final static Logger logger = Logger.getLogger(MenuProductsBean.class);
    private static final String FILE_MENU_PRODUCTS = "Categories.csv";

    MenuProductsService menuProductsService;

    private MenuProductsDTO menuProductsDTO;
    ArrayList<MenuProductsDTO> menuItemsList = new ArrayList<>();

    public MenuProductsBean() {
        System.out.println("MenuProductsBean zainicjalizowany !");
        logger.info("MenuProductsBean initialized!");
        displayField = "TEST_CHECK";
        this.displayField = displayField;

    }

    public void initPage() {
        menuItemsList = menuProductsService.getCategories(FILE_MENU_PRODUCTS);
    }

    public ArrayList<MenuProductsDTO> getMenuItemsList() {
        return menuItemsList;
    }

    public MenuProductsDTO getMenuProductsDTO() {
        return menuProductsDTO;
    }

    public String getDisplayField() {
        return displayField;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public void setMenuProductsService(MenuProductsService menuProductsService) {
        this.menuProductsService = menuProductsService;
    }

    public MenuProductsService getMenuProductsService() {
        return menuProductsService;
    }
}
