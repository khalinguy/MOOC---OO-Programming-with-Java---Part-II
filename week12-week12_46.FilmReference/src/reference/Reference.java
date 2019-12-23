/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import reference.comparator.FilmComparator;
import reference.comparator.PersonComparator;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

/**
 *
 * @author Linh Nguyen
 */
public class Reference {

    private RatingRegister ratingregister;

    public Reference(RatingRegister register) {
        this.ratingregister = register;
    }

    public Film recommendFilm(Person person) {
        //if person have not seen films, recommend top rated one

        if (this.ratingregister.getPersonalRatings(person).isEmpty()) {
            List<Film> films = new ArrayList<Film>(this.ratingregister.filmRatings().keySet());
            Collections.sort(films, new FilmComparator(this.ratingregister.filmRatings()));
            return films.get(0);
        }
        // For person which rated films
        // Conclude a list of people with the same reviews
        List<Person> reviewersSortedBySimilarity = reviewersSortBySimilarity(person);

        //  return positively reviewed unseen film from descending similarity 
        //  ordered list of positively similar reviewers
        return getRecommendedFilm(person, reviewersSortedBySimilarity);
    }

    private List<Person> reviewersSortBySimilarity(Person person) {
        //  get positively similar reviewers
        Map<Person, Integer> reviewerSimilarity = reviewerSimilarity(this.ratingregister.getPersonalRatings(person));

        //  sort in descending order of similarity list of positively
        //  similar reviewers
        List<Person> similarReviewers = new ArrayList<Person>(reviewerSimilarity.keySet());
        Collections.sort(similarReviewers, new PersonComparator(reviewerSimilarity));

        //  return sorted list of positively similar reviewers 
        return similarReviewers;
    }

    private Map<Person, Integer> reviewerSimilarity(Map<Film, Rating> filmRatings) {
        Map<Person, Integer> reviewerSimilarity = new HashMap<Person, Integer>();

        //  try to find positively similar reviewers to the viewer
        for (Person reviewer : this.ratingregister.reviewers()) {
            int similarity = 0;

            for (Film film : filmRatings.keySet()) {
                // similarity for each film = reviewer's rating * viewer's rating                
                similarity += filmRatings.get(film).getValue() * this.ratingregister.getRating(reviewer, film).getValue();
            }

            //  only include positively similar reviewers
            if (similarity > 0) {
                reviewerSimilarity.put(reviewer, similarity);
            }
        }

        //  return list of positively similar reviewers
        return reviewerSimilarity;
    }

    private Film getRecommendedFilm(Person viewer, List<Person> reviewersSortedBySimilarity) {
        Map<Film, Rating> viewersSeenFilms = this.ratingregister.getPersonalRatings(viewer);

        //  from a list of positively similar reviewers sorted in descending 
        //  order of similarity, try to find any positively reviewed film unseen 
        //  by the viewer in a list of films positively reviewed
        for (Person reviewer : reviewersSortedBySimilarity) {
            //  if recommending a film to the viewer, the viewer is not a 'reviewer'
            if (reviewer == viewer) {
                continue;
            }

            //  recommend positive film not seen by the viewer
            for (Film film : this.ratingregister.getPersonalRatings(reviewer).keySet()) {
                //  do not recommend films already seen by the viewer
                if (viewersSeenFilms.containsKey(film)) {
                    continue;
                }

                //  recommend positively reviewed film
                if (this.ratingregister.getPersonalRatings(reviewer).get(film).getValue() > 1) {
                    return film;
                }
            }
        }

        //  no positively reviewed film by a similar reviewer that has not been
        //  seen by the viewer exists
        return null;
    }
}
