package com.goJek.parking.model;

public abstract class Vehicle {

    private String licensePlate;
    private String color;

    public Vehicle(String licensePlate,String color)
    {
        this.licensePlate = licensePlate;
        this.color = color;
    }
}
