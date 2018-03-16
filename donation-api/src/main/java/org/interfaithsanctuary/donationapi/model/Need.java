package org.interfaithsanctuary.donationapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "needs")
public class Need {

    @Id
    @Column(name = "need_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "need_name")
    private String name;

    @Column(name = "need_url")
    private String url;

    @Column(name = "need_description")
    private String description;

    @Column(name = "need_unit_of_measurement")
    private String unitOfMeasurement;

    @OneToMany (mappedBy = "need", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<CalloutNeed> calloutNeeds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public void setUnitOfMeasurement(String unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }

    public Set<CalloutNeed> getCalloutNeeds() {
        return calloutNeeds;
    }

    public void setCalloutNeeds(Set<CalloutNeed> calloutNeeds) {
        this.calloutNeeds = calloutNeeds;
    }
}
