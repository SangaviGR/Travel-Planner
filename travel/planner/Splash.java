package travel.planner;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable{

    Thread thread;
    Splash(){
        setSize(626, 417); //l & w
        setLocation(400,200);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(626, 417, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        
        setVisible(true);
        
        thread = new Thread(this);
        thread.start();
    }  
    
    @Override
    public void run(){
        
        try{
            Thread.sleep(5000);
            // new Loging();
            setVisible(false);
        }catch(InterruptedException e){
            System.out.println(e);
        }
        
    } 
    
    public static void main(String[] args){
        new Splash();
        
    } 
}
