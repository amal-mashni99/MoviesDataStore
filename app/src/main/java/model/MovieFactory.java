package model;

public class MovieFactory {
    public IMovie getModel(){

        return new MovieData();
    }
}
