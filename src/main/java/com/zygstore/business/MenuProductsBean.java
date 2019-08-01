package com.zygstore.business;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import static java.lang.System.out;

import com.zygstore.config.Context;
import com.zygstore.dto.MenuProductsDTO;
import com.zygstore.dto.ProductDTO;
import com.zygstore.navigation.Result;
import com.zygstore.service.MenuProductsService;
import com.zygstore.service.ProductService;
import com.zygstore.utils.MenuItemsDTOSListCreator;
import com.zygstore.utils.ReadKomputronikSite;
import com.zygstore.utils.WriteFile;
import org.apache.log4j.Logger;

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
    private static final String MAIN_PAGE_BREADCRUMB_NAME = "Strona główna";
    public String fileNameWithPathToCategories = FILE_MENU_PRODUCTS_ADMIN;
    public Boolean productListEmpty;

    MenuProductsService menuProductsService;
    ProductService productService;

    private MenuProductsDTO menuProductsDTO;
    ArrayList<MenuProductsDTO> menuItemsList = new ArrayList<>();
    List<ProductDTO> productsList = new ArrayList<>();
    List<ProductDTO> mainCategoriesList = new ArrayList<>();

    private String page="start.xhtml";
    public MenuProductsDTO menuProductsDTOClicked;

    public MenuProductsBean() {
        out.println("MenuProductsBean zainicjalizowany !");
        logger.info("MenuProductsBean initialized!");
        displayField = "TEST_CHECK";
        this.displayField = displayField;

    }

    public void initPage() throws IOException {
        menuItemsList = menuProductsService.getCategories(FILE_MENU_PRODUCTS);
    }

    public void initProductsPage() {
        productsList = productService.getProducts(menuProductsDTOClicked.getId());
        productListEmpty = checkListOfProductsNotEmpty(productsList);
    }

    public void initMainPage() {
        menuItemsList = menuProductsService.getCategories(FILE_MENU_PRODUCTS);
    }

    public Result readKomputronikSiteToFile() throws IOException {
        ReadKomputronikSite kompsite = new ReadKomputronikSite();
        ArrayList<String> listOfLines = kompsite.getLinesFromFile();
        menuItemsList = menuProductsService.getCategories(listOfLines);
        WriteFile wf = new WriteFile(fileNameWithPathToCategories, listOfLines);
        wf.writeToFile();
        FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO Message", "INFO File was successfully saved"));
        logger.info("File " + fileNameWithPathToCategories + "was successfully saved");

        return Result.SUCCESS;
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

    public String getPage() {
        return page;
    }

    public void setPage(String currentPage) {
        this.page=currentPage;
    }

    public MenuProductsDTO getMenuProductsDTOClicked() {
        return menuProductsDTOClicked;
    }

    public void setMenuProductsDTOClicked(MenuProductsDTO menuProductsDTOClicked) {
        this.menuProductsDTOClicked = menuProductsDTOClicked;
    }

    public MenuProductsDTO findMenuProductClickedByName(String itemName){
        if (itemName.equals(MAIN_PAGE_BREADCRUMB_NAME)) {
            MenuItemsDTOSListCreator menuItemsDTOSListCreator = new MenuItemsDTOSListCreator();
            return menuItemsDTOSListCreator.mainPageDTO();
        }
        for (int i = 0; i < menuItemsList.size(); i++) {
            if (menuItemsList.get(i).getText().equals(itemName)) {
                return menuItemsList.get(i);
            } else {
                for (int j = 0; j < menuItemsList.get(i).getChildsList().size(); j++) {
                    if (menuItemsList.get(i).getChildsList().get(j).getText().equals(itemName)) {
                        return menuItemsList.get(i).getChildsList().get(j);
                    } else {
                        for (int x = 0; x < menuItemsList.get(i).getChildsList().get(j).getChildsList().size(); x++) {
                            if (menuItemsList.get(i).getChildsList().get(j).getChildsList().get(x).getText().equals(itemName)) {
                                return menuItemsList.get(i).getChildsList().get(j).getChildsList().get(x);
                            }
                        }
                    }

                }
            }
        }
        return null;
    }


    private MenuProductsDTO findMenuProductClickedbyId(String itemId){
        for (int i = 0; i < menuItemsList.size(); i++){
            if (menuItemsList.get(i).getId().equals(itemId)) {
                return menuItemsList.get(i);
            }
        }

        return null;
    }

    public void setClickedMenuItem(String itemName) {
        setMenuProductsDTOClicked(findMenuProductClickedByName(itemName));
    }

    public void test(String name) {
        out.println("TEST: " + name);
        setMenuProductsDTOClicked(findMenuProductClickedByName(name));
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public List<ProductDTO> getProductsList() {
        return productsList;
    }

    private Boolean checkListOfProductsNotEmpty(List<ProductDTO> listOfProducts){
        if (productsList.size()>0){
            setProductListEmpty(false);
            return false;
        } else {
            setProductListEmpty(true);
            return true;
        }
    }

    public Boolean getProductListEmpty() {
        return productListEmpty;
    }

    public void setProductListEmpty(Boolean productListEmpty) {
        this.productListEmpty = productListEmpty;
    }

    public List<ProductDTO> getMainCategoriesList() {
        return mainCategoriesList;
    }

    public void setMainCategoriesList(List<ProductDTO> mainCategoriesList) {
        this.mainCategoriesList = mainCategoriesList;
    }
}
