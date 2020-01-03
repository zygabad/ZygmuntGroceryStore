package com.zygstore.model.db;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.zygstore.model.Category;
import com.zygstore.model.dao.CategoryDAO;
import org.jboss.arquillian.core.api.annotation.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class CategoryDAOImpl implements CategoryDAO {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private Category category;

    public CategoryDAOImpl() {
    }

    @Override
    public Category read(String categoryName) {
        throw new NotImplementedException();
    }

    @Override
    public List<Category> getCategories(String categoryId) {
        throw new NotImplementedException();
    }

    @Override
    @Transactional
    public List<Category> getAllCategories() {
        String sql = "SELECT c FROM Category c";
        TypedQuery<Category> query = em.createQuery(sql, Category.class);

        return query.getResultList();
    }
}
