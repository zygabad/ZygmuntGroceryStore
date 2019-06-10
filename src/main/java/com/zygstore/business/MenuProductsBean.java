package com.zygstore.business;

import java.io.IOException;
import java.util.ArrayList;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.zygstore.config.Context;
import com.zygstore.dto.*;
import com.zygstore.service.MenuProductsService;
import com.zygstore.utils.ReadKomputronikSite;
import org.apache.log4j.Logger;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

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

    public void initPage() throws IOException {
        menuItemsList = menuProductsService.getCategories(FILE_MENU_PRODUCTS);
        ReadKomputronikSite kompsite = new ReadKomputronikSite();
        Element tree = kompsite.getTree();
        String treeElements = tree.toString();
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
