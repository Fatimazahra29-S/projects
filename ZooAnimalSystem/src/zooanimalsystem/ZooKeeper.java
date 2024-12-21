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
public class ZooKeeper {
  int ID;
  String  name;
 SimpleDateFormat birthDate;
  String qualifications;
  String hireDate ;
   List AnimalsList = new ArrayList<Animals>();
   
    public ZooKeeper (int ID){
    this.ID=ID;
        
    }
     public ZooKeeper (int ID , String name){
    this.ID=ID;
     this.name=name;
    }
  
     
     
      public int getZooID(){
    
        return this.ID;
    }
     
      
    public void setname(String name){
     this.name=name;
         
     };
 
    public String getname(){
    
        return this.name;
    }
    
       public void setQualifications(String qualifications){
     this.qualifications=qualifications;
         
     };
 
    public String getQualifications(){
    
        return this.qualifications;
    }
    

    public void setBirthDate(SimpleDateFormat birthDate){
     this.birthDate=birthDate;
         
     };

    public SimpleDateFormat getBirthDate(){
    
        return this.birthDate;
    }
    

    public void setHireDate(String hireDate){
     this.hireDate=hireDate;
         
     };

    public String getHireDate(){
    
        return this.hireDate;
    }
    
    
    public void addNewAnimalMammals(int zooID ,String name){
    
        AnimalsList.add(new Mammals(zooID,name) );
        System.out.println("The Addition of Animals is success! ");
    }
    public void ShowHisAnimals(){
    System.out.println("The names of the animals he takes care of: "); 
       for(int i=0;i<AnimalsList.size() ;i++){
      Animals obj= (Animals) AnimalsList.get(i);
      System.out.println(obj.name); 
       } 
    }
}
