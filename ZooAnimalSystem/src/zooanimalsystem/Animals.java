/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zooanimalsystem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author USER-Q
 */
class Vaccination {

    String name;
    Date vaccinationDate;

    public Vaccination(String name, Date vaccinationDate) {
        this.name = name;
        this.vaccinationDate = vaccinationDate;
    }
}

public abstract class Animals {

    int zooID;
    String name;
    String birthDate;
    List vaccinations;
    String birthPlace;
    String imagePath;
    int keeperID; 
    String type;
 String vaccination;
    abstract void makeSound();

    abstract void run();

    abstract void eat();

    abstract void sleep();
    abstract void fly();

     public boolean isVaccinations(){
    if(vaccinations.isEmpty())
        return false;
    else 
        return true;
    }

      public String gettype(){
    
        return this.type;
    }
      public void settype(String type){
     this.type=type;
         
     };
        public String getvaccination(){
    
        return this.vaccination;
    }
      public void setvaccination(String vaccination){
     this.vaccination=vaccination;
         
     };
      
    public void setname(String name){
     this.name=name;
         
     };

      public int getZooID(){
    
        return this.zooID;
    }
      
    public String getname(){
    
        return this.name;
    }

    public void setBirthDate(String birthDate){
     this.birthDate=birthDate;
         
     };

    public String getBirthDate(){
    
        return this.birthDate;
    }
    

    public void setBirthPlace(String birthPlace){
     this.birthPlace=birthPlace;
         
     };

    public String getBirthPlace(){
    
        return this.birthPlace;
    }
    

    public void setImagePath(String imagePath){
     this.imagePath=imagePath;
         
     };

    public String getImagePath(){
    
        return this.imagePath;
    }
    
     public void setKeeperID(int keeperID){
     this.keeperID=keeperID;
         
     };


    public int getKeeperID(){
    
        return this.keeperID;
    }
    

    public void addNewVaccination(String name, Date VaccinationDate){
    
        vaccinations.add(new Vaccination(name,VaccinationDate) );
        System.out.println("The Addition of Vaccination is success! ");
    }

}
