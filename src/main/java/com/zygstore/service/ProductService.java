package com.zygstore.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.zygstore.dto.ProductDTO;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class ProductService {
    public List<ProductDTO> getProducts(String categoryId) {
        List<ProductDTO> listOfAllProducts = createProductsDTO();
        List<ProductDTO> listOfProductsInCategory = createProductsDTOByCategory(categoryId, listOfAllProducts);

        return listOfProductsInCategory;
    }

    private List<ProductDTO> createProductsDTO() {
        List<ProductDTO> listOfProducts = new ArrayList<>();

        Map<String, String> descriptionMap1 = new HashMap<>();
        descriptionMap1.put("system operacyjny", "Mac OS");
        descriptionMap1.put("typ procesora", "Intel Core i5");
        descriptionMap1.put("wielkość pamięci RAM", "8 GB");
        descriptionMap1.put("pojemność dysku SSD", "128 GB");

        ProductDTO productDTO1 =
            new ProductDTO("Apple Macbook Air 13,3", "4", 4.58, 4169, "/images/products/applemacbookair13.jpg", descriptionMap1);
        listOfProducts.add(productDTO1);

        Map<String, String> descriptionMap2 = new HashMap<>();
        descriptionMap2.put("system operacyjny", "Mac OS");
        descriptionMap2.put("typ procesora", "Intel Core i7, Intel Core i5");
        descriptionMap2.put("wielkość pamięci RAM", "8 GB, 16 GB");
        descriptionMap2.put("pojemność dysku SSD", "128 GB");
        ProductDTO productDTO2 =
            new ProductDTO("Apple Macbook Pro 15", "4", 5, 5599, "/images/products/applemacbookpro15.jpg", descriptionMap2);
        listOfProducts.add(productDTO2);

        Map<String, String> descriptionMap3 = new HashMap<>();
        descriptionMap3.put("dysk twardy", "32 GB");
        descriptionMap3.put("łączność", "Bluetooth, Wi-Fi");
        descriptionMap3.put("obsługiwane formaty plików", ".gif, .jpg,");
        descriptionMap3.put("pilot", "tak");
        descriptionMap3.put("waga", "425 g");
        descriptionMap3.put("szerokość", "98 mm");
        descriptionMap3.put("wysokość", "35 mm");
        ProductDTO productDTO3 = new ProductDTO("Apple TV", "84", 4.75, 799, "/images/products/appletv.jpg", descriptionMap3);
        listOfProducts.add(productDTO3);

        Map<String, String> descriptionMap4 = new HashMap<>();
        descriptionMap4.put("przekątna wyświetlacza", "4.7 cale");
        descriptionMap4.put("pamięć Flash", "32 GB, 128 GB");
        descriptionMap4.put("system operacyjny", "Apple iOS 10");
        descriptionMap4.put("rozdzielczość", "1334 x 750 piksele");
        descriptionMap4.put("aparat fotograficzny z tyłu", "12 Mpix");
        descriptionMap4.put("pamięć RAM", "2048 MB");
        descriptionMap4.put("kolor", "czarny, różowy, srebrny, złoty");
        ProductDTO productDTO4 = new ProductDTO("Apple Iphone 7", "187", 3.75, 1979, "/images/products/appleIphone7.jpg", descriptionMap4);
        listOfProducts.add(productDTO4);

        Map<String, String> descriptionMap5 = new HashMap<>();
        descriptionMap5.put("model procesora", "Apple A12X");
        descriptionMap5.put("wbudowany odbiornik GPS", "tak");
        descriptionMap5.put("aparat fotograficzny z tyłu", "12 Mpix");
        ProductDTO productDTO5 = new ProductDTO("Apple Ipad pro 11", "7", 4.65, 3799, "/images/products/appleipadpro.jpg", descriptionMap5);
        listOfProducts.add(productDTO5);


        return listOfProducts;
    }

    private List<ProductDTO> createProductsDTOByCategory(String catogorytToDisplay, List<ProductDTO> listOfProducts) {
        List<ProductDTO> listOfProductsInCategory = new ArrayList<>();

        for (int i = 0; i < listOfProducts.size(); i++) {
            if (listOfProducts.get(i).getCategoryId().equals(catogorytToDisplay)) {
                listOfProductsInCategory.add(listOfProducts.get(i));
            }
        }

        return listOfProductsInCategory;
    }


}
