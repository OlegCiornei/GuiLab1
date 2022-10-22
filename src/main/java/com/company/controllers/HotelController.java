package com.company.controllers;

import com.company.views.AddHotelView;
import com.company.views.DeleteHotelView;
import com.company.views.HotelsView;
import com.company.views.SearchHotelView;
import lombok.SneakyThrows;

import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public record HotelController(JFrame frame, String action) implements ActionListener {

    @SneakyThrows
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.dispose();
        switch (action) {
            case "addHotel" -> {
                final AddHotelView addHotelView = new AddHotelView();
                addHotelView.setTitle("Add hotel");
                addHotelView.setVisible(true);
            }
            case "deleteHotel" -> {
                final DeleteHotelView deleteHotelView = new DeleteHotelView();
                deleteHotelView.setTitle("Delete hotel");
                deleteHotelView.setVisible(true);
            }
            case "searchHotel" -> {
                final SearchHotelView searchHotelView = new SearchHotelView();
                searchHotelView.setTitle("Search hotel");
                searchHotelView.setVisible(true);
            }
            case "getHotels" -> {
                final HotelsView hotelsView = new HotelsView();
                hotelsView.setTitle("Hotels by name");
                hotelsView.setVisible(true);
            }
            default -> throw new IllegalArgumentException("No action selected");
        }
    }
}
