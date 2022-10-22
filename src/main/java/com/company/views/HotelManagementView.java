package com.company.views;

import com.company.controllers.HotelController;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;

public class HotelManagementView extends JFrame {

    public HotelManagementView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1035, 597);
        setResizable(false);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        final JLabel hotelManagement = new JLabel("Hotel management");
        hotelManagement.setForeground(Color.BLACK);
        hotelManagement.setFont(new Font("Times New Roman", Font.PLAIN, 46));
        hotelManagement.setBounds(337, 13, 340, 93);
        contentPane.add(hotelManagement);

        final JButton addHotelButton = new JButton("Add hotel");
        addHotelButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
        addHotelButton.setBounds(407, 130, 200, 73);
        addHotelButton.addActionListener(new HotelController(this, "addHotel"));
        contentPane.add(addHotelButton);

        final JButton deleteHotelButton = new JButton("Delete hotel");
        deleteHotelButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
        deleteHotelButton.setBounds(407, 230, 200, 73);
        deleteHotelButton.addActionListener(new HotelController(this, "deleteHotel"));
        contentPane.add(deleteHotelButton);

        final JButton searchHotelButton = new JButton("Search hotel");
        searchHotelButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
        searchHotelButton.setBounds(407, 330, 200, 73);
        searchHotelButton.addActionListener(new HotelController(this, "searchHotel"));
        contentPane.add(searchHotelButton);

        final JButton getHotelsButton = new JButton("Get hotels");
        getHotelsButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
        getHotelsButton.setBounds(407, 430, 200, 73);
        getHotelsButton.addActionListener(new HotelController(this, "getHotels"));
        contentPane.add(getHotelsButton);
    }
}
