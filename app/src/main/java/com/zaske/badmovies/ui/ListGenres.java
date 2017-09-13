package com.zaske.badmovies.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.zaske.badmovies.R;
import com.zaske.badmovies.models.Genre;
import com.zaske.badmovies.services.TheMovieDBService;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ListGenres extends AppCompatActivity {
    public static final String TAG = ListGenres.class.getSimpleName();
    public ArrayList<Genre> mRestaurants = new ArrayList<>();

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
                try {
                    String jsonData = response.body().string();
                    Log.v(TAG, jsonData);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    } //end of getGenres
}
