package com.dendickys.aplikasimoviecatalogueuiux;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.dendickys.aplikasimoviecatalogueuiux.model.TvShow;

public class DetailTvShowActivity extends AppCompatActivity {

    ImageView imgPoster;
    TextView tvName, tvYear, tvGenre, tvOverview;
    public static final String EXTRA_TVSHOW = "extra_tvshow";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv_show);

        TvShow tvShow = getIntent().getParcelableExtra(EXTRA_TVSHOW);

        if (getSupportActionBar() != null ) {
            assert tvShow != null;
            getSupportActionBar().setTitle(tvShow.getName());
        }

        imgPoster = findViewById(R.id.img_poster_tvshow);
        tvYear = findViewById(R.id.tv_year_tvshow);
        tvGenre = findViewById(R.id.tv_genre_tvshow);
        tvOverview = findViewById(R.id.tv_overview_tvshow);

        assert tvShow != null;
        imgPoster.setImageResource(tvShow.getPoster());
        tvYear.setText(tvShow.getYear());
        tvGenre.setText(tvShow.getGenre());
        tvOverview.setText(tvShow.getDescription());
    }
}
