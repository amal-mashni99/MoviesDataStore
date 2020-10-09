package model;

import java.util.ArrayList;
import java.util.List;

class MovieData implements IMovie {
    private ArrayList<Movie> movies = new ArrayList<>();

    public MovieData()
    {
        movies.add(new Movie("Mulan",2020,"Action"));
        movies.add(new Movie("The War with Grandpa",2020,"Comedy"));
        movies.add(new Movie("Little Women",2019,"Romance"));
        movies.add(new Movie("The Irishman",2019,"Crime"));
        movies.add(new Movie("Avengers: Endgame",2019,"Action"));

        movies.add(new Movie("Baby Driver",2017,"Action"));
        movies.add(new Movie("The Shape of Water",2017,"Horror"));
        movies.add(new Movie("The Wolf of Wall Street",2013,"Drama"));
        movies.add(new Movie("The Wolf of Wall Street",2016,"Comedy"));



    }
    @Override
     public ArrayList<Movie> getMoviesOnTitle(String title){

         ArrayList<Movie> data = new ArrayList<>();
         for(Movie m : movies){
             if(m.getTitle().contains(title)){
                 data.add(m);
             }
         }
         return data;
     }
    @Override
    public ArrayList<Movie> getMoviesOnGenre(String genre){

        ArrayList<Movie> data = new ArrayList<>();
        for(Movie m : movies){
            if(m.getGenre().equals(genre)){
                data.add(m);
            }
        }
        return data;
    }
    @Override
    public ArrayList<Movie> getMoviesOnYear(int year){

        ArrayList<Movie> data = new ArrayList<>();
        for(Movie m : movies){
            if(m.getYear()==year){
                data.add(m);
            }
        }
        return data;
    }
     @Override
     public ArrayList<String> getGenre() {
         ArrayList<String> genre = new ArrayList<>();
         genre.add(0,"Select Genre");
for(int i=1;i<movies.size();i++)
{
    if(!genre.contains(movies.get(i).getGenre()))
        genre.add(movies.get(i).getGenre());
}
         return genre;
     }

}
