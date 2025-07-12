package com.pets.client;

import javax.swing.*;

import com.pets.ejb.UserService;

public class LoginFrame extends JFrame {
    public LoginFrame(UserService service) {
        setTitle("Login");
        setSize(300, 150);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JLabel userLbl = new JLabel("Username");
        userLbl.setBounds(10, 10, 80, 25);
        JTextField userTxt = new JTextField();
        userTxt.setBounds(100, 10, 160, 25);
        JLabel passLbl = new JLabel("Password");
        passLbl.setBounds(10, 40, 80, 25);
        JPasswordField passTxt = new JPasswordField();
        passTxt.setBounds(100, 40, 160, 25);
        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(100, 80, 80, 25);
        loginBtn.addActionListener(e -> {
            if (service.login(userTxt.getText(), new String(passTxt.getPassword()))) {
                JOptionPane.showMessageDialog(this, "Login Success");
            } else JOptionPane.showMessageDialog(this, "Invalid", "Error", JOptionPane.ERROR_MESSAGE);
        });
        add(userLbl);
        add(userTxt);
        add(passLbl);
        add(passTxt);
        add(loginBtn);
    }

    public LoginFrame() {
        setTitle("Login");
        setSize(300, 150);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JLabel userLbl = new JLabel("Username");
        userLbl.setBounds(10, 10, 80, 25);
        JTextField userTxt = new JTextField();
        userTxt.setBounds(100, 10, 160, 25);
        JLabel passLbl = new JLabel("Password");
        passLbl.setBounds(10, 40, 80, 25);
        JPasswordField passTxt = new JPasswordField();
        passTxt.setBounds(100, 40, 160, 25);
        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(100, 80, 80, 25);
        loginBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Invalid", "Error", JOptionPane.ERROR_MESSAGE);
        });
        add(userLbl);
        add(userTxt);
        add(passLbl);
        add(passTxt);
        add(loginBtn);
    }
}