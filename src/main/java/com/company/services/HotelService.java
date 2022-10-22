package com.company.services;

import com.company.model.entities.Hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.requireNonNull;

public class HotelService {

    private final Connection connection = requireNonNull(ConnectionService.getConnection());


    public boolean createHotel(final String name, final String rating) throws SQLException {
        final PreparedStatement insertStatement = connection.prepareStatement("insert into t_hotels(name,rating) values (?, ?)");

        insertStatement.setString(1, name);
        insertStatement.setDouble(2, Double.parseDouble(rating));

        return insertStatement.executeUpdate() != 0;
    }

    public boolean deleteHotel(final String name) throws SQLException {
        final PreparedStatement deleteStatement = connection.prepareStatement("delete from t_hotels where name = ?");

        deleteStatement.setString(1, name);

        return deleteStatement.executeUpdate() != 0;
    }

    public Hotel findByName(final String name) throws SQLException {
        final PreparedStatement getStatement = connection.prepareStatement("select id, name, rating from t_hotels where name = ?");

        getStatement.setString(1, name);

        final ResultSet resultSet = getStatement.executeQuery();

        if (isNull(resultSet))
            throw new IllegalArgumentException("No hotel found");

        return resultSet.next() ? extractHotel(resultSet) : null;
    }

    public List<Hotel> findAll() throws SQLException {
        final PreparedStatement getStatement = connection.prepareStatement("select id, name, rating from t_hotels");

        final ResultSet resultSet = getStatement.executeQuery();

        if (isNull(resultSet))
            throw new IllegalArgumentException("No hotel found");

        final List<Hotel> hotels = new ArrayList<>();
        while (resultSet.next())
            hotels.add(extractHotel(resultSet));

        return hotels;
    }

    public void updateRating(final Hotel hotel, final Long rating) throws SQLException {
        final PreparedStatement getStatement = connection.prepareStatement("select count(*) from t_reviews where hotel = ?");
        getStatement.setLong(1, hotel.getId());

        ResultSet resultSet = getStatement.executeQuery();

        final Long amountOfReviews = resultSet.next() ? resultSet.getLong(1) : 1;

        final double newRating = ((hotel.getRating() * amountOfReviews) + rating) / (amountOfReviews + 1);

        final PreparedStatement updateStatement = connection.prepareStatement("update t_hotels set rating = ? where id = ?");
        updateStatement.setDouble(1, newRating);
        updateStatement.setLong(2, hotel.getId());

        updateStatement.executeUpdate();
    }

    private Hotel extractHotel(ResultSet resultSet) throws SQLException {
        return Hotel.builder()
                .id(resultSet.getLong(1))
                .name(resultSet.getString(2))
                .rating(resultSet.getDouble(3))
                .build();
    }
}
