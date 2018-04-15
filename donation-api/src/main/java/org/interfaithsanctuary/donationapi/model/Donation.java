package org.interfaithsanctuary.donationapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

/**
 * This object describes the many-many relationship that a Donation can have with a Callout.
 */
@Entity
@Table(name = "donations")
public class Donation {

    @Id
    @Column(name = "donation_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name="calloutneed_id")
//    @JsonBackReference
//    private CalloutNeed calloutNeed;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name="donor_id")
//    @JsonBackReference
//    private Donor donor;

    @Column(name = "donation_date")
    private Date date;

    @Column(name = "donation_quantity")
    private Integer quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public CalloutNeed getCalloutNeed() { return calloutNeed; }

//    public void setCalloutNeed(CalloutNeed calloutNeed) { this.calloutNeed = calloutNeed; }

//    public Donor getDonor() {
//        return donor;
//    }

//    public void setDonor(Donor donor) {
//        this.donor = donor;
//    }

    public Date isDate() {
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
}
