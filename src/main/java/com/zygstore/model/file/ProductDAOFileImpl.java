package com.zygstore.model.file;

import java.util.ArrayList;
import java.util.List;


import com.zygstore.dto.ProductDTO;
import com.zygstore.model.Product;
import com.zygstore.model.dao.ProductDAO;
import com.zygstore.utils.ReadCSVFileWithAllCategories;
import com.zygstore.utils.ReadKomputronikCategoriesImages;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class ProductDAOFileImpl implements ProductDAO {
    private static final String PRODUCTS_FILE = "Products.csv";

    @Override
    public Product read(String productName) {
        return null;
    }

    @Override
    public List<Product> getProducts(String categoryId) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

//    //zaczytaj plik
//        ReadCSVFileWithAllCategories readCSVFileWithAllCategories = new ReadCSVFileWithAllCategories(PRODUCTS_FILE);
//        ArrayList<String> linesFromFile = readCSVFileWithAllCategories.getList();
//
//        //wez mappera do mapowania?
//
////            ProductDTO productDTO = new ProductDTO();
//
//
//
//
//        return null;
//    }
}
