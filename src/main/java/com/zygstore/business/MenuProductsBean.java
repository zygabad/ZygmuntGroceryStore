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
import com.zygstore.dto.CategoryDTO;
import com.zygstore.dto.ProductDTO;
import com.zygstore.navigation.Result;
import com.zygstore.service.CategoryService;
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
    private Context context;
    final static Logger logger = Logger.getLogger(MenuProductsBean.class);
    private static final String FILE_MENU_PRODUCTS = "Categories.csv";
    private static final String FILE_MENU_PRODUCTS_ADMIN = "c:\\temp_zyg_ZygmuntGroceryStore\\Categories.csv";
    private static final String MAIN_PAGE_BREADCRUMB_NAME = "Strona główna";
    public String fileNameWithPathToCategories = FILE_MENU_PRODUCTS_ADMIN;
    public Boolean productListEmpty;
    public Boolean categoriesListEmpty;

    CategoryService categoryService;
    ProductService productService;
    public CategoryDTO categoryDTOClicked;
    List<CategoryDTO> menuItemsList = new ArrayList<>();
    List<ProductDTO> productsList = new ArrayList<>();

    public MenuProductsBean() {
        out.println("MenuProductsBean zainicjalizowany !");
        logger.info("MenuProductsBean initialized!");
    }

    public void initPage() throws IOException {
        menuItemsList = categoryService.getCategories(FILE_MENU_PRODUCTS);
        checkCategoriesListEmpty(categoryDTOClicked);
    }

    public void initProductsPage() {
        productsList = productService.getProducts(categoryDTOClicked.getId());
        productListEmpty = checkListOfProductsNotEmpty(productsList);
    }

    public void initMainPage() {
        menuItemsList = categoryService.getCategories(FILE_MENU_PRODUCTS);
        setCategoriesListEmpty(false);
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

    public void checkCategoriesListEmpty(CategoryDTO categoryDTOClicked) {
        if (categoryDTOClicked.getChildsList().size() > 0) {
            setCategoriesListEmpty(false);
        } else {
            setCategoriesListEmpty(true);
        }
    }

    public Result readKomputronikSiteToFile() throws IOException {
        ReadKomputronikSite kompsite = new ReadKomputronikSite();
        ArrayList<String> listOfLines = kompsite.getLinesFromFile();
        menuItemsList = categoryService.getCategories(listOfLines);
        WriteFile wf = new WriteFile(fileNameWithPathToCategories, listOfLines);
        wf.writeToFile();
        FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO Message", "INFO File was successfully saved"));
        logger.info("File " + fileNameWithPathToCategories + "was successfully saved");

        return Result.SUCCESS;
    }

    public CategoryDTO findMenuProductClickedByName(String itemName) {
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

    public void setClickedMenuItem(String itemName) {
        setCategoryDTOClicked(findMenuProductClickedByName(itemName));
        checkCategoriesListEmpty(categoryDTOClicked);
    }

    public List<CategoryDTO> getMenuItemsList() {
        return menuItemsList;
    }

    public Boolean getCategoriesListEmpty() {
        return categoriesListEmpty;
    }

    public void setCategoriesListEmpty(Boolean categoriesListEmpty) {
        this.categoriesListEmpty = categoriesListEmpty;
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
}
