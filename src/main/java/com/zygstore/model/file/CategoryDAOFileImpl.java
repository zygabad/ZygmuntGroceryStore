package com.zygstore.model.file;

import java.util.ArrayList;
import java.util.List;


import com.zygstore.dto.MenuProductsDTO;
import com.zygstore.model.Category;
import com.zygstore.model.dao.CategoryDAO;
import com.zygstore.utils.ReadCSVFileWithAllCategories;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class CategoryDAOFileImpl implements CategoryDAO {
    private String categoriesFile;
    private long id;
    private long parentId;
    private String text;
    private String link;
    private List<MenuProductsDTO> childsList;
    private List<String> breadCrumbs;
    private String linkToPicture;
    private ArrayList<Category> categoryList;
    private ArrayList<String> linesFromFile;

    @Override
    public Category read(String categoryName) {
        return null;
    }

    @Override
    public List<Category> getCategories(String categoryId) {


        return null;
    }

    @Override
    public List<Category> getAllCategories() {
        linesFromFile = new ArrayList<>();
        ReadCSVFileWithAllCategories readCSVFileWithAllCategories = new ReadCSVFileWithAllCategories(categoriesFile);
        linesFromFile = readCSVFileWithAllCategories.getList();
        categoryList = new ArrayList<>();

        for (int i = 0; i < linesFromFile.size(); i++) {
            String line = linesFromFile.get(i);
            if (!line.equals(null) || !line.equals("") || !line.equals(" ")) {
                String[] values = line.split(";");
                if (!values[0].equals(null)) {
                    id = Long.parseLong(values[0]);
                } else if (values[0].equals(null)) {
                    id = Long.parseLong(null);
                }
                if (!values[1].equals(null)) {
                    parentId = Long.parseLong(values[1]);
                } else if (!values[1].equals(null)) {
                    parentId = Long.parseLong(null);
                }
                text = values[2];
                link = values[3];
                linkToPicture = values[4];

            }
            Category category = new Category(id, parentId, text, link, linkToPicture);
            categoryList.add(category);
        }
        return categoryList;
    }

    public void setCategoriesFile(String categoriesFile) {
        this.categoriesFile = categoriesFile;
    }

}
