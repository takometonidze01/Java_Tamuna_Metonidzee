import com.example.java_tamuna_metonidzee.Flights;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class FlightsTest {

    @Test
    public void testGettersAndSetters() {
        Flights flights = new Flights();
        flights.setId(1);
        flights.setDirection("New York");
        flights.setDateTime(new Date());
        flights.setNumberOfSeats(100);
        flights.setTotalPrice(1000);
        assertEquals(1, flights.getId());
        assertEquals("New York", flights.getDirection());
        assertNotNull(flights.getDateTime());
        assertEquals(100, flights.getNumberOfSeats());
        assertEquals(1000, flights.getTotalPrice());
    }

}
