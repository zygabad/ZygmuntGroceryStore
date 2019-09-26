package com.zygstore.model.file;

import java.util.ArrayList;
import java.util.List;


import com.zygstore.model.Category;
import com.zygstore.model.dao.CategoryDAO;
import com.zygstore.utils.CSVFileUtils;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class CategoryDAOFileImpl implements CategoryDAO {
    private String categoriesFile;
    private CSVFileUtils CSVFileUtils;

    public void setCategoriesFile(String categoriesFile) {
        this.categoriesFile = categoriesFile;
    }

    public void setCSVFileUtils(CSVFileUtils CSVFileUtils) {
        this.CSVFileUtils = CSVFileUtils;
    }

    //TODO implement
    @Override
    public Category read(String categoryName) {
        throw new NotImplementedException();
    }

    //TODO implement
    @Override
    public List<Category> getCategories(String categoryId) {
        throw new NotImplementedException();
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> categoryList = new ArrayList<>();
        long id = 0;
        long parentId = 0;
        String text = null;
        String link = null;
        String linkToPicture = null;

        List<String> linesFromFile = CSVFileUtils.getList(categoriesFile);

        for (String line : linesFromFile) {
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

}
