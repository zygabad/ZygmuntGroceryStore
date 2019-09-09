package com.zygstore.business.mappers;

import com.zygstore.dto.ProductDTO;
import com.zygstore.model.Product;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class ProductMapper {

    public ProductMapper() {
    }

    public static ProductDTO toProductDTO(Product product) {
        return new ProductDTO(product.getId(),
            product.getProductName(),
            product.getCategoryId(),
            product.getRating(),
            product.getPrize(),
            product.getLinkToPicture(),
            product.getDescription());
    }
}
