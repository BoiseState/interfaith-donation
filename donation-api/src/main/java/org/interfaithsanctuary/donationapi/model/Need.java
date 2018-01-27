package org.interfaithsanctuary.donationapi.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "needs")
public class Need {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int need_id;

    @Column(name = "need_name")
    private String name;

    @Column(name = "need_url")
    private String url;

    @Column(name = "need_description")
    private String description;

    @Column(name = "create_date")
    private Date date;

    @Column(name = "need_quantity")
    private int quantity;

    @Transient
    //@Column(name = "need_num_gifts")
    private int numGifts;

    @Column(name = "need_unit")
    private String unit;

    @Column(name = "callout_id")
    private int calloutId;

    @Column
    private boolean active;

    public int getNeed_id() {
        return need_id;
    }

    public void setNeed_id(int need_id) {
        this.need_id = need_id;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getNumGifts() {
        return numGifts;
    }

    public void setNumGifts(int numGifts) {
        this.numGifts = numGifts;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getCalloutId() {
        return calloutId;
    }

    public void setCalloutId(int calloutId) {
        this.calloutId = calloutId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
