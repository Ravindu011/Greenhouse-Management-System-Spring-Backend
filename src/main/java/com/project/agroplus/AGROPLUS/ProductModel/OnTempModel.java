package com.project.agroplus.AGROPLUS.ProductModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class OnTempModel {
    @Id
    private Long id;
    private int temp;
    private int humidity;

    public OnTempModel() {
    }
    public OnTempModel(int temp, int humidity,long id) {
        this.id = id;
        this.temp = temp;
        this.humidity = humidity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public int getHum() {
        return humidity;
    }

    public void setHum(int humidity) {
        this.humidity = humidity;
    }
}
