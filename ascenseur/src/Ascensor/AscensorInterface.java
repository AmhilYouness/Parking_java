
package Ascensor;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import static java.awt.Font.BOLD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class AscensorInterface extends javax.swing.JFrame {
    
   private JPanel ourPanel;
   private Thread OurThread[];
   private Person  ourPerson;
   public static Semaphore ourControlAccess;
   public AcsensorLabel ourLabelAscensor;
   public JButton startAnimationAsc  ;
   public ActionListener ourListener;
    /**
     * Creates new form AscensorInterface
     */
    public AscensorInterface() {
        initComponents();
        this.ourControlAccess           = new Semaphore(1,false);
        this.setSize(1500,800);
        this.ourPanel  = new ourPanelElevator();
        this.setContentPane( this.ourPanel);
        this.ourPanel.setLayout(null);
        this.ourLabelAscensor   = new AcsensorLabel();
        this.ourPanel.add(ourLabelAscensor);
        //        Make A Button For Start Animation
        this.startAnimationAsc= new JButton("Cemmencer");
        this.startAnimationAsc.setVisible(true);
        this.startAnimationAsc.setBounds(280, 420,150, 50);
        this.startAnimationAsc.setBackground(Color.BLACK);
        this.startAnimationAsc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.startAnimationAsc.setForeground(Color.white);
        this.startAnimationAsc.setFont(new Font("Arial", Font.BOLD,16));
        this.ourPanel.add(startAnimationAsc);
       
        this.startAnimationAsc.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                
                for(int i=0;i<5;i++){
                    
                   OurThread[i].start();  
                }
            }


        });
        OurThread           = new Thread[5];
        for(int i=0;i<5;i++){
            
            ourPerson            = new Person("Person "+i, (int) Math.floor(Math.random()*70) + 50,this.ourLabelAscensor);
            OurThread[i]         = new Thread(ourPerson);
            this.ourPanel.add(ourPerson);
   
    
        }
   
    }
    

   

   
    @SuppressWarnings("unchecked")
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Animation For Elevator");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1140, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 524, Short.MAX_VALUE)
        );

        pack();
    }

  
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AscensorInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AscensorInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AscensorInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AscensorInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new AscensorInterface().setVisible(true);
            }
        });
    }

   
}
