package com.company.controllers;

import com.company.services.ReviewService;
import com.company.views.UserLoginView;
import lombok.RequiredArgsConstructor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

@RequiredArgsConstructor
public class ReviewController implements ActionListener {
    private final JFrame frame;
    private final JButton button;
    private final JTextArea reviewField;
    private final JTextField hotelRatingField;
    private final JTextField hotelField;
    private final ReviewService reviewService = new ReviewService();

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            reviewService.postReview(reviewField.getText(), Long.valueOf(hotelRatingField.getText()), hotelField.getText());
            frame.dispose();
            JOptionPane.showMessageDialog(button, "You have successfully posted review");
            UserLoginView frame = new UserLoginView();
            frame.setVisible(true);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
