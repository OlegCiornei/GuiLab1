package com.company.views;

import com.company.controllers.ReviewController;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ReviewView extends JFrame {

    public ReviewView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1035, 597);
        setResizable(false);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        final JLabel loginLabel = new JLabel("Review");
        loginLabel.setForeground(Color.BLACK);
        loginLabel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
        loginLabel.setBounds(467, 13, 140, 93);
        contentPane.add(loginLabel);

        final JLabel hotelName = new JLabel("Hotel name");
        hotelName.setForeground(Color.BLACK);
        hotelName.setFont(new Font("Tahoma", Font.PLAIN, 31));
        hotelName.setBounds(185, 70, 193, 52);
        contentPane.add(hotelName);

        final JTextField hotelNameField = new JTextField();
        hotelNameField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        hotelNameField.setBounds(120, 120, 281, 68);
        contentPane.add(hotelNameField);
        hotelNameField.setColumns(10);

        final JTextArea reviewField = new JTextArea();
        reviewField.setWrapStyleWord(true);
        reviewField.setLineWrap(true);
        reviewField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        reviewField.setBounds(550, 120, 400, 253);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        reviewField.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        contentPane.add(reviewField);

        final JLabel hotelRating = new JLabel("Rating");
        hotelRating.setForeground(Color.BLACK);
        hotelRating.setFont(new Font("Tahoma", Font.PLAIN, 31));
        hotelRating.setBounds(215, 240, 193, 52);
        contentPane.add(hotelRating);

        final JTextField hotelRatingField = new JTextField();
        hotelRatingField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        hotelRatingField.setBounds(120, 305, 281, 68);
        hotelRatingField.setColumns(10);
        hotelRatingField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                hotelRatingField.setEditable(ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9');
            }
        });
        contentPane.add(hotelRatingField);


        final JButton post = new JButton("Post");
        post.setFont(new Font("Tahoma", Font.PLAIN, 26));
        post.setBounds(447, 442, 160, 73);
        post.addActionListener(new ReviewController(this, post, reviewField, hotelRatingField, hotelNameField));
        contentPane.add(post);
    }
}
