package day6;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

class Flight {
    private String flightNumber;
    private String destination;
    private LocalDateTime departureTime;
    private int duration; // in minutes
    private double price;

    public Flight(String flightNumber, String destination, LocalDateTime departureTime, int duration, double price) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureTime = departureTime;
        this.duration = duration;
        this.price = price;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public int getDuration() {
        return duration;
    }

    public double getPrice() {
        return price;
    }
}

public class FlightBookingSystem {
    public static void main(String[] args) {
        List<Flight> flights = Arrays.asList(
            new Flight("AI101", "New York", LocalDateTime.now().plusHours(2), 480, 550.0),
            new Flight("BA202", "London", LocalDateTime.now().plusHours(5), 420, 450.0),
            new Flight("EK303", "Dubai", LocalDateTime.now().plusHours(7), 360, 600.0),
            new Flight("SQ404", "Singapore", LocalDateTime.now().plusHours(1), 500, 700.0),
            new Flight("LH505", "Berlin", LocalDateTime.now().plusHours(3), 450, 500.0)
        );

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy, HH:mm a");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime next6Hours = now.plusHours(6);

        // Find flights departing within the next 6 hours
        List<Flight> upcomingFlights = flights.stream()
            .filter(f -> f.getDepartureTime().isAfter(now) && f.getDepartureTime().isBefore(next6Hours))
            .collect(Collectors.toList());

        System.out.println("Flights departing in the next 6 hours:");
        upcomingFlights.forEach(f -> System.out.println(f.getFlightNumber() + " - " + f.getDestination() + " - Departs at: " + f.getDepartureTime().format(formatter)));

        // Find the cheapest flight to a given destination
        String destination = "London";
        Optional<Flight> cheapestFlight = flights.stream()
            .filter(f -> f.getDestination().equalsIgnoreCase(destination))
            .min(Comparator.comparing(Flight::getPrice));

        System.out.println("\nCheapest flight to " + destination + ":");
        cheapestFlight.ifPresentOrElse(
            f -> System.out.println(f.getFlightNumber() + " - Price: " + f.getPrice()),
            () -> System.out.println("No flights available to " + destination));

        // Find the fastest flight (shortest duration)
        Optional<Flight> fastestFlight = flights.stream()
            .min(Comparator.comparing(Flight::getDuration));

        System.out.println("\nFastest flight:");
        fastestFlight.ifPresentOrElse(
            f -> System.out.println(f.getFlightNumber() + " - Duration: " + f.getDuration() + " minutes"),
            () -> System.out.println("No flight data available"));
    }
}

