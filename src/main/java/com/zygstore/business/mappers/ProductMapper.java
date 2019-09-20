package com.zygstore.business.mappers;

import java.util.HashMap;
import java.util.Map;


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
        String categoryId = values[2];
        Double rating = Double.valueOf(values[3]);
        Double prize = Double.valueOf(values[4]);
        String linkToPicture = values[5];
        Map<String, String> descriptionMap = getMap(values[6]);

        return new Product(id, productName, categoryId, rating, prize, linkToPicture, descriptionMap);
    }

    private Map<String, String> getMap(String allDescriptionLine) {
        Map<String, String> descriptionMap = new HashMap<>();
        String[] descriptionLines = allDescriptionLine.split("#");

        for (String descriptionLine : descriptionLines) {
            String[] descriptionItems = descriptionLine.split(",");
            descriptionMap.put(descriptionItems[0], descriptionItems[1]);
        }

        return descriptionMap;
    }
}
