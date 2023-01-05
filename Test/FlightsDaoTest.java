import com.example.java_tamuna_metonidzee.Flights;
import com.example.java_tamuna_metonidzee.FlightsDao;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class FlightsDaoTest {

    @Test
    public void testFlights() throws SQLException {
        FlightsDao flightsDao = new FlightsDao();
        List<Flights> flights = flightsDao.flighs("test_user");
        assertNotNull(flights);
        assertFalse(flights.isEmpty());
        for (Flights flight : flights) {
            assertNotNull(flight.getDirection());
            assertNotNull(flight.getDateTime());
            assertTrue(flight.getNumberOfSeats() > 0);
            assertTrue(flight.getTotalPrice() > 0);
        }
    }

}