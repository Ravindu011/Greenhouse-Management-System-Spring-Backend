package com.project.agroplus.AGROPLUS.ProductModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ProductModel {

    @Id
    @GeneratedValue
    private Long PID;

    private String pName;
    private int temp;
    private int humidity;
    private int daysToGrow;
    private String status;

    public Long getPID() {
        return PID;
    }

    public void setPID(Long PID) {
        this.PID = PID;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getDaysToGrow() {
        return daysToGrow;
    }

    public void setDaysToGrow(int daysToGrow) {
        this.daysToGrow = daysToGrow;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
