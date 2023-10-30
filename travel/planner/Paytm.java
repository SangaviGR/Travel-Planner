package travel.planner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Paytm extends JFrame implements ActionListener{
    
    JButton back;
    
    Paytm(){
    
        JEditorPane j = new JEditorPane();
        j.setEditable(false);   
        
        try {
            j.setPage("https://paytm.com/rent-payments");
        }catch (Exception e) {
            j.setContentType("text/html");
            j.setText("<html>Could not load</html>");
        } 

        JScrollPane scrollPane = new JScrollPane(j);     
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(scrollPane);
        setPreferredSize(new Dimension(800,600));
        
        back = new JButton("Back");
                back.setBounds(684,0,100,25);
                back.setBackground(new Color(153,153,153));
                back.setForeground(Color.white);
                back.setFont(new Font("SAN_SERIF",Font.BOLD,14));
                back.addActionListener(this);
               // back.setBorder(new LineBorder(new Color(255,255,153)));
                j.add(back);
        
        setSize(800,610);
        setLocation(300,30);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
         
            setVisible(false);
            Payment frame = new Payment("");
            frame.setVisible(true);
        
     }
    public static void main(String[] args){
        new Paytm().setVisible(true);
    }
}