package com.zygstore.model.file;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.zygstore.dto.ProductDTO;
import com.zygstore.model.Product;
import com.zygstore.model.dao.ProductDAO;
import com.zygstore.utils.ReadCSVFileWithAllCategories;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class ProductDAOFileImpl implements ProductDAO {
    private String productsFile = "Products.csv";
    private long id;
    private String productName;
    private String categoryId;
    private double rating;
    private double prize;
    private String linkToPicture;
    private Map<String, String> description;
    private ArrayList<String> linesFromFile;
    private List<Product> listOfProducts;
    private ProductDTO productDTO;

    @Override
    public Product read(String productName) {
        return null;
    }

    @Override
    public List<Product> getProducts(String category) {
        ReadCSVFileWithAllCategories readCSVFileWithAllCategories =
            new ReadCSVFileWithAllCategories(productsFile);//sprawdz ws-bank...config w xmlach zeby taki plik byl w konfigu
        linesFromFile = readCSVFileWithAllCategories.getList();
        listOfProducts = new ArrayList<>();
        for (int i = 0; i < linesFromFile.size(); i++) {
            String line = linesFromFile.get(i);
            if (!line.equals(null) || !line.equals("") || !line.equals(" ")) {
                String[] values = line.split(";");
                if (values[2].equals(category)) {
                    // TODO mapper
                    id = Long.parseLong(values[0]);
                    productName = values[1];
                    categoryId = values[2];
                    rating = Double.valueOf(values[3]);
                    prize = Double.valueOf(values[4]);
                    linkToPicture = values[5];
                    Map<String, String> descriptionMap = getMap(values[6]);
                    Product product = new Product(id, productName, categoryId, rating, prize, linkToPicture, descriptionMap);
                    listOfProducts.add(product);
                }
            }
        }

        return listOfProducts;
    }

    private Map<String, String> getMap(String allDescriptionLine) {
        Map<String, String> descriptionMap1 = new HashMap<>();
        String[] descriptionLine = allDescriptionLine.split("#");
        for (int j = 0; j < descriptionLine.length; j++) {
            String[] descriptionItem = descriptionLine[j].split(",");
            descriptionMap1.put(descriptionItem[0], descriptionItem[1]);
        }

        return descriptionMap1;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    public void setProductsFile(String products_file) {
        this.productsFile = products_file;
    }
}
