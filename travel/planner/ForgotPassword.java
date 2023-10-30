package travel.planner;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ForgotPassword extends JFrame implements ActionListener{
    
    JTextField tfans,tfUserName,tfName,tfpassword,tfQuestion;
    JButton search,get,back;
    
    ForgotPassword(){
        setBounds(350,200,850,380);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(153,153,153));
        p1.setBounds(30,30,500,280);
        p1.setLayout(null);
        add(p1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotPass.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580,70,200,200);
        add(image);
        
        JLabel userName = new JLabel("User Name");
        userName.setBounds(40,20,100,25);
        userName.setFont(new Font("SAN_SERIF",Font.BOLD,14));
        p1.add(userName);
        
        tfUserName = new JTextField();
        tfUserName.setBounds(220,20,150,25);
        tfUserName.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfUserName);
        
        search = new JButton("Search");
        search.setBounds(380,20,100,25);
        search.setBackground(new Color(204,204,204));
        search.setForeground(Color.black);
        search.setFont(new Font("SAN_SERIF",Font.BOLD,14));
        search.addActionListener(this);
       // create.setBorder(new LineBorder(new Color(255,255,153)));
        p1.add(search);
        
        JLabel Name = new JLabel("Name");
        Name.setBounds(40,60,100,25);
        Name.setFont(new Font("SAN_SERIF",Font.BOLD,14));
        p1.add(Name);
        
        tfName = new JTextField();
        tfName.setBounds(220,60,150,25);
        tfName.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfName);
        
        JLabel security = new JLabel("Security Question");
        security.setBounds(40,100,180,25);
        security.setFont(new Font("SAN_SERIF",Font.BOLD,14));
        p1.add(security);
        
        tfQuestion = new JTextField();
        tfQuestion.setBounds(220,100,150,25);
        tfQuestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfQuestion);
        
        JLabel ans = new JLabel("Answer");
        ans.setBounds(40,140,180,25);
        ans.setFont(new Font("SAN_SERIF",Font.BOLD,14));
        p1.add(ans);
        
        tfans = new JTextField();
        tfans.setBounds(220,140,150,25);
        tfans.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfans);
        
        get = new JButton("Get");
        get.setBounds(380,140,100,25);
        get.setBackground(new Color(204,204,204));
        get.setForeground(Color.black);
        get.setFont(new Font("SAN_SERIF",Font.BOLD,14));
        get.addActionListener(this);
       // get.setBorder(new LineBorder(new Color(255,255,153)));
        p1.add(get);
        
        JLabel password = new JLabel("Password");
        password.setBounds(40,180,150,25);
        password.setFont(new Font("SAN_SERIF",Font.BOLD,14));
        p1.add(password);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(220,180,180,25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);
        
        back = new JButton("Back");
        back.setBounds(150,230,100,25);
        back.setBackground(new Color(204,204,204));
        back.setForeground(Color.black);
        back.setFont(new Font("SAN_SERIF",Font.BOLD,14));
        back.addActionListener(this);
       // back.setBorder(new LineBorder(new Color(255,255,153)));
        p1.add(back);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            Conn con = new Conn();
            if(ae.getSource() == search){
                String sql = "select * from account where username='"+tfUserName.getText()+"'";
		
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(sql);
                
                while (rs.next()) {
                    	tfName.setText(rs.getString("name"));
                        tfQuestion.setText(rs.getString("security"));
		}

            }
            if(ae.getSource() == get){
                String sql = "select * from account where answer='"+tfans.getText()+"' AND username='"+tfUserName.getText()+"'";
		Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(sql);
                
                while (rs.next()) {
                    	tfpassword.setText(rs.getString("password"));
		}


            }
            if(ae.getSource() == back){
                this.setVisible(false);
		new Login().setVisible(true);
			
            }
        }catch(Exception e){
            
        }
    }
    
     public static void main(String[] args){
        
        new ForgotPassword();
    } 
    
}
