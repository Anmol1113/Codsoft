import java.util.*;

class Movie {
    String title;
    List<String> genres;

    public Movie(String title, List<String> genres) {
        this.title = title;
        this.genres = genres;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getGenres() {
        return genres;
    }
}

class RecommendationSystem {
    private List<Movie> movies;

    public RecommendationSystem() {
        // Sample movie data (title, genres)
        movies = new ArrayList<>();
        movies.add(new Movie("Inception", Arrays.asList("Action", "Sci-Fi", "Thriller")));
        movies.add(new Movie("The Matrix", Arrays.asList("Action", "Sci-Fi")));
        movies.add(new Movie("The Godfather", Arrays.asList("Crime", "Drama")));
        movies.add(new Movie("The Dark Knight", Arrays.asList("Action", "Crime", "Drama")));
        movies.add(new Movie("Forrest Gump", Arrays.asList("Drama", "Romance")));
        movies.add(new Movie("Titanic", Arrays.asList("Drama", "Romance")));
    }

    public List<Movie> recommendMovies(String preferredGenre) {
        List<Movie> recommendedMovies = new ArrayList<>();

        for (Movie movie : movies) {
            if (movie.getGenres().contains(preferredGenre)) {
                recommendedMovies.add(movie);
            }
        }

        return recommendedMovies;
    }
}

public class Main {
    public static void main(String[] args) {
        RecommendationSystem recommendationSystem = new RecommendationSystem();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your preferred genre (e.g., Action, Drama, Sci-Fi): ");
        String preferredGenre = scanner.nextLine().trim();

        List<Movie> recommendations = recommendationSystem.recommendMovies(preferredGenre);

        if (recommendations.isEmpty()) {
            System.out.println("Sorry, no recommendations found for this genre.");
        } else {
            System.out.println("Recommended movies based on your preference:");
            for (Movie movie : recommendations) {
                System.out.println("- " + movie.getTitle());
            }
        }
    }
}