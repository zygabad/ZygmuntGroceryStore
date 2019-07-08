package com.zygstore.dto;

import java.util.ArrayList;
import java.util.List;


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
        List<String> description = new ArrayList<String>();
        String name = "Apple Macbook Air 13,3";
        description.add("system operacyjny : Mac OS");

        //when
        ProductDTO productDTO = new ProductDTO("Apple Macbook Air 13,3","1",4.58,4169, description,"applemacbookair13.jpg");

        //then
        assertEquals(name, productDTO.getName());
    }


//        = {"system operacyjny : Mac OS","typ procesora : Intel Core i5", "wielkość pamięci RAM : 8 GB",
//    "pojemność dysku SSD : 128 GB"};
    //then


}
