package com.zygstore.service;

import java.util.List;


import com.zygstore.business.mappers.ProductMapper;
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
}
