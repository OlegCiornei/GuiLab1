package com.company.views;

import com.company.controllers.UserController;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;

public class UserLoginView extends JFrame {

    public UserLoginView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1035, 597);
        setResizable(false);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        final JLabel loginLabel = new JLabel("Login");
        loginLabel.setForeground(Color.BLACK);
        loginLabel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
        loginLabel.setBounds(467, 13, 120, 93);
        contentPane.add(loginLabel);

        final JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setForeground(Color.BLACK);
        usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 31));
        usernameLabel.setBounds(455, 115, 193, 52);
        contentPane.add(usernameLabel);

        final JTextField usernameField = new JTextField();
        usernameField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        usernameField.setBounds(386, 170, 281, 68);
        contentPane.add(usernameField);
        usernameField.setColumns(10);

        final JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setForeground(Color.BLACK);
        passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 31));
        passwordLabel.setBounds(455, 235, 193, 52);
        contentPane.add(passwordLabel);

        final JPasswordField passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        passwordField.setBounds(386, 286, 281, 68);
        contentPane.add(passwordField);

        final JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
        loginButton.setBounds(447, 392, 160, 73);
        loginButton.addActionListener(new UserController(this, loginButton, usernameField, passwordField));
        contentPane.add(loginButton);
    }
}