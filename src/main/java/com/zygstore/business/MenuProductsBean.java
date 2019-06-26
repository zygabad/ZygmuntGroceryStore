package com.zygstore.business;

import java.io.IOException;
import java.util.ArrayList;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.zygstore.config.Context;
import com.zygstore.dto.*;
import com.zygstore.service.MenuProductsService;
import com.zygstore.utils.ReadKomputronikSite;
import com.zygstore.utils.WriteFile;
import net.bootsfaces.utils.FacesMessages;
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
public class MenuProductsBean {
    private String displayField;
    private Context context;
    final static Logger logger = Logger.getLogger(MenuProductsBean.class);
    private static final String FILE_MENU_PRODUCTS = "Categories.csv";
    private static final String FILE_MENU_PRODUCTS_ADMIN = "c:\\temp_zyg_ZygmuntGroceryStore\\Categories.csv";
    public String fileNameWithPathToCategories = FILE_MENU_PRODUCTS_ADMIN;

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
    }

    public void readKomputronikSiteToFile() throws IOException {
        ReadKomputronikSite kompsite = new ReadKomputronikSite();
        ArrayList<String> listOfLines = kompsite.getLinesFromFile();
        menuItemsList = menuProductsService.getCategories(listOfLines);
        WriteFile wf = new WriteFile(fileNameWithPathToCategories, listOfLines);
        wf.writeToFile();
        FacesMessages.info("Successfully saved.");
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

    public void setFileNameWithPathToCategories(String fileNameWithPathToCategories) {
        this.fileNameWithPathToCategories = fileNameWithPathToCategories;
    }

    public String getFileNameWithPathToCategories() {
        return fileNameWithPathToCategories;
    }
}
