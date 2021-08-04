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
package com.apuntesdejava.sales.model;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Diego Silva <diego.silva at apuntesdejava.com>
 */
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
@Setter
@Getter
public abstract class Person implements Serializable {

    @EmbeddedId
    private PersonId id;

    @ManyToOne
    @JoinColumn(name = "type_person", updatable = false, insertable = false, referencedColumnName = "type_person_id")
    private TypePerson typePerson;

    @Column(name = "first_name", length = 100)
    private String firstName;

    @Column(name = "last_name", length = 100)
    private String lastName;

    @ElementCollection
    @CollectionTable(
            name = "person_address"
    )
    @MapKeyColumn(name = "address_type", insertable = false, updatable = false, length = 20)
    private Map<String, PersonAddress> addresses;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        return Objects.equals(this.id, other.id);
    }

}
