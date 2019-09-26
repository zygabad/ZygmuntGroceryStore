package com.zygstore.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import com.zygstore.business.mappers.ProductDTOMapper;
import com.zygstore.dto.ProductDTO;
import com.zygstore.model.Product;
import com.zygstore.model.dao.ProductDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */
@RunWith(MockitoJUnitRunner.class)
public class ProductsServiceTest {
    @Mock
    private ProductDAO productDAO;

    @Spy
    private ProductDTOMapper productDTOMapper;

    @InjectMocks
    private ProductService productService;

    @Test
    public void createProductDTOName() {
        //given
        Long id = 1L;
        String productName = "Apple Macbook Air 13,3";
        String categoryId = "5";
        double rating = 4.5;
        double prize = 1390.99;
        String linkToPicture = "linkToPicture";
        Map<String, String> description = new HashMap<>();

        Product product = new Product(id, productName, categoryId, rating, prize, linkToPicture, description);
        List<Product> products = Arrays.asList(product);

        when(productDAO.getProducts(anyString())).thenReturn(products);

        //when
        List<ProductDTO> productDTOs = productService.getProducts("3");

        //then
        assertEquals(1, productDTOs.size());

        ProductDTO productDTO = productDTOs.get(0);
        assertEquals(id, productDTO.getId());
        assertEquals(productName, productDTO.getName());
        assertEquals(categoryId, productDTO.getCategoryId());
        // TODO - other asserts
    }


}
