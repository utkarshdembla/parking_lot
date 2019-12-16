package com.goJek.parking.model;

public abstract class Vehicle {

    private String licensePlate;
    private String color;

    public Vehicle(String licensePlate,String color)
    {
        this.licensePlate = licensePlate;
        this.color = color;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
