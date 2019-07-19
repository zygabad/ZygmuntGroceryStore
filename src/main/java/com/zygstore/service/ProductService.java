package com.zygstore.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zygstore.business.mappers.*;
import com.zygstore.dto.ProductDTO;
import com.zygstore.model.Product;
import com.zygstore.model.dao.ProductDAO;
import com.zygstore.model.file.ProductDAOFileImpl;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class ProductService {
    public List<ProductDTO> getProducts(String categoryId) {
        ProductDAO productDAO = new ProductDAOFileImpl();
        List<Product> prodcutsList = productDAO.getProducts(categoryId);
        ProductMapper productMapper = new ProductMapper(prodcutsList);
        List<ProductDTO> listOfProductsInCategory = productMapper.toProductsDTO();

        return listOfProductsInCategory;
    }

    private List<ProductDTO> createProductsDTOByCategory(String catogorytToDisplay, List<ProductDTO> listOfProducts) {
        List<ProductDTO> listOfProductsInCategory = new ArrayList<>();

        for (int i = 0; i < listOfProducts.size(); i++) {
            if (listOfProducts.get(i).getCategoryId().equals(catogorytToDisplay)) {
                listOfProductsInCategory.add(listOfProducts.get(i));
            }
        }

        return listOfProductsInCategory;
    }


}
