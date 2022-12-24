package Ascensor;


import java.awt.Graphics;
import static java.awt.image.ImageObserver.WIDTH;
import static java.lang.Thread.sleep;
import java.util.HashSet;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class ourPanelElevator  extends JPanel{
    
     public ImageIcon imageForPanel;
     public static int capacitorOfElevatorWeight ;
     public int numberOfPerson ;
  public  ourPanelElevator(){
            
         this.numberOfPerson            = 2;
         this.capacitorOfElevatorWeight = 100;

    }
         protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        imageForPanel = new ImageIcon("images/Etage1.png");
        imageForPanel.paintIcon(this, g, WIDTH,WIDTH);
    }
    public static boolean goInsideAscensorToMonte(Person p,AcsensorLabel a ) throws InterruptedException{
                
                int x = p.getPosLabelX();
                int y = p.getPosLabelY();
       
       if(p.getWeightOfPerson() > capacitorOfElevatorWeight){
           
           return false;
           
       }else{
           
           
                
                 while(x < 1200){
                     
                     x +=50;
                     p.setLocation(x, y);
                     if(x == 1000){
//                         Check If Elevator Up Or Down
                         a.elevatorStatusCaseUp();
                         a.SwitchIconAscensor("images/3.png");
                         Thread.sleep(1000);
                     }
                      p.sleep(200);
                 }

//                 Switch Person Image
                  p.setPersonImage("images/2P.jpg");
                  p.hide();
                  a.AscensorToUp();
                  y  -= 580;
                  p.setLocation(x,y);
                  p.show();
                  
                  

                  while(x > 50){
                     x -=50;
                     p.setLocation(x, y);
                     p.sleep(200);
                 }
  //                 Switch Person Image
                 a.SwitchIconAscensor("images/a1.png");
                 p.setPersonImage("images/1P.jpg");
                 p.setPosLabelX(x);
                 p.setPosLabelY(y);
                 
                 return true;
        
       }  
    }
    
    
    
    
    public static boolean goInsideAscensorToDown(Person p,AcsensorLabel a) throws InterruptedException{
        
                int x = p.getPosLabelX();
                int y = p.getPosLabelY();
                
if(p.getWeightOfPerson() > capacitorOfElevatorWeight){
           
           return false;
           
       }else{
                 
                 while(x < 1200){
                     
                     x +=50;
                     p.setLocation(x, y);

                     if(x == 1000){
                     
 //                      Check If Elevator Up Or Down
                         a.elevatorStatusCaseDown();
                         a.SwitchIconAscensor("images/3.png");
                         Thread.sleep(1000);
                         
                     }
                      p.sleep(200);
                 }

//                 Switch Person Image
                 p.setPersonImage("images/2P.jpg");
                  p.hide();
                  a.AscensorToDown();
                  y  += 580;
                  p.setLocation(x,y);
                  p.show();
                 

                  while(x > 50){
                     
                     x -=50;
                     p.setLocation(x, y);
                     p.sleep(200);
                 }
                                                 
                  a.SwitchIconAscensor("images/a1.png");
 //              Switch Person Image
                 p.setPersonImage("images/1P.jpg");

                 p.setPosLabelX(x);
                 p.setPosLabelY(y);
          return true;
         }
    }
}
