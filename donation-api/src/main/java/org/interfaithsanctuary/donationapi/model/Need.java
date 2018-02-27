package org.interfaithsanctuary.donationapi.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "needs")
public class Need {

    @Id
    @Column(name = "need_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long needId;

    @Column(name = "need_name")
    private String name;

    @Column(name = "need_url")
    private String url;

    @Column(name = "need_description")
    private String description;

    @Column(name = "create_date")
    private Date date;

    @Column(name = "need_quantity")
    private Integer quantity;

    @Transient
    //@Column(name = "need_num_gifts")
    private Integer numGifts;

    @Column(name = "need_unit")
    private String unit;

    @Column(name = "callout_id")
    private Long calloutId;

    @Column
    private boolean active;

    public Long getNeedId() {
        return needId;
    }

    public void setNeedId(Long needId) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getNumGifts() {
        return numGifts;
    }

    public void setNumGifts(Integer numGifts) {
        this.numGifts = numGifts;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Long getCalloutId() {
        return calloutId;
    }

    public void setCalloutId(Long calloutId) {
        this.calloutId = calloutId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
