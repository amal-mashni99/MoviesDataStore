package com.cs.firstass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import model.IMovie;
import model.Movie;
import model.MovieFactory;

public class MainActivity extends AppCompatActivity {
private Spinner spinner;
    private Spinner Yearsspinner;
private  EditText editText;
private EditText titleSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner= findViewById(R.id.genre);
        editText= findViewById(R.id.output);
        Yearsspinner=findViewById(R.id.year);
        titleSearch=findViewById(R.id.title);
        populateGenreSpinner();
        populateYearSpinner();
    }
    private void populateGenreSpinner() {
        MovieFactory factory = new MovieFactory();
        IMovie objBook = factory.getModel();

        ArrayList<String> cats = objBook.getGenre();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, cats);

        spinner.setAdapter(adapter);

    }
    private void populateYearSpinner() {

        ArrayList<String> year = new ArrayList<>();
        year.add(0,"Select Year");
        for (int x=2021;x>1990;x--)
        {
           year.add(String.valueOf(x));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, year);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Yearsspinner.setAdapter(adapter);
    }
          private int getYear ()
          {int year;
              String item = Yearsspinner.getSelectedItem().toString();
              if (item.equals("Select Year"))
                  return 0;
              return year = Integer.parseInt(item);
          }

          private String getGenre()
          {
          if (spinner.getSelectedItem().equals("Select Genre"))
              return "";
              return spinner.getSelectedItem().toString();
          }

    public void btnGetMoviesOnClick(View view) {
        MovieFactory factory = new MovieFactory();
        IMovie objMovie = factory.getModel();

        ArrayList<Movie> firstList =new ArrayList<>();
        ArrayList<Movie> secList = new ArrayList<>();

        String title = titleSearch.getText().toString();

        int year = getYear ();
        String genre = getGenre();

       if (!title.equals("")) {

            firstList = objMovie.getMoviesOnTitle(title);
            if(year!=0){
                for (Movie m : firstList) {
                    if (m.getYear()==year)
                        secList.add(m);
                }
                firstList=secList;
                secList.clear();
            }
           if(!genre.equals("")){
               for (Movie m :firstList)
               {
                   if (m.getGenre().equals(genre))
                       secList.add(m);
               }
               firstList=secList;

           }

        }
        else if(year!=0)
        {
            firstList=objMovie.getMoviesOnYear(year);
            if(!genre.equals("")){
                for (Movie m :firstList)
                {
                    if (m.getGenre().equals(genre))
                        secList.add(m);
                }
                firstList=secList;

            }
          }

else if (!genre.equals(""))
       {
           firstList=objMovie.getMoviesOnGenre(genre);

       }

if (firstList.size()==0)
    editText.setText("no data");
else {
    String str = "";
    for (Movie b : firstList) {
        str += b.getTitle() + "\n";
    }
    editText.setText(str);
}
    }


}