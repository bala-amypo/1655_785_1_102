package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;


@Entity
public class Product{
     @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String brand;
    private String modelNumber;
    private String category;

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }

    public String getBrand(){
        return brand;
    }
    public void setBrand(String brand){
        this.brand=email;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public String getRole(){
        return role;
    }
    public void setRole(String role){
        this.role=role;
    }

  public Product(String name,Long id,String email,String password,String role){
        this.name=name;
        this.id=id;
        this.email=email;
        this.password=password;
        this.role=role;
    }
    public Product(){
    }
}