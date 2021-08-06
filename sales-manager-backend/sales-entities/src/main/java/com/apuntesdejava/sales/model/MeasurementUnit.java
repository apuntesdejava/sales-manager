package com.apuntesdejava.sales.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Diego Silva <diego.silva at apuntesdejava.com>
 */
@Entity
@Table(name = "measurement_unit")
public class MeasurementUnit implements Serializable {

    @Id
    @Column(length = 5, name = "measurement_id")
    private String measurementId;

    @Column(length = 20)
    private String name;

    public String getMeasurementId() {
        return measurementId;
    }

    public void setMeasurementId(String measurementId) {
        this.measurementId = measurementId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.measurementId);
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
        final MeasurementUnit other = (MeasurementUnit) obj;
        return Objects.equals(this.measurementId, other.measurementId);
    }

}
