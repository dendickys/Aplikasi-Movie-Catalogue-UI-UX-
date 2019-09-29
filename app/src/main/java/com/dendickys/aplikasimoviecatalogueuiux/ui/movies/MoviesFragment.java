package com.dendickys.aplikasimoviecatalogueuiux.ui.movies;


import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dendickys.aplikasimoviecatalogueuiux.R;
import com.dendickys.aplikasimoviecatalogueuiux.adapter.MoviesAdapter;
import com.dendickys.aplikasimoviecatalogueuiux.model.Movies;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment {

    private String[] dataName, dataYear, dataGenre, dataOverview;
    private TypedArray dataPoster;
    private ArrayList<Movies> moviesArrayList;

    public MoviesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView rvMovies = view.findViewById(R.id.rv_movies);
        rvMovies.setHasFixedSize(true);
        prepare();
        addItem();
        rvMovies.setLayoutManager(new LinearLayoutManager(getContext()));
        MoviesAdapter moviesAdapter = new MoviesAdapter(moviesArrayList);
        rvMovies.setAdapter(moviesAdapter);
    }

    private void prepare() {
        dataName = getResources().getStringArray(R.array.data_name_movies);
        dataYear = getResources().getStringArray(R.array.data_year_movies);
        dataGenre = getResources().getStringArray(R.array.data_genre_movies);
        dataOverview = getResources().getStringArray(R.array.data_overview_movies);
        dataPoster = getResources().obtainTypedArray(R.array.data_poster_movies);
    }

    private void addItem() {
        moviesArrayList = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Movies movies = new Movies();
            movies.setName(dataName[i]);
            movies.setYear(dataYear[i]);
            movies.setGenre(dataGenre[i]);
            movies.setDescription(dataOverview[i]);
            movies.setPoster(dataPoster.getResourceId(i, -1));
            moviesArrayList.add(movies);
        }
    }
}
