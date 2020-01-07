package com.zygstore.model.db;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.zygstore.model.Product;
import com.zygstore.model.dao.ProductDAO;
import org.springframework.transaction.annotation.Transactional;

/**
 * Place description here.
 *
 * @author y08l@nykredit.dk
 */

public class ProductDAOImpl implements ProductDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Product read(String productName) {
        return null;
    }

    @Override
    public List<Product> getProducts(Long categoryId) {
        return null;
    }

    @Override
    @Transactional
    public List<Product> getAllProducts() {
        String sql = "SELECT c FROM Product c";
        TypedQuery<Product> query = em.createQuery(sql, Product.class);

        return query.getResultList();
    }
}
