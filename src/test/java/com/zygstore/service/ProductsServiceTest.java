package com.zygstore.service;

import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.assertEquals;

import com.zygstore.dto.ProductDTO;
import org.junit.Test;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class ProductsServiceTest {

    @Test
    public void createProductDTOName () {
        //given
        String name = "Apple Macbook Air 13,3";
        ProductService productService = new ProductService();

        //when
        List<ProductDTO> listOfProducts = productService.productListWithCategoryToDisplay("3");

        //then
        assertEquals(name, listOfProducts.get(0).getName());
    }


}
