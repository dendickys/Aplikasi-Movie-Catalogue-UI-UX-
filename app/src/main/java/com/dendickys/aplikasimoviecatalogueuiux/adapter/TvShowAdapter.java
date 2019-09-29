package com.dendickys.aplikasimoviecatalogueuiux.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dendickys.aplikasimoviecatalogueuiux.R;
import com.dendickys.aplikasimoviecatalogueuiux.model.TvShow;

import java.util.ArrayList;

public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder> {

    private ArrayList<TvShow> listTvShow;
    private OnItemClickCallback onItemClickCallback;

    public TvShowAdapter(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public TvShowAdapter(ArrayList<TvShow> listTvShow) {
        this.listTvShow = listTvShow;
    }

    @NonNull
    @Override
    public TvShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tv_show, parent, false);
        return new TvShowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvShowViewHolder holder, int position) {
        TvShow movies = listTvShow.get(position);

        Glide.with(holder.itemView.getContext())
                .load(movies.getPoster())
                .apply(new RequestOptions()).override(100, 150)
                .into(holder.posterTvShow);
        holder.nameTvShow.setText(movies.getName());
        holder.yearTvShow.setText(movies.getYear());
        holder.genreTvShow.setText(movies.getGenre());
        holder.overviewTvShow.setText(movies.getDescription());
    }

    @Override
    public int getItemCount() {
        return listTvShow.size();
    }

    class TvShowViewHolder extends RecyclerView.ViewHolder {
        private ImageView posterTvShow;
        private TextView nameTvShow, yearTvShow, genreTvShow, overviewTvShow;

        TvShowViewHolder(@NonNull View itemView) {
            super(itemView);

            posterTvShow = itemView.findViewById(R.id.img_poster_tvshow);
            nameTvShow = itemView.findViewById(R.id.tv_name_tvshow);
            yearTvShow = itemView.findViewById(R.id.tv_year_tvshow);
            genreTvShow = itemView.findViewById(R.id.tv_genre_tvshow);
            overviewTvShow = itemView.findViewById(R.id.tv_overview_tvshow);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(TvShow data);
    }
}
