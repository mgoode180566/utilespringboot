package com.mgoode.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by michaelgoode on 25/01/2017.
 */

@Entity
@Table(name = "GAS")
public class Gas implements Serializable {
    @Id
    @GeneratedValue
    @Column(name="id")
    Long id;

    @Column(name="name")
    String name;

    @Column(name="specificgravity")
    String specificGravity;

    @Column(name="polytropicindex")
    String polytropicIndex;

    @Column(name="molecularweight")
    String molecularWeight;

    @Column(name="defaulttemp")
    String defaulttemp;

    @Column(name="gastype")
    String gasType;

    @Column(name="multiplier1")
    String multiplier1;

    @Column(name="multiplier2")
    String multiplier2;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecificGravity() {
        return specificGravity;
    }

    public void setSpecificGravity(String specificGravity) {
        this.specificGravity = specificGravity;
    }

    public String getPolytropicIndex() {
        return polytropicIndex;
    }

    public void setPolytropicIndex(String polytropicIndex) {
        this.polytropicIndex = polytropicIndex;
    }

    public String getMolecularWeight() {
        return molecularWeight;
    }

    public void setMolecularWeight(String molecularWeight) {
        this.molecularWeight = molecularWeight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGasType() {
        return gasType;
    }

    public void setGasType(String gasType) {
        this.gasType = gasType;
    }

    public String getDefaulttemp() {
        return defaulttemp;
    }

    public void setDefaulttemp(String defaulttemp) {
        this.defaulttemp = defaulttemp;
    }

    public String getMultiplier1() {
        return multiplier1;
    }

    public void setMultiplier1(String multiplier1) {
        this.multiplier1 = multiplier1;
    }

    public String getMultiplier2() {
        return multiplier2;
    }

    public void setMultiplier2(String multiplier2) {
        this.multiplier2 = multiplier2;
    }

    public Gas() {
    }

    public Gas(String name, String specificGravity, String polytropicIndex, String molecularWeight, String defaulttemp,  String multiplier1, String multiplier2, String gasType) {
        this.name = name;
        this.specificGravity = specificGravity;
        this.polytropicIndex = polytropicIndex;
        this.molecularWeight = molecularWeight;
        this.defaulttemp = defaulttemp;
        this.gasType = gasType;
        this.multiplier1 = multiplier1;
        this.multiplier2 = multiplier2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gas gas = (Gas) o;

        if (id != null ? !id.equals(gas.id) : gas.id != null) return false;
        if (name != null ? !name.equals(gas.name) : gas.name != null) return false;
        if (specificGravity != null ? !specificGravity.equals(gas.specificGravity) : gas.specificGravity != null)
            return false;
        if (polytropicIndex != null ? !polytropicIndex.equals(gas.polytropicIndex) : gas.polytropicIndex != null)
            return false;
        if (molecularWeight != null ? !molecularWeight.equals(gas.molecularWeight) : gas.molecularWeight != null)
            return false;
        if (defaulttemp != null ? !defaulttemp.equals(gas.defaulttemp) : gas.defaulttemp != null) return false;
        if (gasType != null ? !gasType.equals(gas.gasType) : gas.gasType != null) return false;
        if (multiplier1 != null ? !multiplier1.equals(gas.multiplier1) : gas.multiplier1 != null) return false;
        return multiplier2 != null ? multiplier2.equals(gas.multiplier2) : gas.multiplier2 == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (specificGravity != null ? specificGravity.hashCode() : 0);
        result = 31 * result + (polytropicIndex != null ? polytropicIndex.hashCode() : 0);
        result = 31 * result + (molecularWeight != null ? molecularWeight.hashCode() : 0);
        result = 31 * result + (defaulttemp != null ? defaulttemp.hashCode() : 0);
        result = 31 * result + (gasType != null ? gasType.hashCode() : 0);
        result = 31 * result + (multiplier1 != null ? multiplier1.hashCode() : 0);
        result = 31 * result + (multiplier2 != null ? multiplier2.hashCode() : 0);
        return result;
    }
}
