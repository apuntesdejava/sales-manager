package com.apuntesdejava.sales.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Diego Silva <diego.silva at apuntesdejava.com>
 */
@Entity
@Table(name = "measurement_convert")
public class MeasurementConvert implements Serializable {

    @EmbeddedId
    private MeasurementConvertId id;

    @ManyToOne
    @JoinColumn(
            name = "unit_source",
            referencedColumnName = "measurement_id",
            insertable = false,
            updatable = false
    )
    private MeasurementUnit source;

    @ManyToOne
    @JoinColumn(
            name = "unit_target",
            referencedColumnName = "measurement_id",
            insertable = false,
            updatable = false
    )
    private MeasurementUnit target;

    @Column(name = "convert_value")
    private double convert;

    public MeasurementConvertId getId() {
        return id;
    }

    public void setId(MeasurementConvertId id) {
        this.id = id;
    }

    public MeasurementUnit getSource() {
        return source;
    }

    public void setSource(MeasurementUnit source) {
        this.source = source;
    }

    public MeasurementUnit getTarget() {
        return target;
    }

    public void setTarget(MeasurementUnit target) {
        this.target = target;
    }

    public double getConvert() {
        return convert;
    }

    public void setConvert(double convert) {
        this.convert = convert;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.id);
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
        final MeasurementConvert other = (MeasurementConvert) obj;
        return Objects.equals(this.id, other.id);
    }

}
