package com.zygstore.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class FeedProductsWithDataTest {

    @Test
    public void productDTOCreate () {
        //given
        Map<String, String> description = new HashMap<>();
        String name = "Apple Macbook Air 13,3";
        description.put("system operacyjny","Mac OS");

        //when
        ProductDTO productDTO = new ProductDTO(1L,"Apple Macbook Air 13,3","1",4.58,4169, "applemacbookair13.jpg",description);

        //then
        assertEquals(name, productDTO.getName());
    }


//        = {"system operacyjny : Mac OS","typ procesora : Intel Core i5", "wielkość pamięci RAM : 8 GB",
//    "pojemność dysku SSD : 128 GB"};
    //then


}
