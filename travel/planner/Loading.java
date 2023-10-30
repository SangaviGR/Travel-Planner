package travel.planner;
import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable{
    
    Thread t;
    JProgressBar bar;
    String username;
     
    Loading(String username){
        
        t = new Thread(this);
        this.username = username;
        setBounds(350, 100,600,400);
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel text = new JLabel("TRAVEL PLANNER");
        text.setBounds(140,20,600,40);
        text.setFont(new Font("SAN_SERIF",Font.BOLD,38));
        text.setBackground(new Color(204,204,204));
        text.setForeground(Color.black);
        add(text);
        
        bar = new JProgressBar();
        bar.setBounds(150,100,300,35);
        /*bar.setFont(new Font("SAN_SERIF",Font.BOLD,38));
        bar.setBackground(new Color(204,204,204));
        bar.setForeground(Color.black);*/
        bar.setStringPainted(true);
        add(bar);
        
        JLabel loading = new JLabel("Loading..");
        loading.setBounds(240,140,150,30);
        loading.setFont(new Font("SAN_SERIF",Font.BOLD,21));
        loading.setBackground(new Color(204,204,204));
        loading.setForeground(Color.black);
        add(loading);
        
        JLabel userName = new JLabel("Welcome "+username);
        userName.setBounds(20,310,4000,40);
        userName.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        userName.setBackground(new Color(204,204,204));
        userName.setForeground(Color.black);
        add(userName);
        
        t.start();
        
        setVisible(true);
    }
    
    public void run() {
            try {
                for (int i = 1; i < 101; i++) {
                    //s = s + 1;
                    int max = bar.getMaximum();
                    int value = bar.getValue();
                    if (value < max) {
                        bar.setValue(bar.getValue() + 1);
                    } else {
                        //i = 201;
                        setVisible(false);
                        //new Home(username).setVisible(true);
                        DashBoard db = new DashBoard(username);
                        db.setVisible(true);
                    }
                    Thread.sleep(50);
                }
            } catch (Exception e) {
		e.printStackTrace();
            }finally{
                setVisible(false);
                        //new Home(username).setVisible(true);
                        DashBoard db = new DashBoard(username);
                        db.setVisible(true);
            }
	}
    
    public static void main(String[] args){
        new Loading("");
        
    } 
    
}
