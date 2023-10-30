package travel.planner;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.border.Border;

public class About extends JFrame implements ActionListener {

    JButton b1;
    JLabel l1;
    Font f, f1, f2;
    TextArea t1;
    String s;

    public About() {

        setLayout(null);
        getContentPane().setBackground(new Color(255,255,204));
        JButton back = new JButton("Back");
                back.setBounds(300, 625, 120, 20);
                back.setBackground(new Color(153,153,153));
                back.setForeground(Color.white);
                back.setFont(new Font("SAN_SERIF",Font.BOLD,14));
                back.addActionListener(this);
               // back.setBorder(new LineBorder(new Color(255,255,153)));
                add(back);

        Font f = new Font("RALEWAY", Font.BOLD, 180);
        setFont(f);

        s = "Personal Details Management: The application allows users to manage their personal information efficiently. Users can add their details, including essential information such as name, contact information, and address. This functionality is crucial for travel bookings, ensuring that accurate and up-to-date information is available for any reservations made through the application. Additionally, users have the option to update their existing personal details, enabling them to keep their information current.\n\n"
                + "Travel Package Management: The application simplifies the process of exploring and booking travel packages. Users can effortlessly check the available travel packages, providing them with a range of options to choose from. The \"Book Packages\" feature allows users to make reservations for their preferred travel packages directly through the application. Furthermore, the \"View Packages\" functionality enables users to review the details of their booked packages.\n\n"
                + "Hotel Management: In addition to travel packages, the application offers hotel management features. Users can view a list of available hotels, empowering them to make informed decisions about their accommodations. The \"Book Hotels\" feature streamlines the hotel reservation process, allowing users to secure their stays conveniently. The application also provides a \"View Booked Hotels\" option, enabling users to access details of their booked accommodations, enhancing their overall travel planning experience.\n\n"
                + "Additional Utilities: The integration of a system calculator directly within the application enables users to perform calculations without exiting the platform, ensuring a seamless user experience. Furthermore, the application provides information about various travel destinations, allowing users to explore potential locations for their trips. The presence of buttons for handling payments, accessing a notepad, and learning more about the application through an \"About\" section.";
        TextArea t1 = new TextArea(s, 10, 40, Scrollbar.VERTICAL);
        t1.setEditable(false);
        t1.setBounds(20, 100, 700, 500);

        add(t1);

        Font f1 = new Font("RALEWAY", Font.BOLD, 16);
        t1.setFont(f1);

        Container contentPane = this.getContentPane();
        t1 = new TextArea();

        JLabel l1 = new JLabel("About");
        add(l1);
        l1.setBounds(300, 20, 200, 90);
        l1.setForeground(Color.black);

        Font f2 = new Font("RALEWAY", Font.BOLD, 50);
        l1.setFont(f2);

        setBounds(300, 30, 760, 700);

        setLayout(null);
        setVisible(true);
        
    }

    public void actionPerformed(ActionEvent e) {
        dispose();
    }

    public static void main(String args[]) {
        new About().setVisible(true);
    }

}