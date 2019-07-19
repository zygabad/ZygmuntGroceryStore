package com.zygstore.model.mappers;

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
    private List<String> linesFromFile;
    String productName;
    String categoryId;
    double rating;
    double prize;
    String linkToPicture;
    String allDescriptionLine;
    Map<String, String> description;
    List<ProductDTO> listOfProducts;
    ProductDTO productDTO;

    public ProductMapper(List<String> linesFromFile) {
        this.linesFromFile = linesFromFile;
    }

    public List<ProductDTO> toProductsDTO() {
        listOfProducts = new ArrayList<>();
        for (int i = 0; i < linesFromFile.size(); i++) {
            String line = linesFromFile.get(i);
            String[] values = line.split(";");
            productName = values[0];
            categoryId = values[1];
            rating = Double.valueOf(values[2]);
            prize = Double.valueOf(values[3]);
            linkToPicture = values[4];

            allDescriptionLine = values[5];
            Map<String, String> descriptionMap = getMap(allDescriptionLine);

            ProductDTO productDTO = new ProductDTO(productName, categoryId, rating, prize, linkToPicture, descriptionMap);
            listOfProducts.add(productDTO);
        }
        return listOfProducts;
    }

    private Map<String, String> getMap(String allDescriptionLine) {
        Map<String, String> descriptionMap1 = new HashMap<>();
        String[] descriptionLine = allDescriptionLine.split("#");
        for (int j = 0; j < descriptionLine.length; j++) {
            String[] descriptionItem = descriptionLine[j].split(",");
            descriptionMap1.put(descriptionItem[0], descriptionItem[1]);
        }
        return descriptionMap1;
    }
}
