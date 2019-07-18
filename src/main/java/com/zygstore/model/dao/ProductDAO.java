package com.zygstore.model.dao;

import java.util.List;


import com.zygstore.dto.ProductDTO;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public interface ProductDAO {
    public void create(ProductDTO productDTO);
    public ProductDTO read(String productName);
    public void update(String productName);
    public void delete(String productName);
    public List<ProductDTO> getProducts(String categoryId);
}
