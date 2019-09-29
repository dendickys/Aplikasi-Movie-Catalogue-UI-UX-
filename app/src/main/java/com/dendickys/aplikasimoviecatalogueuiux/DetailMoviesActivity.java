package com.dendickys.aplikasimoviecatalogueuiux;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.dendickys.aplikasimoviecatalogueuiux.model.Movies;

public class DetailMoviesActivity extends AppCompatActivity {

    ImageView imgPoster;
    TextView tvName, tvYear, tvGenre, tvOverview;
    public static final String EXTRA_MOVIE = "extra_movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movies);

        Movies movies = getIntent().getParcelableExtra(EXTRA_MOVIE);

        if (getSupportActionBar() != null ) {
            assert movies != null;
            getSupportActionBar().setTitle(movies.getName());
        }

        imgPoster = findViewById(R.id.img_poster_movies);
        tvYear = findViewById(R.id.tv_year_movies);
        tvGenre = findViewById(R.id.tv_genre_movies);
        tvOverview = findViewById(R.id.tv_overview_movies);

        assert movies != null;
        imgPoster.setImageResource(movies.getPoster());
        tvYear.setText(movies.getYear());
        tvGenre.setText(movies.getGenre());
        tvOverview.setText(movies.getDescription());
    }
}
