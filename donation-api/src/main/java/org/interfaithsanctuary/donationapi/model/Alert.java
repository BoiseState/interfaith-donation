package org.interfaithsanctuary.donationapi.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "alerts")
public class Alert {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int alert_id;

    @Column(name = "alert_title")
    private String title;

    @Column(name = "alert_body")
    private String body;

//    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "callout_id")
    private int callout_id;

//    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "need_id")
    private int need_id;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "last_pushed_date")
    private Date lastPushedDate;

    public int getAlert_id() {
        return alert_id;
    }

    public void setAlert_id(int alert_id) {
        this.alert_id = alert_id;
    }

    public String getAlert_title() {
        return title;
    }

    public void setAlert_title(String alert_title) {
        this.title = alert_title;
    }

    public String getAlert_body() {
        return body;
    }

    public void setAlert_body(String alert_body) {
        this.body = alert_body;
    }

    public int getCallout_id() {
        return callout_id;
    }

    public void setCallout_id(int callout_id) {
        this.callout_id = callout_id;
    }

    public int getNeed_id() {
        return need_id;
    }

    public void setNeed_id(int need_id) { this.need_id = need_id; }

    public Date getCreate_date() {
        return createDate;
    }

    public void setCreate_date(Date create_date) {
        this.createDate = create_date;
    }

    public Date getLast_pushed_date() {
        return lastPushedDate;
    }

    public void setLast_pushed_date(Date last_pushed_date) {
        this.lastPushedDate = last_pushed_date;
    }
}