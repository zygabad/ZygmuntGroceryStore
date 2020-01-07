package com.zygstore.model.file;

import java.util.ArrayList;
import java.util.List;


import com.zygstore.business.mappers.ProductMapper;
import com.zygstore.model.Product;
import com.zygstore.model.dao.ProductDAO;
import com.zygstore.utils.CVSFileUtils;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class ProductDAOFileImpl implements ProductDAO {
    private String productsFile;
    private ProductMapper productMapper;
    private CVSFileUtils CVSFileUtils;

    public ProductDAOFileImpl(String productsFile,
                              ProductMapper productMapper,
                              CVSFileUtils CVSFileUtils) {
        this.productsFile = productsFile;
        this.productMapper = productMapper;
        this.CVSFileUtils = CVSFileUtils;
    }

    //TODO to implement
    @Override
    public Product read(String productName) {
        throw new NotImplementedException();
    }

    @Override
    public List<Product> getProducts(Long category) {
        List<String> linesFromFile = CVSFileUtils.getList(productsFile);
        List<Product> listOfProducts = new ArrayList<>();

        for (String line : linesFromFile) {
            if (!line.equals(null) || !line.equals("") || !line.equals(" ")) {
                String[] values = line.split(";");

                if (values[2] != null && !values[2].equals("") && Long.parseLong(values[2]) == category.longValue()) {
                    Product product = productMapper.toProduct(values);
                    listOfProducts.add(product);
                }
            }
        }

        return listOfProducts;
    }

    //TODO to implement
    @Override
    public List<Product> getAllProducts() {
        throw new NotImplementedException();
    }
}
