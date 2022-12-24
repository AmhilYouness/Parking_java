
package Ascensor;

import static Ascensor.ourPanelElevator.capacitorOfElevatorWeight;
import java.awt.Dimension;
import static java.lang.Thread.sleep;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class AcsensorLabel extends JLabel {
        
    private ImageIcon acensorImage;
    private int posLabelX;
    private int posLabelY;
    public int status;
    
   public AcsensorLabel(){
            
        this.acensorImage                = new ImageIcon("images/a1.png");
        this.setIcon(acensorImage);
        this.posLabelX = 1138 ;
        this.posLabelY = 550;
        Dimension sizeOfImage  = this.getPreferredSize();
        this.setBounds(this.posLabelX,this.posLabelY,sizeOfImage.width,sizeOfImage.height);
        this.status = 0;
        }
      public void SwitchIconAscensor(String nameOfImageAscensor){
          
          this.setIcon(new ImageIcon(nameOfImageAscensor));
      }
      public void AscensorToUp() throws InterruptedException{
               
                    int m = this.posLabelX;
                    int n = this.posLabelY;

                System.out.println("Elevator Is Start Down To Up ");
//                switch Icon Elevator
                 this.SwitchIconAscensor("images/a1.png");

               while(n > 0){
                     n -=50;
                     this.setLocation(m,n);
                     Thread.sleep(200);
                 }
                this.SwitchIconAscensor("images/3.png");
               
                 this.posLabelX = m;
                 this.posLabelY = n;
                 this.status    = 1;
             
        }
        
    public void AscensorToDown() throws InterruptedException{
           
                    int m = this.posLabelX;
                    int n = this.posLabelY;
                    

                  System.out.println("Elevator Is Start Up To Down " );
//                switch Icon Elevator
                 this.SwitchIconAscensor("images/a1.png");
                 while(n < 550){
                     
                      n  +=50;
                     this.setLocation(m, n);
                     Thread.sleep(200);
                 }
                this.SwitchIconAscensor("images/3.png");
                 this.posLabelX = m;
                 this.posLabelY = n;
                 this.status    = 0;
            
        }
    
    public void elevatorStatusCaseUp() throws InterruptedException{
        
 //                 Check If Ascensor Up
                    int m = this.posLabelX;
                    int n = this.posLabelY;

                if(this.status == 1){

                  while(n < 550){
                     n  +=50;
                     this.setLocation(m, n);
                     Thread.sleep(200);
                  }               
                 this.posLabelY = n;
                 this.status  = 0;
                 
                }
                                                    
           
    }
    
 public void elevatorStatusCaseDown() throws InterruptedException{
        
 //                 Check If Ascensor Down
                    int m = this.posLabelX;
                    int n = this.posLabelY;

                if(this.status == 0){

                  while(n > 0){
                     n  -=50;
                     this.setLocation(m, n);
                     Thread.sleep(200);
                  }               
                 this.posLabelY = n;
                 this.status  = 1;
                 
                }
                                                    
           
    }


}
