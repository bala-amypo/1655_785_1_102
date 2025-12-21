package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder 

public class Warranty {
     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
     
    private Product product;

    @ManyToOne
    
    private User user;

    private LocalDate purchaseDate;
    private LocalDate expiryDate;
     @Column(unique=true)
    private String serialNumber;

   

}
