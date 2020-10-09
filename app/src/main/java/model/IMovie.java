package model;

import java.util.ArrayList;
import java.util.List;

public interface IMovie {

    public ArrayList<Movie> getMoviesOnTitle(String title);
    public ArrayList<String> getGenre();
    public ArrayList<Movie> getMoviesOnGenre(String genre);
    public ArrayList<Movie> getMoviesOnYear(int year);
}
