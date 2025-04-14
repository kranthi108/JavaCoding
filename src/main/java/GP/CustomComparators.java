package GP;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

class Movie implements Comparable<Movie> {
    String name;
    int rating;
    public Movie(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }


    @Override
    public int compareTo(@NotNull Movie o) {
        return this.name.compareTo(o.name);
    }
}
class Rating implements Comparator<Movie> {
    @Override
    public int compare(Movie o1, Movie o2) {
        return o1.rating - o2.rating;
    }
}

public class CustomComparators {


    public static void main(String[] args) {
        System.out.println("Hello");
        ArrayList<Movie> movies = new ArrayList<>(); // <Movie>
        movies.add(new Movie("Avatar", 8));
        movies.add(new Movie("Avengers", 9));
        movies.add(new Movie("The Dark Knight", 9));
        movies.add(new Movie("Star Wars", 7));
        movies.sort(new Rating());
        Collections.sort(movies);
//        Collections.sort(movies, new Rating());
        movies.forEach(movie -> System.out.println("Name: "+movie.name+", Rating: "+movie.rating));
        int n[] = {1,4,3,6,5,0};
        Map<Integer, Long> frequencyMap = Arrays.stream(n)
                .boxed()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        frequencyMap.forEach((key, value) -> System.out.println("Key: "+key+", Value: "+value));
        Map<Integer, Long> f = Arrays.stream(n)
                .boxed()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));
    }

}
