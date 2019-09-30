package com.dendickys.aplikasimoviecatalogueuiux;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.dendickys.aplikasimoviecatalogueuiux.model.Movies;

public class DetailMoviesActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movies);

        Movies movies = getIntent().getParcelableExtra(EXTRA_MOVIE);

        if (getSupportActionBar() != null) {
            assert movies != null;
            getSupportActionBar().setTitle(movies.getName());
        }

        ImageView imgPoster = findViewById(R.id.img_poster_movies);
        TextView tvYear = findViewById(R.id.tv_year_movies);
        TextView tvGenre = findViewById(R.id.tv_genre_movies);
        TextView tvOverview = findViewById(R.id.tv_overview_movies);

        assert movies != null;
        imgPoster.setImageResource(movies.getPoster());
        tvYear.setText(movies.getYear());
        tvGenre.setText(movies.getGenre());
        tvOverview.setText(movies.getDescription());
    }
}
