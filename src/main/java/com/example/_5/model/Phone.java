package com.example._5.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "phone")
@NoArgsConstructor
@Getter
@Setter
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double price;

    private int ram;

    private int memory;

    private int batteryCapacity;

    private String operationSystem;

    private double display;

    @ManyToMany(mappedBy = "phones")
    private List<User> users;

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", ram=" + ram +
                ", memory=" + memory +
                ", batteryCapacity=" + batteryCapacity +
                ", operationSystem='" + operationSystem + '\'' +
                ", display=" + display +
                '}';
    }
}
