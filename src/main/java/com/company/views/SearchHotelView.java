package com.company.views;

import com.company.controllers.SearchHotelController;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;

public class SearchHotelView extends JFrame {
    public SearchHotelView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1035, 597);
        setResizable(false);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        final JLabel getHotel = new JLabel("Search Hotel");
        getHotel.setForeground(Color.BLACK);
        getHotel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
        getHotel.setBounds(410, 13, 280, 93);
        contentPane.add(getHotel);

        final JLabel hotelName = new JLabel("Hotel name");
        hotelName.setForeground(Color.BLACK);
        hotelName.setFont(new Font("Tahoma", Font.PLAIN, 31));
        hotelName.setBounds(455, 165, 193, 52);
        contentPane.add(hotelName);

        final JTextField hotelNameField = new JTextField();
        hotelNameField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        hotelNameField.setBounds(386, 220, 281, 68);
        contentPane.add(hotelNameField);
        hotelNameField.setColumns(10);

        final JButton searchHotel = new JButton("Search");
        searchHotel.setFont(new Font("Tahoma", Font.PLAIN, 26));
        searchHotel.setBounds(447, 392, 160, 73);
        searchHotel.addActionListener(new SearchHotelController(this, searchHotel, hotelNameField));

        contentPane.add(searchHotel);

    }
}
