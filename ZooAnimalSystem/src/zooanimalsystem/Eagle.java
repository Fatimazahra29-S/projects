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
public class Eagle extends Birds{
  
      public Eagle(int zooID) {
        super(zooID);
    }
    
       public Eagle(int zooID,String name) {
        super(zooID,name);
    }
         public Eagle (int zooID , String name,String birthPlace ,String imagePath, String type ,String vaccination,String birthDate,int keeperID){
            super(zooID,name,birthPlace,imagePath,type,vaccination,birthDate,keeperID);
           vaccinations = new ArrayList<Vaccination>();
    }
     public Eagle (int zooID , String name,String birthPlace ,String imagePath, String type ,String vaccination,String birthDate){
            super(zooID,name,birthPlace,imagePath,type,vaccination,birthDate);
           vaccinations = new ArrayList<Vaccination>();
    }
    @Override
    void makeSound() {
      System.out.println("The Eagle Sound: Screech  ");   
    }

    @Override
    void run() {
        System.out.println("The Eagle can't running "); 
    }
    
    @Override
    void fly() {
         System.out.println("The Eagle can fly "); 
    }
    
    @Override
    void eat() {
        System.out.println("The Eagle is eating "); 
    }

    @Override
    void sleep() {
        System.out.println("The Eagle is sleeping "); 
    }
}
