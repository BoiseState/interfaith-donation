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
    private Long giftId;

    @Column(name = "gift_quantity")
    private int quantity;

    @Column(name = "gift_date")
    private Date giftDate;

    @Column(name = "donor_id")
    private Long donorId;

    @Column(name = "need_id")
    private Long needId;

    public Gift() {
        super();
    }

    public Gift(Long giftId, int quantity, Date giftDate, Long donorId, Long needId) {
        super();
        this.giftId = giftId;
        this.quantity = quantity;
        this.giftDate = giftDate;
        this.donorId = donorId;
        this.needId = needId;
    }

    public Long getGiftId() {
        return giftId;
    }

    public void setGiftId(Long giftId) {
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

    public Long getDonorId() {
        return donorId;
    }

    public void setDonorId(Long donorId) {
        this.donorId = donorId;
    }

    public Long getNeedId() {
        return needId;
    }

    public void setNeedId(Long needId) {
        this.needId = needId;
    }

}