package com.zygstore.model.file;

import java.util.ArrayList;
import java.util.List;


import com.zygstore.business.mappers.ProductMapper;
import com.zygstore.model.Product;
import com.zygstore.model.dao.ProductDAO;
import com.zygstore.utils.ReadCSVFileWithAllCategories;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class ProductDAOFileImpl implements ProductDAO {
    private String productsFile;
    private ProductMapper productMapper;

    public ProductDAOFileImpl(String productsFile,
                              ProductMapper productMapper) {
        this.productsFile = productsFile;
        this.productMapper = productMapper;
    }

    //TODO
    @Override
    public Product read(String productName) {
        throw new NotImplementedException();
    }

    @Override
    public List<Product> getProducts(String category) {
        //TODO ReadCSVFileWithAllCategories przeniesc do beana springowego
        ReadCSVFileWithAllCategories readCSVFileWithAllCategories =
            new ReadCSVFileWithAllCategories(productsFile);//zrobione - //sprawdz ws-bank...config w xmlach zeby taki plik byl w konfigu
        List<String> linesFromFile = readCSVFileWithAllCategories.getList();
        List<Product> listOfProducts = new ArrayList<>();

        for (String line : linesFromFile) {
            if (!line.equals(null) || !line.equals("") || !line.equals(" ")) {
                String[] values = line.split(";");
                if (values[2].equals(category)) {
                    Product product = productMapper.toProduct(values);
                    listOfProducts.add(product);
                }
            }
        }

        return listOfProducts;
    }

    //TODO
    @Override
    public List<Product> getAllProducts() {
        throw new NotImplementedException();
    }
}
