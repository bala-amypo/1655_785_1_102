package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.Column;
import java.time.LocalDate;
import jakarta.persistence.ManyToOne;
@Entity
public class Warranty{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Product product;
    private LocalDate purchaseDate;
    private LocalDate expiryDate;
    @Column(unique=true)
    private String serialNumber;


















    
}