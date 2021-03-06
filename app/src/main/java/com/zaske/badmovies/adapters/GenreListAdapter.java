package com.zaske.badmovies.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zaske.badmovies.R;
import com.zaske.badmovies.models.Genre;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Guest on 9/14/17.
 */

public class GenreListAdapter extends RecyclerView.Adapter<GenreListAdapter.GenreViewHolder> {
    private ArrayList<Genre> mGenres = new ArrayList<>();
    private Context mContext;

    public GenreListAdapter(Context context, ArrayList<Genre> genres) {
        mContext = context;
        mGenres = genres;
    }

    @Override
    public GenreListAdapter.GenreViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.genre_list_item, parent, false);
        GenreViewHolder viewHolder = new GenreViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(GenreListAdapter.GenreViewHolder holder, int position) {
        holder.bindGenre(mGenres.get(position));
    }

    @Override
    public int getItemCount() {
        return mGenres.size();
    }

    public class GenreViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.nameTextView)
        TextView mNameTextView;
        private Context mContext;

        public GenreViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            mContext = itemView.getContext();
        }

        public void bindGenre(Genre genre){
            mNameTextView.setText(genre.getName());
        }
    } //end of GenreViewHolder

} //END OF Class


