package com.kargo.transporter;

import java.util.Date;

public class JobData {
    private Date date;
    private String origin;
    private String destination;
    private int price;

    public JobData() {
    }

    public JobData(Date date, String origin, String destination, int price) {
        this.date = date;
        this.origin = origin;
        this.destination = destination;
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
