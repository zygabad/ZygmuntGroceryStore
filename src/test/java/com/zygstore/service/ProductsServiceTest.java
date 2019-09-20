package com.zygstore.service;

import java.util.List;


import static org.junit.Assert.assertEquals;

import com.zygstore.dto.ProductDTO;
import com.zygstore.model.dao.ProductDAO;
import org.jboss.arquillian.core.api.annotation.Inject;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class ProductsServiceTest {
    @Mock
    ProductDAO productDAO;

    @InjectMocks
    ProductService productService;

    @Test
    public void createProductDTOName () {
        //given
        String name = "Apple Macbook Air 13,3";

        //when
        List<ProductDTO> listOfProducts = productService.getProducts("3");

        //then
        assertEquals(name, listOfProducts.get(0).getName());
    }


}
