package org.interfaithsanctuary.donationapi.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "donors")
public class Donor {
    @Id
    @Column(name = "donor_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long donorId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "donor_name")
    private String name;
    
    @Column(name = "donor_diplayName")
    private String displayName;

    @Column(name = "donor_email")
    private String email;

    @Column(name = "donor_address")
    private String address;

    @Column(name = "donor_city")
    private String city;

    @Column(name = "donor_state")
    private String state;

    @Column(name = "donor_zip")
    private String zip;

    @Column(name = "donor_phone")
    private String phone;

    @Column(name = "donor_join_date")
    private Date joinDate;

    public Long getDonorId() {
        return donorId;
    }

    public void setDonorId(Long donorId) {
        this.donorId = donorId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }
}

