package org.interfaithsanctuary.donationapi.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "alerts")
public class Alert {
    @Id
    @Column(name = "alert_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int alertId;

    @Column(name = "alert_title")
    private String title;

    @Column(name = "alert_body")
    private String body;

//    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "callout_id")
    private int calloutId;

//    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "need_id")
    private int needId;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "last_pushed_date")
    private Date lastPushedDate;

    public int getAlertId() {
        return alertId;
    }

    public void setAlertId(int alertId) {
        this.alertId = alertId;
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

    public int getCalloutId() {
        return calloutId;
    }

    public void setCalloutId(int calloutId) {
        this.calloutId = calloutId;
    }

    public int getNeedId() {
        return needId;
    }

    public void setNeed_id(int needId) { 
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