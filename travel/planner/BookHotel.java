package travel.planner;
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Image;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookHotel extends JFrame {
	private JPanel contentPane;
        String username;
        JTextField t1,t2;
        Choice c1,c2,c3;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookHotel frame = new BookHotel("Sam");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BookHotel(String username) {
            
                this.username = username;
		setBounds(300, 100, 1000, 550);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.png"));
                Image i3 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel la1 = new JLabel(i2);
                la1.setBounds(450,50,500,300);
                add(la1);
		
		JLabel lblName = new JLabel("BOOK HOTEL");
		lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		lblName.setBounds(118, 11, 300, 53);
		contentPane.add(lblName);
                
                JLabel la2 = new JLabel("Username :");
		la2.setBounds(35, 70, 200, 14);
		contentPane.add(la2);
                
                JLabel l1 = new JLabel(username);
		l1.setBounds(271, 70, 200, 14);
		contentPane.add(l1);
                
                JLabel lblId = new JLabel("Select Hotel");
		lblId.setBounds(35, 110, 200, 14);
		contentPane.add(lblId);
                
                c1 = new Choice();
                c1.setBounds(271, 110, 150, 30);
                add(c1);
                
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from hotel");
                    
                    while(rs.next()){
                        c1.add(rs.getString("name"));
                    }
                    
                }catch (Exception e) {
                    System.out.println(e);
                }
                
                JLabel la3 = new JLabel("Total Persons");
		la3.setBounds(35, 150, 200, 14);
		contentPane.add(la3);
                
                t1 = new JTextField();
                t1.setText("1");
		t1.setBounds(271, 150, 150, 20);
		contentPane.add(t1);
		t1.setColumns(10);
                
                JLabel days = new JLabel("No of Days");
		days.setBounds(35, 190, 200, 14);
		contentPane.add(days);
                
                t2 = new JTextField();
                t2.setText("1");
		t2.setBounds(271, 190, 150, 20);
		contentPane.add(t2);
		t2.setColumns(10);
                
		
                JLabel l2 = new JLabel();
		l2.setBounds(271, 190, 200, 14);
		contentPane.add(l2);
		
		JLabel lbl2 = new JLabel("AC / Non-AC :");
		lbl2.setBounds(35, 230, 200, 14);
		contentPane.add(lbl2);
                
                c2 = new Choice();
                c2.add("AC");
                c2.add("Non-AC");
                c2.setBounds(271, 230, 150, 30);
                add(c2);
                
           	
		JLabel lbl3 = new JLabel("Food :");
		lbl3.setBounds(35, 270, 200, 14);
		contentPane.add(lbl3);
                
                c3 = new Choice();
                c3.add("Yes");
                c3.add("No");
                c3.setBounds(271, 270, 150, 30);
                add(c3);
                
                JLabel l4 = new JLabel();
		l4.setBounds(271, 270, 200, 14);
		contentPane.add(l4);

		
		JLabel lbl1 = new JLabel("ID :");
		lbl1.setBounds(35, 310, 200, 14);
		contentPane.add(lbl1);
                
                JLabel l3 = new JLabel();
		l3.setBounds(271, 310, 200, 14);
		contentPane.add(l3);
		
		JLabel lbl4 = new JLabel("Number :");
		lbl4.setBounds(35, 350, 200, 14);
		contentPane.add(lbl4);
                
                JLabel l5 = new JLabel();
		l5.setBounds(271, 350, 200, 14);
		contentPane.add(l5);
           	
		JLabel lbl5 = new JLabel("Phone :");
		lbl5.setBounds(35, 390, 200, 14);
		contentPane.add(lbl5);
                
                JLabel l6 = new JLabel();
		l6.setBounds(271, 390, 200, 14);
		contentPane.add(l6);

		
		JLabel lblDeposite = new JLabel("Total Price :");
		lblDeposite.setBounds(35, 430, 200, 14);
		contentPane.add(lblDeposite);
		
		JLabel l7 = new JLabel();
		l7.setBounds(271, 430, 200, 14);
                l7.setForeground(Color.RED);
		contentPane.add(l7);
                
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'");
                    while(rs.next()){
                        l3.setText(rs.getString("id"));
                        l5.setText(rs.getString("number"));
                        l6.setText(rs.getString("phone"));
                        
                    }

                    rs.close();
                }catch(SQLException e){}
                
                JButton b1 = new JButton("Check Price");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            
                            Conn c = new Conn();
                            try {
                                ResultSet rs = c.s.executeQuery("select * from hotel where name='"+c1.getSelectedItem()+"'");
                                
                                while(rs.next()){
                                        int cost = Integer.parseInt(rs.getString("costperperon"));
                                        int food = Integer.parseInt(rs.getString("foodincluded"));
                                        int ac = Integer.parseInt(rs.getString("acroom"));
                                        
                                        int persons = Integer.parseInt(t1.getText());
                                        int days = Integer.parseInt(t2.getText());
                                        
                                        String acSelected = c2.getSelectedItem();
                                        String foodSelected = c3.getSelectedItem();
                                        
                                        if(persons*days>0){
                                            int total = 0;
                                            total+=acSelected.equals("AC")?ac:0;
                                            total+=foodSelected.equals("Yes")?food:0;
                                            total+=cost;
                                            total = total*persons*days;
                                            l7.setText("Rs "+total);
                                        }
                                        else{
                                            JOptionPane.showMessageDialog(null,"Please Enter A Valid Number");
                                        }
                                }
                            } catch (SQLException ex) {
                                Logger.getLogger(BookHotel.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                            
                        }
		});
		b1.setBounds(50, 460, 120, 30);
                b1.setBackground(new Color(153,153,153));
                b1.setForeground(Color.WHITE);
		contentPane.add(b1);
		

		JButton btnNewButton = new JButton("Book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            Conn c = new Conn();
                           
                          
                            try{
	    			String s1 = c1.getSelectedItem(); 
                                                                                                                                                               
                                String q1 = "insert into bookhotel values('"+username+"', '"+c1.getSelectedItem()+"', '"+t1.getText()+"', '"+t2.getText()+"', '"+c2.getSelectedItem()+"', '"+c3.getSelectedItem()+"', '"+l3.getText()+"', '"+l5.getText()+"', '"+l6.getText()+"', '"+l7.getText()+"')";
                                c.s.executeUpdate(q1);
                                
	    			JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
                                setVisible(false);
                            }catch(Exception ee){
	    			System.out.println(ee.getMessage());
                            }
                            
			}
		});
		btnNewButton.setBounds(200, 460, 120, 30);
                btnNewButton.setBackground(new Color(153,153,153));
                btnNewButton.setForeground(Color.WHITE);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            setVisible(false);
			}
		}); 
		btnExit.setBounds(350, 460, 120, 30);
                btnExit.setBackground(new Color(153,153,153));
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
                
                getContentPane().setBackground(new Color(255,255,204));
	}
}
