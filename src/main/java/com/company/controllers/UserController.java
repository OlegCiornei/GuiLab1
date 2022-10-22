package com.company.controllers;

import com.company.model.entities.Role;
import com.company.model.entities.User;
import com.company.services.UserService;
import com.company.views.HotelManagementView;
import com.company.views.ReviewView;
import lombok.RequiredArgsConstructor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import static java.util.Objects.nonNull;

@RequiredArgsConstructor
public class UserController implements ActionListener {

    private final JFrame frame;
    private final JButton button;
    private final JTextField usernameField;
    private final JPasswordField passwordField;

    private final UserService userService = new UserService();

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            final User user = userService.getUser(usernameField.getText(), passwordField.getText());
            if (nonNull(user)) {
                if(user.getRole().equals(Role.ADMIN)){
                    JOptionPane.showMessageDialog(button, "You have successfully logged in as administrator");
                    frame.dispose();
                    final HotelManagementView hotelView = new HotelManagementView();
                    hotelView.setTitle("Hotels management");
                    hotelView.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(button, "You have successfully logged in as user");
                    frame.dispose();
                    final ReviewView hotelView = new ReviewView();
                    hotelView.setTitle("Review");
                    hotelView.setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(button, "Wrong Username or Password");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
