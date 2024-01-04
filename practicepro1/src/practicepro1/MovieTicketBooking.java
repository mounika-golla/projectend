package practicepro1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Class to represent a Movie
class Movie {
    private String title;
    private int totalSeats;
    private int availableSeats;

    public Movie(String title, int totalSeats) {
        this.title = title;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }

    public String getTitle() {
        return title;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void bookSeats(int numSeats) {
        if (numSeats > 0 && numSeats <= availableSeats) {
            availableSeats -= numSeats;
            System.out.println("Seats booked successfully!");
        } else {
            System.out.println("Invalid number of seats or not enough seats available.");
        }
    }
}

// Class to represent a Theatre
class Theatre {
    private Map<String, Movie> movies; // Map to store movies by title

    public Theatre() {
        movies = new HashMap<>();
    }

    public void addMovie(String title, int totalSeats) {
        movies.put(title, new Movie(title, totalSeats));
    }

    public Movie getMovie(String title) {
        return movies.get(title);
    }

	public Map<String, Movie> getMovies() {
		// TODO Auto-generated method stub
		return null;
	}
}

// Class to represent a Booking
class Booking {
    private String movieTitle;
    private int numSeats;

    public Booking(String movieTitle, int numSeats) {
        this.movieTitle = movieTitle;
        this.numSeats = numSeats;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public int getNumSeats() {
        return numSeats;
    }
}

// Class to manage the booking system
class BookingSystem {
    private Theatre theatre;
    private Map<String, Booking> bookings;

    public BookingSystem(Theatre theatre) {
        this.theatre = theatre;
        this.bookings = new HashMap<>();
    }

    public void displayMovies() {
        System.out.println("Available Movies:");
        for (String title : theatre.getMovies().keySet()) {
            System.out.println("- " + title);
        }
    }

    public void bookTicket(String movieTitle, int numSeats) {
        Movie movie = theatre.getMovie(movieTitle);
        if (movie != null) {
            movie.bookSeats(numSeats);
            Booking booking = new Booking(movieTitle, numSeats);
            bookings.put(movieTitle, booking);
            System.out.println("Booking successful!");
        } else {
            System.out.println("Movie not found.");
        }
    }

    public void displayBookingStatus() {
        System.out.println("Booking Status:");
        for (Booking booking : bookings.values()) {
            System.out.println("Movie: " + booking.getMovieTitle() + ", Seats: " + booking.getNumSeats());
        }
    }
}

// Main class for the Movie Ticket Booking Simulator
public class MovieTicketBooking {
    public static void main(String[] args) {
        Theatre theatre = new Theatre();
        theatre.addMovie("Inception", 50);
        theatre.addMovie("The Dark Knight", 40);

        BookingSystem bookingSystem = new BookingSystem(theatre);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMovie Ticket Booking Simulator");
            System.out.println("1. Display Available Movies");
            System.out.println("2. Book Ticket");
            System.out.println("3. Display Booking Status");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    bookingSystem.displayMovies();
                    break;
                case 2:
                    System.out.print("Enter movie title: ");
                    String movieTitle = scanner.next();
                    System.out.print("Enter number of seats to book: ");
                    int numSeats = scanner.nextInt();
                    bookingSystem.bookTicket(movieTitle, numSeats);
                    break;
                case 3:
                    bookingSystem.displayBookingStatus();
                    break;
                case 4:
                    System.out.println("Exiting the Movie Ticket Booking Simulator. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}


