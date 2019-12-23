/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.comparator;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import reference.domain.Film;
import reference.domain.Rating;

/**
 *
 * @author Linh Nguyen
 */
public class FilmComparator implements Comparator<Film> {
    private Map<Film, List<Rating>> filmratings;
    
    public FilmComparator (Map<Film, List<Rating>> ratings){
        this.filmratings = ratings;
    }
    
    @Override
    public int compare(Film film1, Film film2){
        double o1 = 0;
        double o2 = 0;
        
        for (Rating rating: this.filmratings.get(film1)){
            o1 += rating.getValue();
        }
        
        
        for (Rating rating: this.filmratings.get(film2)){
            o2 += rating.getValue();
        }
    
        
        if (o1 == o2){
            return 0;
        } else if (o1 > o2){
            return -1;
        } else {
            return 1;
        }
        
        
    }
}
