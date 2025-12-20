package com.example.demo.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder 
public class AlertLog {

        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private Long id;
         @ManyToOne

        private Warranty warranty;

       private LocalDateTime alertDate;
       private String message;
     private LocalDateTime createdAt;
     private LocalDateTime updatedAt;
     @PrePersist
 
    public void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        if(createdAt==null){
         this.createdAt = now;
        }
       
        this.updatedAt = now;
    }
     @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}