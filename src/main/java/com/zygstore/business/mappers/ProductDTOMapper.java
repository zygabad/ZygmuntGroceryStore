package com.zygstore.business.mappers;

import java.util.HashMap;
import java.util.Map;


import com.zygstore.dto.ProductDTO;
import com.zygstore.model.Product;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */
public class ProductDTOMapper {

    public ProductDTO toProductDTO(Product product) {
        return new ProductDTO(product.getId(),
            product.getProductName(),
            product.getCategoryId(),
            product.getRating(),
            product.getPrize(),
            product.getLinkToPicture(),
            getMap(product.getDescription()));
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
