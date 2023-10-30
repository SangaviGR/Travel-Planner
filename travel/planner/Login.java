package travel.planner;
import javax.swing.*;
import java.awt.*;
//import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton signUp,login,forgotPass;
    JTextField tfUserName,tfPassword;

    Login() {

        setSize(900,400); //l & w
        setLocation(400,200);
        setLayout(null);
        
        getContentPane().setBackground(Color.white);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(153,153,153));
        p1.setBounds(0,0,400,400);
        p1.setLayout(null);
        add(p1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(150,150, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100,100,200,200);
        p1.add(image);
        
        JPanel p2 = new JPanel();
        p2.setBackground(new Color(255,255,204));
       //p2.setBackground(Color.white);
        p2.setBounds(400,30,450,300);
        p2.setLayout(null);
        add(p2);

        JLabel userName = new JLabel("User Name");
        userName.setBounds(60,20,100,25);
        userName.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        p2.add(userName);
        
        tfUserName = new JTextField();
        tfUserName.setBounds(60,60,300,30);
       // tfUserName.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfUserName);
        
        JLabel password = new JLabel("Password");
        password.setBounds(60,110,100,25);
        password.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        p2.add(password);
        
        tfPassword = new JPasswordField();
        tfPassword.setBounds(60,150,300,30);
        //tfPassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfPassword);
        
        login = new JButton("Login");
        login.setBounds(60,200,130,30);
        login.setBackground(new Color(153,153,153));
        login.setForeground(Color.white);
        login.addActionListener(this);
        //login.setBorder(new LineBorder(new Color(153,153,153)));
        p2.add(login);
        
        signUp = new JButton("Sign Up");
        signUp.setBounds(230,200,130,30);
        signUp.setBackground(new Color(153,153,153));
        signUp.setForeground(Color.white);
        signUp.addActionListener(this);
       // signUp.setBorder(new LineBorder(new Color(153,153,153)));
        p2.add(signUp);
        
        forgotPass = new JButton("Forgot Password");
        forgotPass.setBounds(130,250,130,30);
        forgotPass.setBackground(new Color(153,153,153));
        forgotPass.setForeground(Color.white);
        forgotPass.addActionListener(this);
       // forgotPass.setBorder(new LineBorder(new Color(153,153,153)));
        p2.add(forgotPass);
        
        JLabel text = new JLabel("Trouble in logging ");
        text.setBounds(300,250,150,30);
        text.setForeground(Color.red);
        p2.add(text);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == login){
                //Boolean status = false;
		try {
                    String username = tfUserName.getText();
                    String password = tfPassword.getText();
                    
                    Conn c = new Conn();
                    String sql = "select * from account where username='"+username+"' AND password='"+password+"'";
                    
                    ResultSet rs = c.s.executeQuery(sql);
                    if (rs.next()) {
                        this.setVisible(false);
                        new Loading(username).setVisible(true);
                    } else
			JOptionPane.showMessageDialog(null, "Login or Password Incorrect..");
                       
		} catch (Exception e2) {
                    e2.printStackTrace();
		}
            }
            else if(ae.getSource() == signUp){
                setVisible(false);
		SignUp su = new SignUp();
		su.setVisible(true);
            }else if(ae.getSource() == forgotPass){
                setVisible(false);
		ForgotPassword forgot = new ForgotPassword();
		forgot.setVisible(true);
            }
        }
    
    public static void main(String[] args){
        
        new Login();
    } 
}
