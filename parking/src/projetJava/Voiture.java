package projetJava;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Cursor;

public class Voiture extends JLabel implements Runnable{
	String nom; 
	Parking park;
	ImageIcon carImg ;
	int abs;
	int ord;
	String dim;
	 int positionY;
     int positionX;
	public static Thread MesVoitures[];
	
	
	public Voiture(String name, Parking park,int abs,int ord){
	this.nom=name;
	this.park=park;
	this.abs=abs;
	this.ord=ord;
	  this.positionY=abs;
      this.positionX=ord;
	 this.carImg = new ImageIcon("3.png");
     this.setIcon(carImg);
	Dimension dim = this.getPreferredSize();
	this.setBounds(abs, ord, dim.width,dim.height);
	}
	public void rentrer() throws InterruptedException{
		while (!(this.park.accept(this)))
		{
		Thread.sleep((long) (1000* Math.random()));
		System.out.format("[%s] : Je redemande à rentrer \n", this.nom);
		}
		}
	  public void changeImage(String name){
          
	        this.setIcon(new ImageIcon(name));
	      }
	 public String toString(){
         
         return "nom de voiture : "+this.nom + " abs = "+abs + " ord = "+this.ord + " car dim : "+this.dim;
     }
	 public void run() {
		 System.out.println(this);
		try {
		while(true){
		System.out.format("[%s]: Je demande à rentrer \n", this.nom);
		this.rentrer();
		System.out.format("[%s]: Je viens d'entrer \n", this.nom);
		Thread.sleep((long) (50000* Math.random()));
		if(this.park.infoVoitures.contains(this)) {
		System.out.format("[%s]: Je demande à sortir \n", this.nom);
		this.park.leave(this);
		}
		}
		}catch(InterruptedException e){
            
            System.out.println(e.getMessage());
        }
		}
	
	
	public static void main(String[] args) {
		int TailleParking=4;
		JFrame frame      = new JFrame("Parking");
        Parking  parking       = new Parking(TailleParking);
        frame.setContentPane(parking);
        parking.setLayout(null);
        frame.setSize(1540,824);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        int nbVoitures = 8 ;
        JButton commencer = new JButton("Commencer");
        parking.add(commencer);
        commencer.setVisible(true);
        commencer.setBounds(500, 400, 150, 50);
        commencer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        commencer.setBackground(Color.RED);
        commencer.setForeground(Color.WHITE);
        commencer.setBorder(null);
        String nom = "Voiture";
        Thread MesVoitures[][] = new Thread[4][2];
        int x ;
        int y = 150;
        for (int i = 0; i< 4; i++){
            x = 60;
            for(int j=0;j<2;j++){
                
            Voiture   myVoit  =  new Voiture(nom +" " + i+j,parking,x,y);
            if(j == 0){
            	myVoit.dim = "l";
                 
            }else{
                
            	myVoit.dim = "r";
            }
            MesVoitures[i][j]  =  new Thread(myVoit);
        
            parking.add(myVoit);
            parking.allCars.add(myVoit);
           
            x   = x + 80;

            }
           
            y   = y + 160;
            
        }
        ActionListener actionListenerForButoon = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                
                //            Run Thread
           for (int i = 0; i< 4; i++){
                 for(int j=0;j<2;j++){
                          
                         MesVoitures[i][j].start();
                 }
      	
            }
          }
       };
            commencer.addActionListener(actionListenerForButoon);
          }
	}


