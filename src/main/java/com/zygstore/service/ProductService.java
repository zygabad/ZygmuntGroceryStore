package com.zygstore.service;

import java.util.ArrayList;
import java.util.List;


import com.zygstore.dto.ProductDTO;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class ProductService {
    private List<ProductDTO> createProductsDTO() {
        List<ProductDTO> listOfProducts = new ArrayList<>();

        List<String> description1 = new ArrayList<String>();
        description1.add("system operacyjny : Mac OS");
        description1.add("typ procesora : Intel Core i5");
        description1.add("wielkość pamięci RAM : 8 GB");
        description1.add("pojemność dysku SSD : 128 GB");
        ProductDTO productDTO1 = new ProductDTO("Apple Macbook Air 13,3","4",4.58,4169, description1,"/images/products/applemacbookair13.jpg");
        listOfProducts.add(productDTO1);

        List<String> description2 = new ArrayList<String>();
        description2.add("system operacyjny : Mac OS");
        description2.add("typ procesora : Intel Core i7, Intel Core i5");
        description2.add("wielkość pamięci RAM : 8 GB, 16 GB");
        description2.add("pojemność dysku SSD : 128 GB");
        ProductDTO productDTO2 = new ProductDTO("Apple Macbook Pro 15","4",5,5599, description2,"/images/products/applemacbookpro15.jpg");
        listOfProducts.add(productDTO2);

        List<String> description3 = new ArrayList<String>();
        description3.add("dysk twardy : 32 GB");
        description3.add("łączność : Bluetooth, Wi-Fi");
        description3.add("obsługiwane formaty plików : .gif, .jpg,");
        description3.add("pilot : tak");
        description3.add("waga : 425 g");
        description3.add("szerokość : 98 mm");
        description3.add("wysokość : 35 mm");
        ProductDTO productDTO3 = new ProductDTO("Apple TV","84",4.75,799, description3,"/images/products/appletv.jpg");
        listOfProducts.add(productDTO3);

        List<String> description4 = new ArrayList<String>();
        description4.add("przekątna wyświetlacza : 4.7 cale");
        description4.add("pamięć Flash : 32 GB, 128 GB");
        description4.add("system operacyjny : Apple iOS 10");
        description4.add("rozdzielczość : 1334 x 750 piksele");
        description4.add("aparat fotograficzny z tyłu : 12 Mpix");
        description4.add("pamięć RAM : 2048 MB");
        description4.add("kolor : czarny, różowy, srebrny, złoty");
        ProductDTO productDTO4 = new ProductDTO("Apple Iphone 7","187",3.75,1979, description4,"/images/products/appleIphone7.jpg");
        listOfProducts.add(productDTO4);

        List<String> description5 = new ArrayList<String>();
        description5.add("model procesora : Apple A12X");
        description5.add("wbudowany odbiornik GPS : tak");
        description5.add("aparat fotograficzny z tyłu : 12 Mpix");
        ProductDTO productDTO5 = new ProductDTO("Apple Ipad pro 11","7",4.65,3799, description5,"/images/products/appleipadpro.jpg");
        listOfProducts.add(productDTO5);


        return listOfProducts;
    }

    public List<ProductDTO> productListWithCategoryToDisplay (String category) {
        List<ProductDTO> listOfAllProducts = createProductsDTO();
        List<ProductDTO> listOfProductsInCategory = createProductsDTOByCategory(category, listOfAllProducts);
        return listOfProductsInCategory;
    }

    private List<ProductDTO> createProductsDTOByCategory (String catogorytToDisplay, List<ProductDTO> listOfProducts) {
        List<ProductDTO> listOfProductsInCategory = new ArrayList<>();

        for (int i = 0; i < listOfProducts.size(); i++) {
            if (listOfProducts.get(i).getCategoryId().equals(catogorytToDisplay)) {
                listOfProductsInCategory.add(listOfProducts.get(i));
            }
        }

        return listOfProductsInCategory;
    }


    }
