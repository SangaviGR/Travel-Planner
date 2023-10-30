package travel.planner;
import java.awt.*;
import javax.swing.JFrame;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewBookedHotel extends JFrame implements ActionListener {
	JLabel labeluserName,labelpackage,numberpersons,id,number,price,phone,labeltDays,labelac,labelfood ;
	JButton back;
        String username;
        
	public static void main(String[] args) {
		ViewBookedHotel frame = new ViewBookedHotel("");
		frame.setVisible(true);
	}

        
	public ViewBookedHotel(String username){
            
                this.username = username;
		setBounds(350,100,900,600);
                getContentPane().setBackground(new Color(255,255,204));
                setLayout(null);
                
                JLabel lblName = new JLabel("VIEW BOOKED HOTEL");
		lblName.setFont(new Font("Yu Mincho", Font.BOLD, 20));
		lblName.setBounds(50,0, 300, 30);
		add(lblName);
                
                JLabel userName = new JLabel("User Name");
                userName.setBounds(30,50,150,25);
                userName.setFont(new Font("SAN_SERIF",Font.BOLD,14));
                add(userName);
                
                labeluserName = new JLabel();
                labeluserName.setBounds(220,50,150,25);
                labeluserName.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
                add(labeluserName);
                
                JLabel packageN = new JLabel("Hotel Name");
                packageN.setBounds(30,90,150,25);
                packageN.setFont(new Font("SAN_SERIF",Font.BOLD,14));
                add(packageN);
                
                labelpackage = new JLabel();
                labelpackage.setBounds(220,90,150,25);
                labelpackage.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
                add(labelpackage);
                
                // persons Label
                JLabel persons = new JLabel("Total Persons");
                persons.setBounds(30, 130, 150, 25);
                persons.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
                add(persons);
                
                JLabel tDays = new JLabel("Total Days");
                tDays.setBounds(30,170,150,25);
                tDays.setFont(new Font("SAN_SERIF",Font.BOLD,14));
                add(tDays);
                
                labeltDays = new JLabel();
                labeltDays.setBounds(220,170,150,25);
                labeltDays.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
                add(labeltDays);
                
                JLabel ac = new JLabel("AC/Non-AC");
                ac.setBounds(30,210,150,25);
                ac.setFont(new Font("SAN_SERIF",Font.BOLD,14));
                add(ac);
                
                labelac = new JLabel();
                labelac.setBounds(220,210,150,25);
                labelac.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
                add(labelac);
                
                JLabel food = new JLabel("Food Included?");
                food.setBounds(30,250,150,25);
                food.setFont(new Font("SAN_SERIF",Font.BOLD,14));
                add(food);
                
                labelfood = new JLabel();
                labelfood.setBounds(220,250,150,25);
                labelfood.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
                add(labelfood);

                // id Label
                JLabel idLabel = new JLabel("ID");
                idLabel.setBounds(30, 290, 150, 25);
                idLabel.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
                add(idLabel);

                // number Label
                JLabel numberLabel = new JLabel("Number");
                numberLabel.setBounds(30, 330, 150, 25);
                numberLabel.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
                add(numberLabel);

                // phone Label
                JLabel phoneLabel = new JLabel("Phone");
                phoneLabel.setBounds(30, 370, 150, 25);
                phoneLabel.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
                add(phoneLabel);

                // price Label
                JLabel priceLabel = new JLabel("Price");
                priceLabel.setBounds(30, 410, 150, 25);
                priceLabel.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
                add(priceLabel);
                
                
               // Number Label
                numberpersons = new JLabel();
                numberpersons.setBounds(220, 130, 150, 25);
                numberpersons.setFont(new Font("SAN_SERIF", Font.PLAIN, 14));
                add(numberpersons);

                // id Label
                id = new JLabel();
                id.setBounds(220, 290, 150, 25);
                id.setFont(new Font("SAN_SERIF", Font.PLAIN, 14));
                add(id);

                // number Label
                number = new JLabel();
                number.setBounds(220, 330, 150, 25);
                number.setFont(new Font("SAN_SERIF", Font.PLAIN, 14));
                add(number);


                // price Label
                price = new JLabel();
                price.setBounds(220,410, 150, 25);
                price.setFont(new Font("SAN_SERIF", Font.PLAIN, 14));
                add(price);

                // Phone Label
                phone = new JLabel();
                phone.setBounds(220, 370,150, 25);
                phone.setFont(new Font("SAN_SERIF", Font.PLAIN, 14));
                add(phone);

                

                
                back = new JButton("Back");
                back.setBounds(130,500,100,25);
                back.setBackground(new Color(153,153,153));
                back.setForeground(Color.white);
                back.setFont(new Font("SAN_SERIF",Font.BOLD,14));
                back.addActionListener(this);
               // back.setBorder(new LineBorder(new Color(255,255,153)));
                add(back);
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/hotelBook.png"));
                Image i3 = i1.getImage().getScaledInstance(400, 400,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel la1 = new JLabel(i2);
                la1.setBounds(450,20,400,400);
                add(la1);
                
                try{
                    Conn c = new Conn();
                    String sql = "select * from bookhotel where username='"+username+"'";
                    ResultSet rs = c.s.executeQuery(sql);
                    
                    while(rs.next()){
                        labeluserName.setText(rs.getString("username"));
                        id.setText(rs.getString("id"));
                        numberpersons.setText(rs.getString("persons"));
                        number.setText(rs.getString("number"));
                        phone.setText(rs.getString("phone"));
                        price.setText(rs.getString("price"));
                        labelfood.setText(rs.getString("food"));
                        labelac.setText(rs.getString("ac"));
                        labeltDays.setText(rs.getString("days"));
                        labelpackage.setText(rs.getString("name"));
                    }
                    
                }catch(SQLException e){
                    e.printStackTrace();
                }
		
		setVisible(true);
	}
        
        public void actionPerformed(ActionEvent ae){
            setVisible(false);
        }
       
    

}