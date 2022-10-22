package com.company.controllers;

import com.company.model.entities.Hotel;
import com.company.services.HotelService;
import com.company.views.HotelManagementView;
import com.company.views.HotelView;
import lombok.RequiredArgsConstructor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import static java.util.Objects.nonNull;

@RequiredArgsConstructor
public class SearchHotelController implements ActionListener {
    private final JFrame frame;
    private final JButton button;
    private final JTextField hotelName;

    private final HotelService hotelService = new HotelService();

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            final Hotel hotel = hotelService.findByName(hotelName.getText());
            if (nonNull(hotel)) {
                frame.dispose();
                HotelView hotelView = new HotelView(hotel);
                hotelView.setTitle("Hotel");
                hotelView.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(button, "There is no such hotel");
                frame.dispose();
                HotelManagementView hotelView = new HotelManagementView();
                hotelView.setTitle("Hotel");
                hotelView.setVisible(true);
            }
        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(button, "Error occurred while searching data");
            exception.printStackTrace();
        }
    }
}
