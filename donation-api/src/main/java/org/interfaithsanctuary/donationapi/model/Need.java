package org.interfaithsanctuary.donationapi.model;

import javax.persistence.*;

@Entity
@Table(name = "needs")
public class Need {

    @Id
    @Column(name = "need_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int needId;

    @Column(name = "need_name")
    private String name;

    @Column(name = "need_url")
    private String url;

    @Column(name = "need_description")
    private String description;

    @Column(name = "need_unit_of_measurement")
    private String unitOfMeasurement;

    public int getNeedId() {
        return needId;
    }

    public void setNeedId(int needId) {
        this.needId = needId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unitOfMeasurement;
    }

    public void setUnit(String unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }
}
