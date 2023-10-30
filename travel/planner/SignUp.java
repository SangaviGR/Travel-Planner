package travel.planner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import javax.swing.border.LineBorder;

public class SignUp extends JFrame implements ActionListener{
    
    JButton create,back;
    JTextField tfans,tfUserName,tfName,tfpassword;
    Choice securityChoice;
    
    SignUp(){
        setBounds(350,200,900,360);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(153,153,153));
        p1.setBounds(0,0,525,400);
        p1.setLayout(null);
        add(p1);
        
        JLabel userName = new JLabel("User Name");
        userName.setBounds(60,20,100,25);
        userName.setFont(new Font("SAN_SERIF",Font.BOLD,14));
        p1.add(userName);
        
        tfUserName = new JTextField();
        tfUserName.setBounds(200,20,180,25);
        tfUserName.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfUserName);
        
        JLabel Name = new JLabel("Name");
        Name.setBounds(60,60,100,25);
        Name.setFont(new Font("SAN_SERIF",Font.BOLD,14));
        p1.add(Name);
        
        tfName = new JTextField();
        tfName.setBounds(200,60,180,25);
        tfName.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfName);
        
        JLabel password = new JLabel("Password");
        password.setBounds(50,100,100,25);
        password.setFont(new Font("SAN_SERIF",Font.BOLD,14));
        p1.add(password);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(200,100,180,25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);
        
        JLabel security = new JLabel("Security Question");
        security.setBounds(50,140,150,25);
        security.setFont(new Font("SAN_SERIF",Font.BOLD,14));
        p1.add(security);
        
        securityChoice = new Choice();
        securityChoice.add("What was the name of your first pet?");
        securityChoice.add("In what city were you born?");
        securityChoice.add("What is your favorite book?");
        securityChoice.add("What is the name of your favorite teacher?");
        securityChoice.add("What is your favorite vacation destination?");
        securityChoice.add("What is the name of your childhood best friend?");
        securityChoice.setBounds(200,140,180,25);
        p1.add(securityChoice);
        
        JLabel ans = new JLabel("Answer");
        ans.setBounds(50,180,100,25);
        ans.setFont(new Font("SAN_SERIF",Font.BOLD,14));
        p1.add(ans);
        
        tfans = new JTextField();
        tfans.setBounds(200,180,180,25);
        tfans.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfans);
        
        create = new JButton("Create");
        create.setBounds(80,250,100,30);
        create.setBackground(Color.white);
        create.setForeground(Color.black);
        create.setFont(new Font("SAN_SERIF",Font.BOLD,14));
        create.addActionListener(this);
       // create.setBorder(new LineBorder(new Color(255,255,153)));
        p1.add(create);
        
        back = new JButton("Back");
        back.setBounds(250,250,100,30);
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        back.setFont(new Font("SAN_SERIF",Font.BOLD,14));
        back.addActionListener(this);
       // back.setBorder(new LineBorder(new Color(255,255,153)));
        p1.add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(227,222, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580,50,227,222);
        add(image);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        try{
            Conn con = new Conn();
            
            if(ae.getSource() == create){
                
                String answer = tfans.getText();
                String username = tfUserName.getText();
                String name = tfName.getText();
                String password = tfpassword.getText();
                String question = securityChoice.getSelectedItem();
                
                String sql = "insert into account values('"+username+"', '"+name+"', '"+password+"', '"+question+"', '"+answer+"')";
		
                try{
                    Conn c = new Conn();
                    c.s.executeUpdate(sql);
                    
                    JOptionPane.showMessageDialog(null,"Successful Account Creation");
                    
                    setVisible(false);
                    new Login();
                    
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            if(ae.getSource() == back){
                this.setVisible(false);
                new Login().setVisible(true);
			
            }
        }catch(Exception e){
                System.out.println(e);
        }
    
    }
    
    public static void main(String[] args){
        new SignUp();
        
    } 
    
}
