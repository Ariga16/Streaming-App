package com.dacasa.streamingapp;

import java.util.ArrayList;
import java.util.List;

public class DataSource {
    public static List<Movie> getPopularMovies() {

        List<Movie> lstMovies = new ArrayList<>();
        lstMovies.add(new Movie("me \nbefore you",R.drawable.cover_eleven,R.drawable.bat));
        lstMovies.add(new Movie("Mrs. Serial\n Killer",R.drawable.cover_ten,R.drawable.bat));
        lstMovies.add(new Movie("Avatar",R.drawable.cover6));
        lstMovies.add(new Movie("Guardians \n Galaxy",R.drawable.cover1));
        lstMovies.add(new Movie("Orphan",R.drawable.cover2));
        lstMovies.add(new Movie("Fright Night",R.drawable.cover9));

        return lstMovies;
    }

    public static List<Movie> getWeekMovies() {

        List<Movie> lstMovies = new ArrayList<>();
        lstMovies.add(new Movie("FoodLoose",R.drawable.cover5,R.drawable.bat));
        lstMovies.add(new Movie("STAR\nWARS",R.drawable.cover3,R.drawable.bat));
        lstMovies.add(new Movie("GUARDIANS\n GALAXY",R.drawable.cover1));
        lstMovies.add(new Movie("Foodloose",R.drawable.cover5));
        lstMovies.add(new Movie("AVATAR",R.drawable.cover6));
        lstMovies.add(new Movie("OPPOSITES",R.drawable.cover7));


    return lstMovies;
    }

}
