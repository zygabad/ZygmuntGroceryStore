package com.zygstore.service;

import java.util.List;
import java.util.stream.Collectors;


import com.zygstore.business.mappers.ProductDTOMapper;
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

public class ProductService {//w service skladam klocki, nie tworze nowych bo inaczej trudno to przetestowac
    private ProductDAO productDAO;
    private ProductDTOMapper productDTOMapper;

    public ProductService(ProductDAO productDAO, ProductDTOMapper productDTOMapper) {
        this.productDAO = productDAO;
        this.productDTOMapper = productDTOMapper;
    }

    public List<ProductDTO> getProducts(String categoryId) {
        List<Product> products = productDAO.getProducts(categoryId);
        List<ProductDTO> productDTOS = products.stream()
            .map(productDTOMapper::toProductDTO)
            .collect(Collectors.toList());

        return productDTOS;
    }
}
