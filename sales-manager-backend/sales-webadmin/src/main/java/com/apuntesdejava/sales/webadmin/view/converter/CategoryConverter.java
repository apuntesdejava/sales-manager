/*
 * Copyright 2021 diego.
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
package com.apuntesdejava.sales.webadmin.view.converter;

import com.apuntesdejava.sales.model.Category;
import com.apuntesdejava.sales.webadmin.services.CategoryService;
import java.util.Optional;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

/**
 *
 * @author diego
 */
@Named
@FacesConverter(value = "categoryConverter", managed = true)
public class CategoryConverter implements Converter<Category> {

    @EJB
    private CategoryService service;

    @Override
    public Category getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isBlank()) {
            return null;
        }
        Optional<Category> category = service.findById(Long.parseLong(value));
        if (category.isEmpty()) {
            return null;
        }
        return category.get();
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Category value) {
        return value == null ? null : String.valueOf(value.getId());
    }

}
