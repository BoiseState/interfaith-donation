package org.interfaithsanctuary.donationapi.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "callouts")
public class Callout {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long callout_id;

    @Column(name = "callout_title")
    private String title;

    @Column(name = "callout_body")
    private String body;

    @Column(name = "callout_url")
    private String url;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_date")
    private Date updateDate;

    @Column()
    private Boolean active;

    @Column()
    private Boolean pinned;

    public Long getCallout_id() {
        return callout_id;
    }

    public void setCallout_id(Long callout_id) {
        this.callout_id = callout_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getPinned() {
        return pinned;
    }

    public void setPinned(Boolean pinned) {
        this.pinned = pinned;
    }
}
