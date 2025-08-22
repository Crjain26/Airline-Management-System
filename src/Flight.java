public class Flight {
    private String flightNumber;
    private String source;
    private String destination;
    private int seats;

    public Flight(String flightNumber, String source, String destination, int seats) {
        this.flightNumber = flightNumber;
        this.source = source;
        this.destination = destination;
        this.seats = seats;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void displayFlightInfo() {
        System.out.println("Flight " + flightNumber + " | " + source + " -> " + destination + " | Seats: " + seats);
    }
}
