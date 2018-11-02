package reference.comparator;
 
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import reference.domain.Rating;
import reference.domain.Film;
 
public class FilmComparator implements Comparator<Film> {
 
    private Map<Film, Double> averageRating;
 
    public FilmComparator(Map<Film, List<Rating>> ratings) {
        this.averageRating = createAverageRatings(ratings);
    }
 
    private Map<Film, Double> createAverageRatings(Map<Film, List<Rating>> ratings) {
        Map<Film, Double> averages = new HashMap<Film, Double>();
 
        for (Film film : ratings.keySet()) {
            int ratingSum = 0;
 
            List<Rating> movieRatings = ratings.get(film);
            for (Rating rating : movieRatings) {
                ratingSum += rating.getValue();
            }
 
            averages.put(film, 1.0 * ratingSum / movieRatings.size());
        }
 
        return averages;
    }
 
    @Override
    public int compare(Film film1, Film film2) {
        double film1Vote = 0;
        double film2Vote = 0;
 
        if (averageRating.containsKey(film1)) {
            film1Vote = averageRating.get(film1);
        }
 
 
        if (averageRating.containsKey(film2)) {
            film2Vote = averageRating.get(film2);
        }
 
        return new Double(film2Vote).compareTo(film1Vote);
    }
}