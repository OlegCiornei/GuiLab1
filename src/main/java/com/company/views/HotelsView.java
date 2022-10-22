package com.company.views;

import com.company.model.HotelsTableModel;
import com.company.services.HotelService;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;

public class HotelsView extends JFrame {

    public HotelsView() throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1035, 597);
        setResizable(false);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        final JLabel hotelLabel = new JLabel("Hotels");
        hotelLabel.setForeground(Color.BLACK);
        hotelLabel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
        hotelLabel.setBounds(470, 13, 280, 93);
        contentPane.add(hotelLabel);

        final HotelService hotelService = new HotelService();
        final TableModel tableModel = new HotelsTableModel(hotelService.findAll());
        JTable table = new JTable(tableModel);
        table.setAutoCreateRowSorter(true);
        table.setFont(new Font("Tahoma", Font.PLAIN, 14));

        final JScrollPane jScrollPane = new JScrollPane(table);
        jScrollPane.setBounds(15, 100, 990, 300);
        jScrollPane.setBackground(Color.BLACK);
        jScrollPane.setVisible(true);
        contentPane.add(jScrollPane);
    }
}
