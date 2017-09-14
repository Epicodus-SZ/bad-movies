package com.zaske.badmovies.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zaske.badmovies.R;
import com.zaske.badmovies.models.Genre;
import com.zaske.badmovies.models.Hated_Stuff;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Guest on 9/14/17.
 */

public class HatedStuffListAdapter extends RecyclerView.Adapter<HatedStuffListAdapter.HatedViewHolder> {
    private ArrayList<Hated_Stuff> mHateds = new ArrayList<>();
    private Context mContext;

    public HatedStuffListAdapter(Context context, ArrayList<Hated_Stuff> hateds) {
        mContext = context;
        mHateds = hateds;
    }

    @Override
    public HatedStuffListAdapter.HatedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hated_list_item, parent, false);
        HatedViewHolder viewHolder = new HatedViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HatedStuffListAdapter.HatedViewHolder holder, int position) {
        holder.bindHated(mHateds.get(position));
    }

    @Override
    public int getItemCount() {
        return mHateds.size();
    }

    public class HatedViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.nameTextView) TextView mNameTextView;
        @BindView(R.id.hatedImageView) ImageView mHatedImageView;
        private Context mContext;

        public HatedViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            mContext = itemView.getContext();
        }

        public void bindHated(Hated_Stuff hated){
            mNameTextView.setText(hated.getName());
            Picasso.with(mContext).load(hated.getImgUrl()).into(mHatedImageView);
        }
    } //end of HatedViewHolder

} //END OF Class


