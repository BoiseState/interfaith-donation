package org.interfaithsanctuary.donationapi.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "alerts")
public class Alert {

    @Id
    @Column(name = "alert_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "alert_title")
    private String title;

    @Column(name = "alert_body")
    private String body;

//    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "callout_id")
    private Integer calloutId;

//    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "need_id")
    private Integer needId;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "last_pushed_date")
    private Date lastPushedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlert_title() {
        return title;
    }

    public void setAlertTitle(String alertTitle) {
        this.title = alertTitle;
    }

    public String getAlertBody() {
        return body;
    }

    public void setAlertBody(String alert_body) {
        this.body = alert_body;
    }

    public Integer getCalloutId() {
        return calloutId;
    }

    public void setCalloutId(Integer calloutId) {
        this.calloutId = calloutId;
    }

    public Integer getNeedId() {
        return needId;
    }

    public void setNeed_id(Integer needId) { 
    		this.needId = needId; 
    	}

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastPushedDate() {
        return lastPushedDate;
    }

    public void setLastPushedDate(Date lastPushedDate) {
        this.lastPushedDate = lastPushedDate;
    }
}