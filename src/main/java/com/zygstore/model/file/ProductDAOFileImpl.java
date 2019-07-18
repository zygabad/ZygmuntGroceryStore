package com.zygstore.model.file;

import java.util.List;


import com.zygstore.dto.ProductDTO;
import com.zygstore.model.dao.ProductDAO;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class ProductDAOFileImpl implements ProductDAO {
    @Override
    public void create(ProductDTO productDTO) {

    }

    @Override
    public ProductDTO read(String productName) {
//        public ProductDTO(String name, String categoryId, double rating, double prize, String linkToPicture,
//            Map<String, String> description) {
        //zaczytaj plik

        //wez mappera do mapowania?
//            ProductDTO productDTO = new ProductDTO();

        return null;
    }

    @Override
    public void update(String productName) {

    }

    @Override
    public void delete(String productName) {

    }

    @Override
    public List<ProductDTO> getProducts(String categoryId) {
        return null;
    }
}
