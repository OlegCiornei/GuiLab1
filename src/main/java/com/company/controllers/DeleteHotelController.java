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
public class DeleteHotelController implements ActionListener {

    private final JFrame frame;
    private final JButton button;
    private final JTextField hotelName;

    private final HotelService hotelService = new HotelService();

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (hotelService.deleteHotel(hotelName.getText())) {
                JOptionPane.showMessageDialog(button, "You have successfully deleted hotel");
                frame.dispose();
                HotelManagementView hotelView = new HotelManagementView();
                hotelView.setTitle("Hotels management");
                hotelView.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(button, "There is no such hotel");
            }
        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(button, "Error occurred while deleting data");
            exception.printStackTrace();
        }
    }
}
