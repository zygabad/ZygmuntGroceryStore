package com.zygstore.business;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import static java.lang.System.out;

import com.zygstore.config.Context;
import com.zygstore.dto.CategoryDTO;
import com.zygstore.dto.ProductDTO;
import com.zygstore.excpetions.WrongFileFormatExcetion;
import com.zygstore.navigation.Result;
import com.zygstore.service.CategoryService;
import com.zygstore.service.ProductService;
import com.zygstore.utils.ReadKomputronikSite;
import com.zygstore.utils.WriteFileUtils;
import org.apache.log4j.Logger;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */
@ManagedBean(name = "menuProductsBean", eager = true)
@SessionScoped
public class MenuProductsBean {

    private static final Logger LOGGER = Logger.getLogger(MenuProductsBean.class);
    private static final String FILE_MENU_PRODUCTS_ADMIN = "c:\\temp_zyg_ZygmuntGroceryStore\\Categories.csv";
    private static final String MAIN_PAGE_BREADCRUMB_NAME = "Strona główna";

    public String fileNameWithPathToCategories = FILE_MENU_PRODUCTS_ADMIN;
    public Boolean productListEmpty;

    private Context context;

    CategoryService categoryService;
    ProductService productService;
    public CategoryDTO categoryDTOClicked;
    List<CategoryDTO> menuItemsList = new ArrayList<>();
    List<ProductDTO> productsList = new ArrayList<>();
    private Map<String, CategoryDTO> menuItemsMap;


    public MenuProductsBean() {
        out.println("MenuProductsBean zainicjalizowany !");
        LOGGER.info("MenuProductsBean initialized!");
    }

    public void initPage() throws IOException, WrongFileFormatExcetion {
        setMenuItemsList(categoryService.getCategories());
    }

    public void initProductsPage() {
        productsList = productService.getProducts(categoryDTOClicked.getId());
        productListEmpty = checkListOfProductsNotEmpty(productsList);
    }

    public void initMainPage() throws WrongFileFormatExcetion {
        setMenuItemsList(categoryService.getCategories());
    }

    private Boolean checkListOfProductsNotEmpty(List<ProductDTO> listOfProducts) {
        if (productsList.size() > 0) {
            setProductListEmpty(false);
            return false;
        } else {
            setProductListEmpty(true);
            return true;
        }
    }

    public Result readKomputronikSiteToFile() throws IOException {
        ReadKomputronikSite kompsite = new ReadKomputronikSite();
        ArrayList<String> listOfLines = kompsite.getLinesFromFile();
        setMenuItemsList(categoryService.getCategories(listOfLines));
        WriteFileUtils wf = new WriteFileUtils(fileNameWithPathToCategories, listOfLines);
        wf.writeToFile();
        FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO Message", "INFO File was successfully saved"));
        LOGGER.info("File " + fileNameWithPathToCategories + "was successfully saved");

        return Result.SUCCESS;
    }

    public void setClickedMenuItem(String itemName) {
        CategoryDTO clickedItem = findMenuProductClickedByName(itemName);
        setCategoryDTOClicked(clickedItem);
    }

    public List<CategoryDTO> getMenuItemsList() {
        return menuItemsList;
    }

    public Boolean isCategoriesListEmpty() {
        return categoryDTOClicked == null
            || categoryDTOClicked.getChildsList() == null
            || categoryDTOClicked.getChildsList().size() == 0;
    }


    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public List<ProductDTO> getProductsList() {
        return productsList;
    }

    public Boolean getProductListEmpty() {
        return productListEmpty;
    }

    public void setProductListEmpty(Boolean productListEmpty) {
        this.productListEmpty = productListEmpty;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public CategoryService getCategoryService() {
        return categoryService;
    }

    public void setFileNameWithPathToCategories(String fileNameWithPathToCategories) {
        this.fileNameWithPathToCategories = fileNameWithPathToCategories;
    }

    public String getFileNameWithPathToCategories() {
        return fileNameWithPathToCategories;
    }

    public CategoryDTO getCategoryDTOClicked() {
        return categoryDTOClicked;
    }

    public void setCategoryDTOClicked(CategoryDTO categoryDTOClicked) {
        this.categoryDTOClicked = categoryDTOClicked;
    }

    //TODO wrzuc to do service lub util i napisz test do tego???
    public CategoryDTO findMenuProductClickedByName(String itemName) {
        if (itemName.equals(MAIN_PAGE_BREADCRUMB_NAME)) {
            return categoryService.mainPageDTO();
        }

        return menuItemsMap.get(itemName);
    }

    public void setMenuItemsList(List<CategoryDTO> menuItemsList) {
        this.menuItemsList = menuItemsList;
        menuItemsMap = new HashMap<>();
        updateMenuItemsMap(menuItemsList);
    }

    private void updateMenuItemsMap(List<CategoryDTO> menuItemsList) {
        for (CategoryDTO categoryDTO : menuItemsList) {
            menuItemsMap.put(categoryDTO.getText(), categoryDTO);
            updateMenuItemsMap(categoryDTO.getChildsList());
        }
    }

}
