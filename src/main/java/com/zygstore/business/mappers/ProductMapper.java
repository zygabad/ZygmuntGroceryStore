package com.zygstore.business.mappers;

import java.util.List;


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
    //TODO implement this method
//    public List<Product> toProducts(List<String> linesFromFile) {
//        for (String line : linesFromFile) {
//            if (!line.equals(null) || !line.equals("") || !line.equals(" ")) {
//                String[] values = line.split(";");
//
//                if (values[2] != null && !values[2].equals("") && Long.parseLong(values[2]) == category.longValue()) {
//                    Product product = productMapper.toProduct(values);
//                    listOfProducts.add(product);
//                }
//            }
//        }
//    }
}
