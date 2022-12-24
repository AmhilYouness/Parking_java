
package Ascensor;

import java.awt.Dimension;
import java.awt.Image;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Person extends JLabel implements Runnable {
    
    private String personnIdentifie;
    private int weightOfPerson;
    private ImageIcon  personImage;   
    private int posLabelX;
    private int posLabelY;
    public AcsensorLabel  ourAsc;
   public  Person(String identifie,int weight,AcsensorLabel a){
        
        this.weightOfPerson             = weight;
        this.personnIdentifie           = identifie;
        this.personImage                = new ImageIcon("images/1P.jpg");
        this.setIcon(personImage);
        this.posLabelX = 50 ;
        this.posLabelY = 580;
        Dimension sizeOfImage  = this.getPreferredSize();
        this.setBounds(this.posLabelX,this.posLabelY,sizeOfImage.width,sizeOfImage.height);
        System.out.println("Our Personn Start = "+this.weightOfPerson);
        this.ourAsc  = a;
        }

    public String getIdetifieOfPerson() {
        return getPersonnIdentifie();
    }

    public int getWeightOfPerson() {
        return weightOfPerson;
    }

    public String getPersonnIdentifie() {
        return personnIdentifie;
    }

    public ImageIcon getPersonImage() {
        return personImage;
    }
    public void setPersonImage(String nameOfImage){
        this.personImage  =  new ImageIcon(nameOfImage);
        this.setIcon(personImage);
    }
    public int getPosLabelX() {
        return posLabelX;
    }

    public void setPosLabelX(int posLabelX) {
        this.posLabelX = posLabelX;
    }

    public int getPosLabelY() {
        return posLabelY;
    }

    public void setPosLabelY(int posLabelY) {
        this.posLabelY = posLabelY;
    }
    
        @Override
    public void run(){
        
        while(true){
            
            try {
                
//          Check Access TO Elevator
            AscensorInterface.ourControlAccess.acquire();

            if(!(ourPanelElevator.goInsideAscensorToMonte(this,ourAsc))){
                
                System.out.println("You Can't Go Inside Elevator Because You Are Too Heavy");
            }
        

            AscensorInterface.ourControlAccess.release();
           Thread.sleep((long)  (5000* Math.random()));


      
           AscensorInterface.ourControlAccess.acquire();

           if(!(ourPanelElevator.goInsideAscensorToDown(this,ourAsc))){
               
                 System.out.println("You Can't Go Inside Elevator Because You Are Too Heavy");
           }
           
           AscensorInterface.ourControlAccess.release();
           Thread.sleep((long)  (5000* Math.random()));
           
}catch (InterruptedException ex) {
    
          Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
                
     }            
  }
}

    public void sleep(int i){
        try{
            
            Thread.sleep(i); 

    }catch (InterruptedException ex) {
           
        Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
      }
        
    }       
}
