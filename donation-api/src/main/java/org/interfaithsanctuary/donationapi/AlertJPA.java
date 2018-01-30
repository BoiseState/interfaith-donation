package org.interfaithsanctuary.donationapi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Alert {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int alert_id;
    private String alert_title;
    private String alert_body;
    private int callout_id;
    private int need_id;
    private Date create_date;
    private Date last_pushed_date;
}