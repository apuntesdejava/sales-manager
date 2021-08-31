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
package com.apuntesdejava.sales.webadmin.view;

import com.apuntesdejava.sales.model.MeasurementUnit;
import com.apuntesdejava.sales.services.MeasurementUnitService;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author diego
 */
@Named
public class MeasurementUnitController {

    @Inject
    private MeasurementUnitService service;

    public List<MeasurementUnit> getMeasurementUnitList() {
        return service.listAll();
    }
}
