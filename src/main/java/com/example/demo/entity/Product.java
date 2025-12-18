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
        this.brand=brand;
    }
    public String getmodelNumber(){
        return modelNumber;
    }
    public void setmodelNumber(String modelNumber){
        this.modelNumber=modelNumber;
    }
    public String getcategory(){
        return category;
    }
    public void setcategory(String category){
        this.category=category;
    }

  public Product(String name,Long id,String brand,String modelNumber,String category){
        this.name=name;
        this.id=id;
        this.brand=brand;
        this.modelNumber=modelNumber;
        this.category=category;
    }
    public Product(){
    }
}