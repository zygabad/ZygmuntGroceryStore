package com.zygstore.business.mappers;

import java.util.HashMap;
import java.util.Map;


import static org.junit.Assert.assertEquals;

import com.zygstore.dto.ProductDTO;
import com.zygstore.model.Product;
import org.junit.Test;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */
public class ProductDTOMapperTest {
    private ProductDTOMapper productDTOMapper = new ProductDTOMapper();

    @Test
    public void toProductDTO() {
        //given
        Long id = 1L;
        String productName = "Macbook Pro";
        String categoryId = "Laptop";
        double rating = 1.6;
        double prize = 8909.99;
        String linkToPicture = "http://link_to_picture";

        Map<String, String> descriptionMap = new HashMap<>();
        descriptionMap.put("processor", "i5");
        descriptionMap.put("RAM", "8 GB");

        Product product = new Product(id, productName, categoryId, rating, prize, linkToPicture, descriptionMap);

        //when
        ProductDTO productDTO = productDTOMapper.toProductDTO(product);

        //then
        assertEquals(id, productDTO.getId());
        assertEquals(productName, productDTO.getName());
        assertEquals(categoryId, productDTO.getCategoryId());
        assertEquals(rating, productDTO.getRating(), 0.0);
        assertEquals(prize, productDTO.getPrize(), 0.0);
        assertEquals(linkToPicture, productDTO.getLinkToPicture());
        assertEquals(descriptionMap, productDTO.getDescription());
    }
}