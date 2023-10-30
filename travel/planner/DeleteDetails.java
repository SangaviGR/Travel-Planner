package travel.planner;
import java.awt.*;
import javax.swing.JFrame;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteDetails extends JFrame implements ActionListener {
	JLabel labeluserName,labelid,number,name,gender,country,address,phone,email ;
	JButton delete;
        String username;
        
	public static void main(String[] args) {
		DeleteDetails frame = new DeleteDetails("");
		frame.setVisible(true);
	}

        
	public DeleteDetails(String username){
            
                this.username = username;
		setBounds(350, 100,870,625);
                getContentPane().setBackground(new Color(255,255,204));
                setLayout(null);
                
                JLabel userName = new JLabel("User Name");
                userName.setBounds(30,50,150,25);
                userName.setFont(new Font("SAN_SERIF",Font.BOLD,14));
                add(userName);
                
                labeluserName = new JLabel();
                labeluserName.setBounds(220,50,150,25);
                labeluserName.setFont(new Font("SAN_SERIF",Font.BOLD,14));
                add(labeluserName);
                
                JLabel id = new JLabel("ID");
                id.setBounds(30,110,150,25);
                id.setFont(new Font("SAN_SERIF",Font.BOLD,14));
                add(id);
                
                labelid = new JLabel();
                labelid.setBounds(220,110,150,25);
                labelid.setFont(new Font("SAN_SERIF",Font.BOLD,14));
                add(labelid);
                
                // Number Label
                JLabel numberLabel = new JLabel("Number");
                numberLabel.setBounds(30, 170, 150, 25);
                numberLabel.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
                add(numberLabel);

                // Name Label
                JLabel nameLabel = new JLabel("Name");
                nameLabel.setBounds(30, 230, 150, 25);
                nameLabel.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
                add(nameLabel);

                // Gender Label
                JLabel genderLabel = new JLabel("Gender");
                genderLabel.setBounds(30, 290, 150, 25);
                genderLabel.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
                add(genderLabel);

                // Country Label
                JLabel countryLabel = new JLabel("Country");
                countryLabel.setBounds(500, 50, 150, 25);
                countryLabel.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
                add(countryLabel);

                // Address Label
                JLabel addressLabel = new JLabel("Address");
                addressLabel.setBounds(500, 110, 150, 25);
                addressLabel.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
                add(addressLabel);

                // Phone Label
                JLabel phoneLabel = new JLabel("Phone");
                phoneLabel.setBounds(500, 170, 150, 25);
                phoneLabel.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
                add(phoneLabel);

                // Email Label
                JLabel emailLabel = new JLabel("Email");
                emailLabel.setBounds(500, 230, 150, 25);
                emailLabel.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
                add(emailLabel);
                
                
               // Number Label
                number = new JLabel();
                number.setBounds(220, 170, 150, 25);
                number.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
                add(number);

                // Name Label
                name = new JLabel();
                name.setBounds(220, 230, 150, 25);
                name.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
                add(name);

                // Gender Label
                gender = new JLabel();
                gender.setBounds(220, 290, 150, 25);
                gender.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
                add(gender);

                // Country Label
                country = new JLabel();
                country.setBounds(690, 50, 150, 25);
                country.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
                add(country);

                // Address Label
                address = new JLabel();
                address.setBounds(690, 110, 150, 25);
                address.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
                add(address);

                // Phone Label
                phone = new JLabel();
                phone.setBounds(690,170, 150, 25);
                phone.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
                add(phone);

                // Email Label
                email = new JLabel();
                email.setBounds(690, 230, 150, 25);
                email.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
                add(email);

                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
                Image i3 = i1.getImage().getScaledInstance(626, 201,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(0,450,626,201);
                add(l1);
                
                ImageIcon i4  = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
                Image i5 = i4.getImage().getScaledInstance(626, 201,Image.SCALE_DEFAULT);
                ImageIcon i6 = new ImageIcon(i5);
                JLabel l2 = new JLabel(i6);
                l2.setBounds(615,450,626,201);
                add(l2);
                
                delete = new JButton("Delete");
                delete.setBounds(350,350,100,25);
                delete.setBackground(new Color(204,204,204));
                delete.setForeground(Color.black);
                delete.setFont(new Font("SAN_SERIF",Font.BOLD,14));
                delete.addActionListener(this);
               // back.setBorder(new LineBorder(new Color(255,255,153)));
                add(delete);
                
                
                try{
                    Conn c = new Conn();
                    String sql = "select * from customer where username='"+username+"'";
                    ResultSet rs = c.s.executeQuery(sql);
                    
                    while(rs.next()){
                        labeluserName.setText(rs.getString("username"));
                        labelid.setText(rs.getString("id"));
                        number.setText(rs.getString("number"));
                        name.setText(rs.getString("name"));
                        gender.setText(rs.getString("gender"));
                        country.setText(rs.getString("country"));
                        address.setText(rs.getString("address"));
                        phone.setText(rs.getString("phone"));
                        email.setText(rs.getString("email"));
                    }
                    
                }catch(Exception e){
                    
                }
		
		setVisible(true);
	}
        
        public void actionPerformed(ActionEvent ae) {
        int confirmed = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this account?", "Confirmation", JOptionPane.YES_NO_OPTION);

        if (confirmed == JOptionPane.YES_OPTION) {
            try {
                Conn c = new Conn();
                c.s.executeUpdate("delete from account where username ='"+username+"'");
                c.s.executeUpdate("delete from customer where username ='"+username+"'");
                c.s.executeUpdate("delete from bookPackage where username ='"+username+"'");
                c.s.executeUpdate("delete from bookhotel where username ='"+username+"'");

                JOptionPane.showMessageDialog(null,"Details Deleted Successfully");

                setVisible(false);
            } catch (Exception e) {
                // Handle exceptions here
                e.printStackTrace();
            }
    }
}

       
    

}