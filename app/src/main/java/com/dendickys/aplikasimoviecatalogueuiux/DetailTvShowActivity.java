package com.dendickys.aplikasimoviecatalogueuiux;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.dendickys.aplikasimoviecatalogueuiux.model.TvShow;

public class DetailTvShowActivity extends AppCompatActivity {

    public static final String EXTRA_TVSHOW = "extra_tvshow";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv_show);

        TvShow tvShow = getIntent().getParcelableExtra(EXTRA_TVSHOW);

        if (getSupportActionBar() != null) {
            assert tvShow != null;
            getSupportActionBar().setTitle(tvShow.getName());
        }

        ImageView imgPoster = findViewById(R.id.img_poster_tvshow);
        TextView tvYear = findViewById(R.id.tv_year_tvshow);
        TextView tvGenre = findViewById(R.id.tv_genre_tvshow);
        TextView tvOverview = findViewById(R.id.tv_overview_tvshow);

        assert tvShow != null;
        imgPoster.setImageResource(tvShow.getPoster());
        tvYear.setText(tvShow.getYear());
        tvGenre.setText(tvShow.getGenre());
        tvOverview.setText(tvShow.getDescription());
    }
}
