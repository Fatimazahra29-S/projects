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
public class Panda extends Mammals{
    
     public Panda(int zooID) {
        super(zooID);
    }
     
    public Panda(int zooID, String name) {
        super(zooID, name);
    }
      public Panda (int zooID , String name,String birthPlace ,String imagePath, String type ,String vaccination,String birthDate,int keeperID){
            super(zooID,name,birthPlace,imagePath,type,vaccination,birthDate,keeperID);
           vaccinations = new ArrayList<Vaccination>();
    }
        public Panda (int zooID , String name,String birthPlace ,String imagePath, String type ,String vaccination,String birthDate){
            super(zooID,name,birthPlace,imagePath,type,vaccination,birthDate);
           vaccinations = new ArrayList<Vaccination>();
    }
     @Override
    void makeSound() {
      System.out.println("The Panda Sound: Bleat ");   
    }

    @Override
    void run() {
        System.out.println("The Panda can running "); 
    }
    
    @Override
    void fly() {
         System.out.println("The Panda can't fly "); 
    }
    
    @Override
    void eat() {
        System.out.println("The Panda is eating "); 
    }

    @Override
    void sleep() {
        System.out.println("The Panda is sleeping Zzz "); 
    }
}
