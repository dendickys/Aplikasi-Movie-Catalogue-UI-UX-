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
import com.dendickys.aplikasimoviecatalogueuiux.model.Movies;

import java.util.ArrayList;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder> {

    private ArrayList<Movies> listMovies;
    private OnItemClickCallback onItemClickCallback;

    public MoviesAdapter(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public MoviesAdapter(ArrayList<Movies> listMovies) {
        this.listMovies = listMovies;
    }

    @NonNull
    @Override
    public MoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movies, parent, false);
        return new MoviesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesViewHolder holder, int position) {
        Movies movies = listMovies.get(position);

        Glide.with(holder.itemView.getContext())
                .load(movies.getPoster())
                .apply(new RequestOptions()).override(100, 150)
                .into(holder.posterMovies);
        holder.nameMovies.setText(movies.getName());
        holder.yearMovies.setText(movies.getYear());
        holder.genreMovies.setText(movies.getGenre());
        holder.overviewMovies.setText(movies.getDescription());
    }

    @Override
    public int getItemCount() {
        return listMovies.size();
    }

    class MoviesViewHolder extends RecyclerView.ViewHolder {
        private ImageView posterMovies;
        private TextView nameMovies, yearMovies, genreMovies, overviewMovies;

        MoviesViewHolder(@NonNull View itemView) {
            super(itemView);

            posterMovies = itemView.findViewById(R.id.img_poster_movies);
            nameMovies = itemView.findViewById(R.id.tv_name_movies);
            yearMovies = itemView.findViewById(R.id.tv_year_movies);
            genreMovies = itemView.findViewById(R.id.tv_genre_movies);
            overviewMovies = itemView.findViewById(R.id.tv_overview_movies);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Movies data);
    }
}
