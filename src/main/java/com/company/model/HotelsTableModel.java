package com.company.model;

import com.company.model.entities.Hotel;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class HotelsTableModel extends AbstractTableModel {

    private static final int COLUMN_NO = 0;
    private static final int COLUMN_NAME = 1;
    private static final int COLUMN_RATING = 2;

    private final String[] columnNames = {"Id", "Name", "Rating"};
    private final List<Hotel> hotels;

    public HotelsTableModel(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return hotels.size();
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (hotels.isEmpty()) {
            return Object.class;
        }
        return getValueAt(0, columnIndex).getClass();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Hotel hotel = hotels.get(rowIndex);

        return switch (columnIndex) {
            case COLUMN_NO -> hotel.getId();
            case COLUMN_NAME -> hotel.getName();
            case COLUMN_RATING -> hotel.getRating();
            default -> throw new IllegalArgumentException("Invalid column index");
        };
    }
}

