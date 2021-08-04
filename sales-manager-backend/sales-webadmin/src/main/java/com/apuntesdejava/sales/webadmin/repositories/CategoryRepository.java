package com.apuntesdejava.sales.webadmin.repositories;

import com.apuntesdejava.sales.model.Category;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author Diego Silva <diego.silva at apuntesdejava.com>
 */
@ApplicationScoped
public class CategoryRepository {

    @Inject
    private EntityManager em;

    public List<Category> findAll() {
        return em.createQuery("select c from Category c", Category.class).getResultList();
    }
}
