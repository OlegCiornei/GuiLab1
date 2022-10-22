package com.company.services;

import com.company.model.entities.Hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

import static java.util.Objects.requireNonNull;

public class ReviewService {

    private final HotelService hotelService = new HotelService();

    public void postReview(final String review, final Long rating, final String hotel) throws SQLException {
        final Connection connection = requireNonNull(ConnectionService.getConnection());

        final Hotel byName = Optional.ofNullable(hotelService.findByName(hotel.trim()))
                .orElseThrow(()-> new IllegalArgumentException("There is no such hotel"));
        final Long hotelId = byName.getId();

        hotelService.updateRating(byName, rating);

        final PreparedStatement insertStatement = connection.prepareStatement("insert into t_reviews (review, rating, hotel) values (?,?,?)");

        insertStatement.setString(1, review);
        insertStatement.setLong(2, rating);
        insertStatement.setLong(3, hotelId);

        insertStatement.executeUpdate();
    }
}
