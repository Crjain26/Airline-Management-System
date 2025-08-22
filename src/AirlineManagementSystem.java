import java.util.*;

public class AirlineManagementSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static FlightDAO flightDAO = new FlightDAO();
    private static CustomerDAO customerDAO = new CustomerDAO();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Airline Management System ---");
            System.out.println("1. View All Flights");
            System.out.println("2. Book a Flight");
            System.out.println("3. View Customer Bookings");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> viewAllFlights();
                case 2 -> bookFlight();
                case 3 -> viewCustomerBookings();
                case 4 -> System.out.println("Exiting system. Goodbye!");
                default -> System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);
    }

    private static void viewAllFlights() {
        List<Flight> flights = flightDAO.getAllFlights();
        System.out.println("\nAvailable Flights:");
        for (Flight f : flights) {
            f.displayFlightInfo();
        }
    }

    private static void bookFlight() {
        System.out.print("Enter customer email: ");
        String email = scanner.nextLine();
        Customer customer = customerDAO.getCustomerByEmail(email);

        if (customer == null) {
            System.out.println("Customer not found!");
            return;
        }

        System.out.print("Enter flight number to book: ");
        String flightNum = scanner.nextLine();
        Flight flight = flightDAO.getFlightByNumber(flightNum);

        if (flight == null) {
            System.out.println("Flight not found!");
        } else {
            customerDAO.addBooking(customer.id, flightNum);
        }
    }

    private static void viewCustomerBookings() {
        System.out.print("Enter customer email: ");
        String email = scanner.nextLine();
        Customer customer = customerDAO.getCustomerByEmail(email);

        if (customer == null) {
            System.out.println("Customer not found!");
        } else {
            customerDAO.viewBookings(customer.id);
        }
    }
}
