/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zooanimalsystem;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER-Q
 */
public class Mammals extends Animals {
    
    public Mammals (int zooID){
    this.zooID=zooID;
        
    }
     public Mammals (int zooID , String name){
    this.zooID=zooID;
     this.name=name;
    }
   public Mammals (int zooID , String name,String birthPlace ,String imagePath, String type ,String vaccination,String birthDate,int keeperID){
    this.zooID=zooID;
     this.name=name;
        this.birthDate=birthDate;
        this.birthPlace=birthPlace;
        this.imagePath =imagePath;
        this.type=type;
        this.vaccination=vaccination;
        this.keeperID=keeperID;
     vaccinations = new ArrayList<Vaccination>();

    }
   public Mammals (int zooID , String name,String birthPlace ,String imagePath, String type ,String vaccination,String birthDate){
    this.zooID=zooID;
     this.name=name;
        this.birthDate=birthDate;
        this.birthPlace=birthPlace;
        this.imagePath =imagePath;
        this.type=type;
        this.vaccination=vaccination;
        
     vaccinations = new ArrayList<Vaccination>();

    }

  @Override
    void makeSound() {
      System.out.println("Mammals make their sounds ");   
    }

    @Override
    void run() {
        System.out.println("Mammals can running "); 
    }
    
    @Override
    void fly() {
         System.out.println("Mammals can't fly "); 
    }
    
    @Override
    void eat() {
        System.out.println("Mammals are eating "); 
    }

    @Override
    void sleep() {
        System.out.println("Mammals are sleeping "); 
    }

}
