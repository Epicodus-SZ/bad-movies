package com.zaske.badmovies.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.zaske.badmovies.R;
import com.zaske.badmovies.models.Genre;
import com.zaske.badmovies.services.TheMovieDBService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ListGenres extends AppCompatActivity {
    public static final String TAG = ListGenres.class.getSimpleName();
    public ArrayList<Genre> mGenres = new ArrayList<>();

    private ListView mGenreListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_genres);

        getGenres();
    }

    private void getGenres(){
        final TheMovieDBService tmdbService = new TheMovieDBService();
        tmdbService.getGenres(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final TheMovieDBService tmdbService = new TheMovieDBService();
                mGenres = tmdbService.get .(response);

                RestaurantsActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter = new RestaurantListAdapter(getApplicationContext(), mRestaurants);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager =
                                new LinearLayoutManager(RestaurantsActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                    }
                });
            }
        });
    } //end of getGenres
}
