package com.zygstore.model.dao;

import java.util.List;


import com.zygstore.dto.ProductDTO;
import com.zygstore.model.Product;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public interface ProductDAO {
    public Product read(String productName);
    public List<Product> getProducts(String categoryId);
    List<Product> getAllProducts();
}
