package com.zygstore.business.mappers;

import com.zygstore.model.Product;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class ProductMapper {

    public Product toProduct(String[] values) {
        long id = Long.parseLong(values[0]);
        String productName = values[1];
        Long categoryId = Long.parseLong(values[2]);
        Double rating = Double.valueOf(values[3]);
        Double prize = Double.valueOf(values[4]);
        String linkToPicture = values[5];
        String description = values[6];

        return new Product(id, productName, categoryId, rating, prize, linkToPicture, description);
    }
}
