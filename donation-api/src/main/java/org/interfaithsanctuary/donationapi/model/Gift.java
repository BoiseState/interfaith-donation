package org.interfaithsanctuary.donationapi.model;

import java.util.Date;
import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "gifts")
public class Gift {
    @Id
    //@Column(name = "gift_id")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name="gift_id", sequenceName="gift_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="gift_id")
    private long giftId;

    @Column(name = "gift_quantity")
    private int quantity;

    @Column(name = "gift_date")
    private Date giftDate;

    @Column(name = "donor_id")
    private int donorId;

    @Column(name = "need_id")
    private int needId;

    public Gift() {
        super();
    }

    public Gift(int giftId, int quantity, Date giftDate, int donorId, int needId) {
        super();
        this.giftId = giftId;
        this.quantity = quantity;
        this.giftDate = giftDate;
        this.donorId = donorId;
        this.needId = needId;
    }

    public long getGiftId() {
        return giftId;
    }

    public void setGiftId(long giftId) {
        this.giftId = giftId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getGiftDate() {
        return giftDate;
    }

    public void setGiftDate(Date giftDate) {
        this.giftDate = giftDate;
    }

    public int getDonorId() {
        return donorId;
    }

    public void setDonorId(int donorId) {
        this.donorId = donorId;
    }

    public int getNeedId() {
        return needId;
    }

    public void setNeedId(int needId) {
        this.needId = needId;
    }

}