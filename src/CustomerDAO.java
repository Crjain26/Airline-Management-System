import java.sql.*;
public class CustomerDAO {

    public Customer getCustomerByEmail(String email) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM Customer WHERE email=?")) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addBooking(int customerId, String flightNumber) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO Booking(customer_id, flight_number) VALUES (?, ?)")) {
            ps.setInt(1, customerId);
            ps.setString(2, flightNumber);
            ps.executeUpdate();
            System.out.println("Booking successful!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewBookings(int customerId) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "SELECT f.flight_number, f.source, f.destination FROM Booking b JOIN Flight f ON b.flight_number=f.flight_number WHERE b.customer_id=?")) {
            ps.setInt(1, customerId);
            ResultSet rs = ps.executeQuery();
            System.out.println("Customer Bookings:");
            while (rs.next()) {
                System.out.println("Flight: " + rs.getString("flight_number") + " | " +
                        rs.getString("source") + " -> " + rs.getString("destination"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
