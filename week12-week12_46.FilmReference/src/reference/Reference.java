/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package reference;

//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//import reference.comparator.FilmComparator;
//import reference.comparator.PersonComparator;
//import reference.domain.Film;
//import reference.domain.Person;
//import reference.domain.Rating;

/**
 *
 * @author Cody
 */
//public class Reference {
//    private RatingRegister rr;
    
//    public Reference(RatingRegister rr){
//        this.rr = rr;
//    }
    
 //   public Film recommendFilm(Person person){
   //     if(!rr.reviewers().contains(person)){
     //       Map<Film, List<Rating>> allFilmsAndRatings = rr.filmRatings();
       //     ArrayList<Film> filmList = new ArrayList<Film>(allFilmsAndRatings.keySet());
         //   Collections.sort(filmList, new FilmComparator(allFilmsAndRatings));
           // return filmList.get(0);
    //    }
      //  Set<Person> sP = getPeopleSimilarityRatings(person).keySet();
//        Map<Film, Rating> personalRatings = rr.getPersonalRatings(person);
  //      List<Person> similarPeople = new ArrayList(sP);
    //    Collections.sort(similarPeople, new PersonComparator(getPeopleSimilarityRatings(person)));
      //  for (Person i : similarPeople){
        //    Map<Film, Rating> otherRatings = rr.getPersonalRatings(i);
    //        for (Map.Entry<Film, Rating> m : otherRatings.entrySet()){
      //          int rate = m.getValue().getValue();
        //        if (!personalRatings.containsKey(m.getKey()) && rate > 1){
          //         return m.getKey();
            //    }
         //   }
    //    }
  //      return null;
  //  }
    
  //  private Map<Person, Integer> getPeopleSimilarityRatings(Person person){
  //      List<Person> reviewers = rr.reviewers();
//        Map<Film, Rating> personalRatings = rr.getPersonalRatings(person);
  //      Map<Person, Integer> similarPeople = new HashMap<Person, Integer>();
    //    for (Person i : reviewers){
      //      int similarity = 0;
        //    for(Film film : rr.getPersonalRatings(i).keySet()){
          //      if (personalRatings.containsKey(film)){
            //        similarity += personalRatings.get(film).getValue() * rr.getPersonalRatings(i).get(film).getValue();
              //  }
     //           if (similarity > 0){
       //             similarPeople.put(i, similarity);
         //       }
       //     }
     //   }
    //    return similarPeople;
  //  }
//}

/*
 * In this model solution, if from the primary (most suitable) person can't
 * be found suitable films, film recommendation continues by searching suitable
 * films from the second most suitable person. This wasn't required in the
 * assignment.
 */
package reference;
 
import java.util.*;
import reference.comparator.FilmComparator;
import reference.comparator.PersonComparator;
import reference.domain.Rating;
import reference.domain.Film;
import reference.domain.Person;
 
public class Reference {
 
    private RatingRegister register;
 
    public Reference(RatingRegister register) {
        this.register = register;
    }
 
    public Film recommendFilm(Person person) {
        if (this.register.getPersonalRatings(person).isEmpty()) {
            List<Film> movies = new ArrayList<Film>(register.filmRatings().keySet());
            Collections.sort(movies, new FilmComparator(register.filmRatings()));
            return movies.get(0);
        }
 
        List<Person> personsSortedBySuitability = personsSortBySuitability(person);
 
        return getSuitableFilm(person, personsSortedBySuitability);
    }
 
    private Film getSuitableFilm(Person forPerson, List<Person> personsSortedBySuitability) {
        Map<Film, Rating> personalRatings = this.register.getPersonalRatings(forPerson);
 
        for (Person person : personsSortedBySuitability) {
            if (person == forPerson) {
                continue;
            }
 
            Map<Film, Rating> suitableRatings = register.getPersonalRatings(person);
 
            for (Film film : suitableRatings.keySet()) {
                Rating rating = suitableRatings.get(film);
 
                if (personalRatings.containsKey(film)) {
                    continue;
                }
 
                if (rating.equals(Rating.GOOD) || rating.equals(Rating.FINE)) {
                    return film;
                }
            }
        }
 
        return null;
    }
 
    private List<Person> personsSortBySuitability(Person person) {
        Map<Film, Rating> filmRatings = register.getPersonalRatings(person);
        Map<Person, Integer> personSuitability = personSuitability(filmRatings);
 
        List<Person> people = new ArrayList<Person>(personSuitability.keySet());
        Collections.sort(people, new PersonComparator(personSuitability));
 
        return people;
    }
 
    private Map<Person, Integer> personSuitability(Map<Film, Rating> filmRatings) {
        Map<Person, Integer> personSuitability = new HashMap<Person, Integer>();
        for (Person reviewer : this.register.reviewers()) {
            int equality = 0;
 
            for (Film film : filmRatings.keySet()) {
                Rating personRating = filmRatings.get(film);
                Rating comparedRating = this.register.getRating(reviewer, film);
 
                equality += ratingsSuitability(personRating, comparedRating);
            }
 
            personSuitability.put(reviewer, equality);
        }
 
        return personSuitability;
    }
 
    private int ratingsSuitability(Rating personRating, Rating otherRating) {
        return personRating.getValue() * otherRating.getValue();
    }
}
