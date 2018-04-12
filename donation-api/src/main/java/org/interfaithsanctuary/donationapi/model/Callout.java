package org.interfaithsanctuary.donationapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "callouts")
public class Callout {

    @Id
    @SequenceGenerator(name="seq", initialValue=300, allocationSize=50)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @Column(name = "callout_id", nullable=false, unique = true)
    private Long id;

    @Column(name = "callout_name")
    private String name;

    @Column(name = "callout_effective_date")
    private Date effectiveDate;

    @Column(name = "callout_active")
    private boolean active;

    @Column(name = "callout_date_created")
    private Date createdDate;

    @Column(name = "callout_description_message")
    private String descriptionMessage;

    @OneToMany(mappedBy = "callout", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<CalloutNeed> calloutNeeds;

    public Long getId() {
        return id;
    }
//
////    public void setId(Long id) {
////        this.id = id;
////    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEffectiveDate() { return effectiveDate; }

    public void setEffectiveDate(Date effectiveDate) { this.effectiveDate = effectiveDate; }

    public boolean isActive() { return active; }

    public void setActive(boolean active) { this.active = active; }

    public Date getCreatedDate() { return createdDate; }

    public String getDescriptionMessage() { return descriptionMessage; }

    public void setDescriptionMessage(String descriptionMessage) { this.descriptionMessage = descriptionMessage; }

    public Set<CalloutNeed> getCalloutNeeds() { return calloutNeeds; }

    public void setCalloutNeeds(Set<CalloutNeed> calloutNeeds) { this.calloutNeeds = calloutNeeds; }
}
