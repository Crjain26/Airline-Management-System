import java.sql.*;
import java.util.*;

public class FlightDAO {

    public List<Flight> getAllFlights() {
        List<Flight> flights = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Flight")) {

            while (rs.next()) {
                flights.add(new Flight(
                        rs.getString("flight_number"),
                        rs.getString("source"),
                        rs.getString("destination"),
                        rs.getInt("seats")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flights;
    }

    public Flight getFlightByNumber(String flightNumber) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM Flight WHERE flight_number=?")) {
            ps.setString(1, flightNumber);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Flight(
                        rs.getString("flight_number"),
                        rs.getString("source"),
                        rs.getString("destination"),
                        rs.getInt("seats")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
