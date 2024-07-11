package com.example._5.dto;


import com.example._5.model.Phone;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhoneDTO {

    private String name;

    private double price;

    private int ram;

    private int memory;

    private int batteryCapacity;

    private String operationSystem;

    private double display;


    public PhoneDTO() {
    }

    public PhoneDTO(Phone phone){
        this.name = phone.getName();
        this.price = phone.getPrice();
        this.ram = phone.getRam();
        this.memory = phone.getMemory();
        this.batteryCapacity = phone.getBatteryCapacity();
        this.operationSystem = phone.getOperationSystem();
        this.display = phone.getDisplay();
    }
}
