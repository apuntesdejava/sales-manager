package com.apuntesdejava.sales.webadmin.view;

import com.apuntesdejava.sales.model.Category;
import com.apuntesdejava.sales.webadmin.repositories.CategoryRepository;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Diego Silva <diego.silva at apuntesdejava.com>
 */
@Named(value = "categoryController")
@SessionScoped
public class CategoryController implements Serializable {

    @Inject
    private CategoryRepository repository;

    /**
     * Creates a new instance of CategoryController
     */
    public CategoryController() {
    }

    public List<Category> getCategoriesList() {
        return repository.findAll();
    }

}
