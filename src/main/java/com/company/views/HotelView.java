package com.company.views;

import com.company.model.entities.Hotel;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;

public class HotelView extends JFrame {

    public HotelView(final Hotel hotel) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1035, 597);
        setResizable(false);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        final JLabel hotelLabel = new JLabel("Hotel");
        hotelLabel.setForeground(Color.BLACK);
        hotelLabel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
        hotelLabel.setBounds(470, 13, 280, 93);
        contentPane.add(hotelLabel);

        final JLabel hotelNameLabel = new JLabel("Hotel name");
        hotelNameLabel.setForeground(Color.BLACK);
        hotelNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 31));
        hotelNameLabel.setBounds(370, 165, 193, 52);
        contentPane.add(hotelNameLabel);

        final JLabel hotelName = new JLabel(hotel.getName());
        hotelName.setForeground(Color.BLACK);
        hotelName.setFont(new Font("Tahoma", Font.PLAIN, 31));
        hotelName.setBounds(555, 165, 165, 52);
        contentPane.add(hotelName);

        final JLabel hotelRatingLabel = new JLabel("Hotel rating");
        hotelRatingLabel.setForeground(Color.BLACK);
        hotelRatingLabel.setFont(new Font("Tahoma", Font.PLAIN, 31));
        hotelRatingLabel.setBounds(370, 235, 193, 52);
        contentPane.add(hotelRatingLabel);

        final JLabel hotelRating = new JLabel(String.valueOf(hotel.getRating()));
        hotelRating.setForeground(Color.BLACK);
        hotelRating.setFont(new Font("Tahoma", Font.PLAIN, 31));
        hotelRating.setBounds(555, 235, 235, 52);
        contentPane.add(hotelRating);
    }
}
