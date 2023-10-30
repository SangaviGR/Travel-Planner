package travel.planner;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DashBoard extends JFrame implements ActionListener{
    String username;
    JButton addPersonalDetails,updatePersonalDetails,viewPersonalDetails,deletePersonalDetails,checkPackages,bookPackages,viewPackages,viewHotel,bookHotel,viewBookedHotel;
    JButton aboutButton,notepadButton,calculatorButton,paymentsButton,destinationsButton;
    DashBoard(String username){

        // Set the frame to full screen
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        this.username = username;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(153,153,153));
        p1.setBounds(0,0,1600,65);
        p1.setLayout(null);
        add(p1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/compass.png"));
        Image i2 = i1.getImage().getScaledInstance(65,65, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(5,0,65,65);
        p1.add(image);
        
        JLabel heading = new JLabel("DashBoard");
        heading.setBounds(80,10,300,40);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,27));
        heading.setForeground(Color.black);
        p1.add(heading);
        
        JPanel p2 = new JPanel();
        p2.setBackground(new Color(255,255,204));
       //p2.setBackground(Color.white);
        p2.setBounds(0,65,300,900);
        p2.setLayout(null);
        add(p2);
        
        ImageIcon i1l = new ImageIcon(ClassLoader.getSystemResource("icons/tr.png"));
        Image i2l = i1l.getImage().getScaledInstance(90,90, Image.SCALE_DEFAULT);
        ImageIcon i3l = new ImageIcon(i2l);
        JLabel imagel = new JLabel(i3l);
        imagel.setBounds(100,0,90,90);
        p2.add(imagel);
        
        addPersonalDetails = new JButton("Add Personal Details");
        addPersonalDetails.setBounds(0,100,300,35);
        addPersonalDetails.setBackground(Color.white);
        addPersonalDetails.setForeground(Color.black);
        addPersonalDetails.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        addPersonalDetails.setMargin(new Insets(0,0,0,60));
        addPersonalDetails.addActionListener(this);
       // addPersonalDetails.setBorder(new LineBorder(new Color(153,153,153)));
        p2.add(addPersonalDetails);
        
        updatePersonalDetails = new JButton("Update Personal Details");
        updatePersonalDetails.setBounds(0,135,300,35);
        updatePersonalDetails.setBackground(Color.white);
        updatePersonalDetails.setForeground(Color.black);
        updatePersonalDetails.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        updatePersonalDetails.setMargin(new Insets(0,0,0,30));
        updatePersonalDetails.addActionListener(this);
       // updatePersonalDetails.setBorder(new LineBorder(new Color(153,153,153)));
        p2.add(updatePersonalDetails);
        
        viewPersonalDetails = new JButton("View Details");
        viewPersonalDetails.setBounds(0,170,300,35);
        viewPersonalDetails.setBackground(Color.white);
        viewPersonalDetails.setForeground(Color.black);
        viewPersonalDetails.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        viewPersonalDetails.setMargin(new Insets(0,0,0,130));
        viewPersonalDetails.addActionListener(this);
       // viewPersonalDetails.setBorder(new LineBorder(new Color(153,153,153)));
        p2.add(viewPersonalDetails);
        
        deletePersonalDetails = new JButton("Delete Details");
        deletePersonalDetails.setBounds(0,205,300,35);
        deletePersonalDetails.setBackground(Color.white);
        deletePersonalDetails.setForeground(Color.black);
        deletePersonalDetails.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        deletePersonalDetails.setMargin(new Insets(0,0,0,110));
        deletePersonalDetails.addActionListener(this);
       // deletePersonalDetails.setBorder(new LineBorder(new Color(153,153,153)));
        p2.add(deletePersonalDetails);
        
        checkPackages = new JButton("Check Packages");
        checkPackages.setBounds(0,240,300,35);
        checkPackages.setBackground(Color.white);
        checkPackages.setForeground(Color.black);
        checkPackages.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        checkPackages.setMargin(new Insets(0,0,0,90));
        checkPackages.addActionListener(this);
       // checkPackages.setBorder(new LineBorder(new Color(153,153,153)));
        p2.add(checkPackages);
        
        bookPackages = new JButton("Book Packages");
        bookPackages.setBounds(0,275,300,35);
        bookPackages.setBackground(Color.white);
        bookPackages.setForeground(Color.black);
        bookPackages.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        bookPackages.setMargin(new Insets(0,0,0,90));
        bookPackages.addActionListener(this);
       // bookPackages.setBorder(new LineBorder(new Color(153,153,153)));
        p2.add(bookPackages);
        
        viewPackages = new JButton("View Packages");
        viewPackages.setBounds(0,310,300,35);
        viewPackages.setBackground(Color.white);
        viewPackages.setForeground(Color.black);
        viewPackages.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        viewPackages.setMargin(new Insets(0,0,0,90));
        viewPackages.addActionListener(this);
       // viewPackages.setBorder(new LineBorder(new Color(153,153,153)));
        p2.add(viewPackages);
        
        viewHotel = new JButton("View Hotel");
        viewHotel.setBounds(0,345,300,35);
        viewHotel.setBackground(Color.white);
        viewHotel.setForeground(Color.black);
        viewHotel.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        viewHotel.setMargin(new Insets(0,0,0,130));
        viewHotel.addActionListener(this);
       // viewHotel.setBorder(new LineBorder(new Color(153,153,153)));
        p2.add(viewHotel);
        
        bookHotel = new JButton("Book Hotel");
        bookHotel.setBounds(0,380,300,35);
        bookHotel.setBackground(Color.white);
        bookHotel.setForeground(Color.black);
        bookHotel.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        bookHotel.setMargin(new Insets(0,0,0,130));
        bookHotel.addActionListener(this);
       // bookHotel.setBorder(new LineBorder(new Color(153,153,153)));
        p2.add(bookHotel);
        
        viewBookedHotel = new JButton("View Booked Hotel");
        viewBookedHotel.setBounds(0,415,300,35);
        viewBookedHotel.setBackground(Color.white);
        viewBookedHotel.setForeground(Color.black);
        viewBookedHotel.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        viewBookedHotel.setMargin(new Insets(0,0,0,70));
        viewBookedHotel.addActionListener(this);
       // viewBookedHotel.setBorder(new LineBorder(new Color(153,153,153)));
        p2.add(viewBookedHotel);
        
        destinationsButton = new JButton("Destinations");
        destinationsButton.setBounds(0, 450, 300, 35);
        destinationsButton.setBackground(Color.white);
        destinationsButton.setForeground(Color.black);
        destinationsButton.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        destinationsButton.setMargin(new Insets(0, 0, 0, 70));
        destinationsButton.addActionListener(this);
        // destinationsButton.setBorder(new LineBorder(new Color(153, 153, 153)));
        p2.add(destinationsButton);
        
        paymentsButton = new JButton("Payments");
        paymentsButton.setBounds(0, 485, 300, 35);
        paymentsButton.setBackground(Color.white);
        paymentsButton.setForeground(Color.black);
        paymentsButton.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        paymentsButton.setMargin(new Insets(0, 0, 0, 70));
        paymentsButton.addActionListener(this);
        // paymentsButton.setBorder(new LineBorder(new Color(153, 153, 153)));
        p2.add(paymentsButton);

        calculatorButton = new JButton("Calculator");
        calculatorButton.setBounds(0, 520, 300, 35);
        calculatorButton.setBackground(Color.white);
        calculatorButton.setForeground(Color.black);
        calculatorButton.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        calculatorButton.setMargin(new Insets(0, 0, 0, 70));
        calculatorButton.addActionListener(this);
        // calculatorButton.setBorder(new LineBorder(new Color(153, 153, 153)));
        p2.add(calculatorButton);

        notepadButton = new JButton("Notepad");
        notepadButton.setBounds(0, 555, 300, 35);
        notepadButton.setBackground(Color.white);
        notepadButton.setForeground(Color.black);
        notepadButton.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        notepadButton.setMargin(new Insets(0, 0, 0, 70));
        notepadButton.addActionListener(this);
        // notepadButton.setBorder(new LineBorder(new Color(153, 153, 153)));
        p2.add(notepadButton);
        
        aboutButton = new JButton("About");
        aboutButton.setBounds(0, 590, 300, 35);
        aboutButton.setBackground(Color.white);
        aboutButton.setForeground(Color.black);
        aboutButton.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        aboutButton.setMargin(new Insets(0, 0, 0, 70));
        aboutButton.addActionListener(this);
        // aboutButton.setBorder(new LineBorder(new Color(153, 153, 153)));
        p2.add(aboutButton);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/y.jpeg"));
        Image i5 = i4.getImage().getScaledInstance(1045,640, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image1 = new JLabel(i6);
        image1.setBounds(310,68,1045,640);
        add(image1);

        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == addPersonalDetails){
            try {
                //setVisible(false);
                AddCustomer addCustomer = new AddCustomer(username);
                addCustomer.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(DashBoard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(ae.getSource() == calculatorButton){
            try {
            
            Runtime.getRuntime().exec("calc");
        } catch (Exception e) {
            // Handle exceptions here
            e.printStackTrace();
        }
        }
        else if(ae.getSource() == viewPersonalDetails){
            try {
            //setVisible(false);
                ViewCustomer viewCustomer = new ViewCustomer(username);
                viewCustomer.setVisible(true);
        } catch (Exception e) {
            // Handle exceptions here
            e.printStackTrace();
        }
        }
        else if(ae.getSource() == updatePersonalDetails){
            try {
            //setVisible(false);
                UpdateCustomer updateCustomer = new UpdateCustomer(username);
                updateCustomer.setVisible(true);
        } catch (Exception e) {
            // Handle exceptions here
            e.printStackTrace();
        }
        }
        else if(ae.getSource() == checkPackages){
            try {
           // setVisible(false);
                CheckPackage checkPackage = new CheckPackage();
                checkPackage.setVisible(true);
        } catch (Exception e) {
            // Handle exceptions here
            e.printStackTrace();
        }
        }
        else if(ae.getSource() == bookPackages){
            try {
           // setVisible(false);
                BookPackage bookPackage = new BookPackage(username);
                bookPackage.setVisible(true);
        } catch (Exception e) {
            // Handle exceptions here
            e.printStackTrace();
        }
        }
        else if(ae.getSource() == viewPackages){
            try {
           // setVisible(false);
                ViewPackage viewPackage = new ViewPackage(username);
                viewPackage.setVisible(true);
        } catch (Exception e) {
            // Handle exceptions here
            e.printStackTrace();
        }
        }
        else if(ae.getSource() == viewHotel){
            try {
           // setVisible(false);
                CheckHotels checkHotels = new CheckHotels();
                checkHotels.setVisible(true);
        } catch (Exception e) {
            // Handle exceptions here
            e.printStackTrace();
        }
        }
        else if(ae.getSource() == destinationsButton){
            try {
           // setVisible(false);
                Destinations destinations = new Destinations();
                destinations.setVisible(true);
        } catch (Exception e) {
            // Handle exceptions here
            e.printStackTrace();
        }
        }
        else if(ae.getSource() == bookHotel){
            try {
           // setVisible(false);
                BookHotel bookHotels = new BookHotel(username);
                bookHotels.setVisible(true);
        } catch (Exception e) {
            // Handle exceptions here
            e.printStackTrace();
        }
        }
        else if(ae.getSource() == viewBookedHotel){
            try {
           // setVisible(false);
                ViewBookedHotel viewBookedHotel = new ViewBookedHotel(username);
                viewBookedHotel.setVisible(true);
        } catch (Exception e) {
            // Handle exceptions here
            e.printStackTrace();
        }
        }
        else if(ae.getSource() == paymentsButton){
            try {
           // setVisible(false);
                Payment payment = new Payment(username);
                payment.setVisible(true);
        } catch (Exception e) {
            // Handle exceptions here
            e.printStackTrace();
        }
        }
        else if(ae.getSource() == notepadButton){
            try {
           
                 Runtime.getRuntime().exec("notepad");
        } catch (Exception e) {
            // Handle exceptions here
            e.printStackTrace();
        }
        }
        else if(ae.getSource() == aboutButton){
            try {
                    About about = new About();
                about.setVisible(true);
        } catch (Exception e) {
            // Handle exceptions here
            e.printStackTrace();
        }
        }
        else if(ae.getSource() == deletePersonalDetails){
            try {
                    DeleteDetails delete = new DeleteDetails(username);
                delete.setVisible(true);
        } catch (Exception e) {
            // Handle exceptions here
            e.printStackTrace();
        }
        }
       
    }
    
    public static void main(String[] args){
        
        new DashBoard("");
    } 
}
