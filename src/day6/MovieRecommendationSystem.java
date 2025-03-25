package day6;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

class Movie {
    private String title;
    private String genre;
    private double rating;
    private LocalDate releaseDate;

    public Movie(String title, String genre, double rating, LocalDate releaseDate) {
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }
}

public class MovieRecommendationSystem {
    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
            new Movie("Inception", "Sci-Fi", 8.8, LocalDate.of(2010, 7, 16)),
            new Movie("Interstellar", "Sci-Fi", 8.6, LocalDate.of(2014, 11, 7)),
            new Movie("The Dark Knight", "Action", 9.0, LocalDate.of(2008, 7, 18)),
            new Movie("Forrest Gump", "Drama", 8.8, LocalDate.of(1994, 7, 6)),
            new Movie("Avengers: Endgame", "Action", 8.4, LocalDate.of(2019, 4, 26)),
            new Movie("Parasite", "Drama", 8.6, LocalDate.of(2019, 5, 30))
        );

        // Sorting movies by rating (descending) and release date (newest first)
        List<Movie> sortedMovies = movies.stream()
            .sorted(Comparator.comparing(Movie::getRating).reversed()
                .thenComparing(Movie::getReleaseDate).reversed())
            .collect(Collectors.toList());

        System.out.println("Movies sorted by rating and release date:");
        sortedMovies.forEach(m -> System.out.println(m.getTitle() + " - Rating: " + m.getRating() + " - Released: " + m.getReleaseDate()));

        // Filtering movies based on minimum rating and genre
        double minRating = 8.5;
        String selectedGenre = "Sci-Fi";

        List<Movie> recommendedMovies = movies.stream()
            .filter(m -> m.getRating() > minRating && m.getGenre().equalsIgnoreCase(selectedGenre))
            .collect(Collectors.toList());

        System.out.println("\nRecommended movies (" + selectedGenre + " with rating > " + minRating + "):");
        recommendedMovies.forEach(m -> System.out.println(m.getTitle() + " - Rating: " + m.getRating()));

        // Optional: Get a random top-rated movie
        Optional<Movie> topMovie = recommendedMovies.stream()
            .findAny();

        System.out.println("\nTop-rated movie recommendation:");
        topMovie.ifPresentOrElse(
            m -> System.out.println(m.getTitle() + " - Rating: " + m.getRating()),
            () -> System.out.println("No movies available for recommendation."));
    }
}

