/*
 * Copyright 2021 Diego Silva <diego.silva at apuntesdejava.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.apuntesdejava.sales.webadmin.view;

import com.apuntesdejava.sales.model.Category;
import com.apuntesdejava.sales.webadmin.services.CategoryService;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Diego Silva <diego.silva at apuntesdejava.com>
 */
@Named(value = "categoryController")
@SessionScoped
public class CategoryController implements Serializable {

    @EJB
    private CategoryService service;

    private Category categoryCurrent;

    /**
     * Creates a new instance of CategoryController
     */
    public CategoryController() {
    }

    public List<Category> getCategoriesList() {
        return service.listAll();
    }

    public Category getCategoryCurrent() {
        return categoryCurrent;
    }

    public void setCategoryCurrent(Category categoryCurrent) {
        this.categoryCurrent = categoryCurrent;
    }
    
    public void onCloseDialog(){
        
    }

    public void categoryNewCommand() {
        categoryCurrent = new Category();
        PrimeFaces.current().dialog().openDynamic("/categories/form", Map.of("modal", true), null);
    }

    public void save() {
        if (categoryCurrent.getId() == 0) {
            var model = service.create(categoryCurrent);
            PrimeFaces.current().dialog().closeDynamic(model);
        }
        
    }

}
