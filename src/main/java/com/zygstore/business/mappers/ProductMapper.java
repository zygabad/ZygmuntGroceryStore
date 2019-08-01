package com.zygstore.business.mappers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.zygstore.dto.ProductDTO;
import com.zygstore.model.Product;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class ProductMapper {
    Long id;
    String productName;
    String categoryId;
    double rating;
    double prize;
    String linkToPicture;
    Map<String, String> description;

    List<Product> productList;

    public ProductMapper(List<Product> productList) {
        this.productList = productList;
    }

    public List<ProductDTO> toProductsDTO() {
        return getMappedProductDTOS(productList);
    }

    private List<ProductDTO> getMappedProductDTOS(List<Product> productList) {
        List<ProductDTO> produtctDTOList = new ArrayList<>();

        for (int i = 0; i < productList.size(); i++) {
            id = productList.get(i).getId();
            productName = productList.get(i).getProductName();
            categoryId = productList.get(i).getCategoryId();
            rating = productList.get(i).getRating();
            prize = productList.get(i).getPrize();
            linkToPicture = productList.get(i).getLinkToPicture();
            description = productList.get(i).getDescription();

            ProductDTO productDTO = new ProductDTO(id, productName, categoryId, rating, prize, linkToPicture, description);
            produtctDTOList.add(productDTO);
        }
        return produtctDTOList;
    }
}
