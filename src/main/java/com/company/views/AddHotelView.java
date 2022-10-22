package com.company.views;

import com.company.controllers.AddHotelController;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AddHotelView extends JFrame {

    public AddHotelView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1035, 597);
        setResizable(false);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        final JLabel addHotel = new JLabel("Add Hotel");
        addHotel.setForeground(Color.BLACK);
        addHotel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
        addHotel.setBounds(440, 13, 280, 93);
        contentPane.add(addHotel);

        final JLabel hotelName = new JLabel("Hotel name");
        hotelName.setForeground(Color.BLACK);
        hotelName.setFont(new Font("Tahoma", Font.PLAIN, 31));
        hotelName.setBounds(455, 115, 193, 52);
        contentPane.add(hotelName);

        final JTextField hotelNameField = new JTextField();
        hotelNameField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        hotelNameField.setBounds(386, 170, 281, 68);
        contentPane.add(hotelNameField);
        hotelNameField.setColumns(10);

        final JLabel hotelRating = new JLabel("Hotel rating");
        hotelRating.setForeground(Color.BLACK);
        hotelRating.setFont(new Font("Tahoma", Font.PLAIN, 31));
        hotelRating.setBounds(455, 235, 193, 52);
        contentPane.add(hotelRating);

        final JTextField hotelRatingField = new JTextField();
        hotelRatingField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        hotelRatingField.setBounds(386, 286, 281, 68);
        hotelRatingField.setColumns(10);
        hotelRatingField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                hotelRatingField.setEditable(ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9');
            }
        });
        contentPane.add(hotelRatingField);

        final JButton createButton = new JButton("Create");
        createButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
        createButton.setBounds(447, 392, 160, 73);
        createButton.addActionListener(new AddHotelController(this, createButton, hotelNameField, hotelRatingField));

        contentPane.add(createButton);
    }
}
