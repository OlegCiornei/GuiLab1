package com.company.controllers;

import com.company.services.HotelService;
import com.company.views.HotelManagementView;
import lombok.RequiredArgsConstructor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

@RequiredArgsConstructor
public class AddHotelController implements ActionListener {

    private final JFrame frame;
    private final JButton button;
    private final JTextField hotelNameField;
    private final JTextField hotelRatingField;

    private final HotelService hotelService = new HotelService();

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (hotelService.createHotel(hotelNameField.getText(), hotelRatingField.getText()))
                JOptionPane.showMessageDialog(button, "You have successfully created hotel");
            frame.dispose();
            HotelManagementView hotelView = new HotelManagementView();
            hotelView.setTitle("Hotels management");
            hotelView.setVisible(true);
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(button, "Invalid data");
            exception.printStackTrace();
        } catch (SQLException exception) {
            if (exception.getLocalizedMessage().contains("duplicate key value violates unique constraint "))
                JOptionPane.showMessageDialog(button, "Hotel name should be unique");
            else {
                JOptionPane.showMessageDialog(button, "Error occurred while saving data");
            }
            exception.printStackTrace();
        }
    }
}
