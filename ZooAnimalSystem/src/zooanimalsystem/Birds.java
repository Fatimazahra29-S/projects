/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zooanimalsystem;

import java.util.ArrayList;

/**
 *
 * @author USER-Q
 */
public class Birds extends Animals{

    
    public Birds (int zooID){
    this.zooID=zooID;
        
    }
    
      public Birds (int zooID , String name){
    this.zooID=zooID;
     this.name=name;
      }
      
     public Birds (int zooID , String name,String birthPlace ,String imagePath, String type ,String vaccination,String birthDate,int keeperID){
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
         public Birds (int zooID , String name,String birthPlace ,String imagePath, String type ,String vaccination,String birthDate){
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
      System.out.println("Birds make their sounds ");   
    }

    @Override
    void run() {
        System.out.println("Birds can't running "); 
    }
    
    @Override
    void fly() {
         System.out.println("Birds can fly "); 
    }
    
    @Override
    void eat() {
        System.out.println("Birds are eating "); 
    }

    @Override
    void sleep() {
        System.out.println("Birds are sleeping "); 
    }


  
 
}
