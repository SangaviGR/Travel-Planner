package travel.planner;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Payment extends JFrame implements ActionListener {
    
    JButton pay,back;
    
    public Payment(String username){
            
        
               // this.username = username;
		setBounds(350,100,800,900);
                getContentPane().setBackground(new Color(255,255,204));
                setLayout(null);
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/paytm.jpeg"));
                Image i3 = i1.getImage().getScaledInstance(800, 600,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel la1 = new JLabel(i2);
                la1.setBounds(0,0,800,600);
                add(la1);
                
                pay = new JButton("Pay");
                pay.setBounds(684,29,100,25);
                pay.setBackground(new Color(153,153,153));
                pay.setForeground(Color.white);
                pay.setFont(new Font("SAN_SERIF",Font.BOLD,14));
                pay.addActionListener(this);
               // pay.setBorder(new LineBorder(new Color(255,255,153)));
                la1.add(pay);
                
                back = new JButton("Back");
                back.setBounds(684,0,100,25);
                back.setBackground(new Color(153,153,153));
                back.setForeground(Color.white);
                back.setFont(new Font("SAN_SERIF",Font.BOLD,14));
                back.addActionListener(this);
               // back.setBorder(new LineBorder(new Color(255,255,153)));
                la1.add(back);
                
                setVisible(true);
    }
    
    public static void main(String[] args) {
		Payment frame = new Payment("");
		frame.setVisible(true);
	}
    
     public void actionPerformed(ActionEvent ae){
         
         if(ae.getSource() == back){
            setVisible(false);
        }else if(ae.getSource() == pay){
            setVisible(false);
            new Paytm().setVisible(true);
        }
         
     }
    
}

