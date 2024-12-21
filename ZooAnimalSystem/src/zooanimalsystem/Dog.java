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
public class Dog extends Mammals{
   
     public Dog(int zooID) {
        super(zooID);
    }
     
    public Dog(int zooID, String name) {
        super(zooID, name);
    }
 
    public Dog (int zooID , String name,String birthPlace ,String imagePath, String type ,String vaccination,String birthDate,int keeperID){
            super(zooID,name,birthPlace,imagePath,type,vaccination,birthDate,keeperID);
           vaccinations = new ArrayList<Vaccination>();
    }
 public Dog (int zooID , String name,String birthPlace ,String imagePath, String type ,String vaccination,String birthDate){
            super(zooID,name,birthPlace,imagePath,type,vaccination,birthDate);
           vaccinations = new ArrayList<Vaccination>();
    }
    
     @Override
    void makeSound() {
      System.out.println("The Dog Sound: Bark  ");   
    }

    @Override
    void run() {
        System.out.println("The Dog can running "); 
    }
    
    @Override
    void fly() {
         System.out.println("The Dog can't fly "); 
    }
    
    @Override
    void eat() {
        System.out.println("The Dog is eating "); 
    }

    @Override
    void sleep() {
        System.out.println("The Dog is sleeping Zzz "); 
    }
    
}
