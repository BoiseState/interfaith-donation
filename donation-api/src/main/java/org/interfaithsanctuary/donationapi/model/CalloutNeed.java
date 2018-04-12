package org.interfaithsanctuary.donationapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * This object describes the many-many relationship that a Need can have with a Callout.
 */
@Entity
@Table(name = "calloutneeds")
public class CalloutNeed implements Serializable {

    @Id
    @SequenceGenerator(name="seq", initialValue=300, allocationSize=50)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @Column(name = "calloutneed_id", nullable=false, unique = true)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="need_id")
    @JsonBackReference
    private Need need;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="callout_id")
    //@JsonBackReference
    private Callout callout;

    @Column(name = "calloutneed_active")
    private boolean active;

    @Column(name = "calloutneed_quantity")
    private int quantity;

//    @OneToMany(mappedBy = "calloutNeed", cascade = CascadeType.ALL)
//    @JsonManagedReference
//    private Set<Donation> donations;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Need getNeed() {
//        return need;
//    }
//
//    public void setNeed(Need need) {
//        this.need = need;
//    }

    public Callout getCallout() {
        return callout;
    }

    public void setCallout(Callout callout) {
        this.callout = callout;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

//    public Set<Donation> getDonations() {
//        return donations;
//    }
//
//    public void setDonations(Set<Donation> donations) {
//        this.donations = donations;
//    }
}
