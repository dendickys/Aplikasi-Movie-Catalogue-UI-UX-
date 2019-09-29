package com.dendickys.aplikasimoviecatalogueuiux.ui.tvshow;


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
import com.dendickys.aplikasimoviecatalogueuiux.adapter.TvShowAdapter;
import com.dendickys.aplikasimoviecatalogueuiux.model.TvShow;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TvShowFragment extends Fragment {

    private String[] dataName, dataYear, dataGenre, dataOverview;
    private TypedArray dataPoster;
    private ArrayList<TvShow> tvShowArrayList;

    public TvShowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView rvTvShow = view.findViewById(R.id.rv_tvshow);
        rvTvShow.setHasFixedSize(true);
        prepare();
        addItem();
        rvTvShow.setLayoutManager(new LinearLayoutManager(getContext()));
        TvShowAdapter tvShowAdapter = new TvShowAdapter(tvShowArrayList);
        rvTvShow.setAdapter(tvShowAdapter);
    }

    private void prepare() {
        dataName = getResources().getStringArray(R.array.data_name_tvshow);
        dataYear = getResources().getStringArray(R.array.data_year_tvshow);
        dataGenre = getResources().getStringArray(R.array.data_genre_tvshow);
        dataOverview = getResources().getStringArray(R.array.data_overview_tvshow);
        dataPoster = getResources().obtainTypedArray(R.array.data_poster_tv_show);
    }

    private void addItem() {
        tvShowArrayList = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            TvShow movies = new TvShow();
            movies.setName(dataName[i]);
            movies.setYear(dataYear[i]);
            movies.setGenre(dataGenre[i]);
            movies.setDescription(dataOverview[i]);
            movies.setPoster(dataPoster.getResourceId(i, -1));
            tvShowArrayList.add(movies);
        }
    }
}
