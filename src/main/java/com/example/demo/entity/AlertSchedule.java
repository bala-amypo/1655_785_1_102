package com.example.demo.entity;



@Entity
public class AlertSchedule{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Warranty warranty;
    private  brand;
    private String modelNumber;
    private String category;

}