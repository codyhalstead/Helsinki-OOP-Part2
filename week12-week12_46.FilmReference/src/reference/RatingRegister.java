package reference;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import reference.domain.Rating;
import reference.domain.Film;
import reference.domain.Person;
 
public class RatingRegister {
 
    private Map<Person, Map<Film, Rating>> personalRatings;
    private Map<Film, List<Rating>> filmRatings;
 
    public RatingRegister() {
        this.personalRatings = new HashMap<Person, Map<Film, Rating>>();
        this.filmRatings = new HashMap<Film, List<Rating>>();
    }
 
    public void addRating(Film film, Rating rating) {
        if (!this.filmRatings.containsKey(film)) {
            this.filmRatings.put(film, new ArrayList<Rating>());
        }
 
        List<Rating> movieRatings = this.filmRatings.get(film);
        movieRatings.add(rating);
    }
 
    public Map<Film, List<Rating>> filmRatings() {
        return this.filmRatings;
    }
 
    public List<Rating> getRatings(Film film) {
        return this.filmRatings.get(film);
    }
 
    public void addRating(Person person, Film film, Rating rating) {
        if (!this.personalRatings.containsKey(person)) {
            this.personalRatings.put(person, new HashMap<Film, Rating>());
        }
 
        Map<Film, Rating> personRatings = this.personalRatings.get(person);
        if (personRatings.containsKey(film)) {
            return;
        }
 
        personRatings.put(film, rating);
        addRating(film, rating);
    }
 
    public Map<Film, Rating> getPersonalRatings(Person person) {
        if (!this.personalRatings.containsKey(person)) {
            return new HashMap();
        }
 
        return this.personalRatings.get(person);
    }
 
    public Rating getRating(Person person, Film film) {
        if (!this.personalRatings.containsKey(person)) {
            return Rating.NOT_WATCHED;
        }
 
        Map<Film, Rating> personRatings = this.personalRatings.get(person);
        if (!personRatings.containsKey(film)) {
            return Rating.NOT_WATCHED;
        }
 
        return personRatings.get(film);
    }
 
    public List<Person> reviewers() {
        return new ArrayList<Person>(this.personalRatings.keySet());
    }
}