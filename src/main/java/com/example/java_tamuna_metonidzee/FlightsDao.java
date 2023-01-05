package com.example.java_tamuna_metonidzee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Data access object
 *
 * @author Julian Jupiter
 *
 */
public class FlightsDao {

    private static final Logger logger = Logger.getLogger(FlightsDao.class.getName());

    public List<Flights> flighs(String username) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        List<Flights> flights = new ArrayList<>();

        try {
            connection = Database.getDBConnection();
            connection.setAutoCommit(false);
            String query = "SELECT direction, date_time, number_of_seats, total_price FROM flights";
            statement = connection.prepareStatement(query);
            int counter = 1;
            statement.setString(counter++, username);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Flights flight = new Flights();
                flight.setId(resultSet.getInt(1));
                flight.setDirection(resultSet.getString(2));
                flight.setNumberOfSeats(resultSet.getInt(3));
                flight.setDateTime(resultSet.getDate(4));
                flight.setTotalPrice(resultSet.getInt(5));
                flights.add(flight);
            }

            return flights;
        } catch (SQLException exception) {
            logger.log(Level.SEVERE, exception.getMessage());
        } finally {
            if (null != statement) {
                statement.close();
            }

            if (null != connection) {
                connection.close();
            }
        }

        return flights;
    }


}
