/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
/**
 *
 * @author Linh Nguyen
 */
public class RatingRegister {
    private Map<Film, List<Rating>> ratingReg;
    private Map<Person, Map<Film, Rating>> reviewerRat;
    
    public RatingRegister(){
        ratingReg = new HashMap<Film, List<Rating>>();
        reviewerRat = new HashMap<Person, Map<Film, Rating>>();
    }
    
    public void addRating(Film film, Rating rating){
        if (!ratingReg.containsKey(film)){
            ratingReg.put(film, new ArrayList<Rating>());
        }
        
        ratingReg.get(film).add(rating);
    }
    
    public void addRating (Person person, Film film, Rating rating){
        if (!reviewerRat.containsKey(person)){
            reviewerRat.put(person, new HashMap<Film, Rating>());
            reviewerRat.get(person).put(film, rating);
            addRating(film, rating);
        } else if (!reviewerRat.get(person).containsKey(film)){
            reviewerRat.get(person).put(film, rating);
            addRating(film, rating);
        }
    }
    public Map<Film, List<Rating>> filmRatings(){
        return ratingReg;
    }
    
    public List<Rating> getRatings (Film film){
        List<Rating> filmrat = new ArrayList<Rating>();
        if (ratingReg.containsKey(film)){
            filmrat = ratingReg.get(film);
            
        }
        
        return filmrat;
    }
    
    public Rating getRating (Person person, Film film){
        if (!reviewerRat.containsKey(person)){
            return Rating.NOT_WATCHED;
        } else if (!reviewerRat.get(person).containsKey(film)){
            return Rating.NOT_WATCHED;
        }
        return reviewerRat.get(person).get(film);
    }
    
    public Map<Film, Rating> getPersonalRatings (Person person){
        if (reviewerRat.containsKey(person)){
            return reviewerRat.get(person);
        }
        return new HashMap();
    }
    
    public List<Person> reviewers(){
        List<Person> reviewers = new ArrayList<Person>();
        for (Person p: reviewerRat.keySet()){
            reviewers.add(p);
        }
        
        return reviewers;
    }
}
