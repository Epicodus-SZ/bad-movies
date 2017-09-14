package com.zaske.badmovies.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.zaske.badmovies.R;
import com.zaske.badmovies.adapters.GenreListAdapter;
import com.zaske.badmovies.adapters.HatedStuffListAdapter;
import com.zaske.badmovies.models.Genre;
import com.zaske.badmovies.models.Hated_Stuff;
import com.zaske.badmovies.services.STZDataService;
import com.zaske.badmovies.services.TheMovieDBService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ListGenres extends AppCompatActivity {
    public static final String TAG = ListGenres.class.getSimpleName();
    public ArrayList<Genre> mGenres = new ArrayList<>();

    //Hated test
    public ArrayList<Hated_Stuff> mHated = new ArrayList<>();

    //@BindView(R.id.genreRecyclerView) RecyclerView mGenreRecyclerView;
    @BindView(R.id.genreRecyclerView) RecyclerView mHatedRecyclerView;

    // private GenreListAdapter mAdapter;
    private HatedStuffListAdapter hateAdapter;
    //private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_genres);

        ButterKnife.bind(this);

//        Genre test1 = new Genre("Action", 1);
//        Genre test2 = new Genre("Comedy", 2);
//        mGenres.add(test1);
//        mGenres.add(test2);

        // getGenres();
        getHatedStuff();


        //mListView = (ListView) findViewById(R.id.listView);
//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mGenres);
//        mGenreListView.setAdapter(adapter);

    }

    private void getHatedStuff(){
        final STZDataService stzService = new STZDataService();
        stzService.getHatedStuff(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                mHated = stzService.processHatedStuffResults(response);

                ListGenres.this.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        hateAdapter = new HatedStuffListAdapter(getApplicationContext(),mHated);
                        mHatedRecyclerView.setAdapter(hateAdapter);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ListGenres.this);
                        mHatedRecyclerView.setLayoutManager(layoutManager);
                        mHatedRecyclerView.setHasFixedSize(true);
                    }
                });  //end of runnable

            }
        });
    } //end of getGenres

//    private void getGenres(){
//        final TheMovieDBService tmdbService = new TheMovieDBService();
//        tmdbService.getGenres(new Callback() {
//
//            @Override
//            public void onFailure(Call call, IOException e) {
//                e.printStackTrace();
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) {
//                mGenres = tmdbService.processGenreResults(response);
//
//                ListGenres.this.runOnUiThread(new Runnable() {
//
//                    @Override
//                    public void run() {
//                        mAdapter = new GenreListAdapter(getApplicationContext(),mGenres);
//                        mGenreRecyclerView.setAdapter(mAdapter);
//                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ListGenres.this);
//                        mGenreRecyclerView.setLayoutManager(layoutManager);
//                        mGenreRecyclerView.setHasFixedSize(true);
//                    }
//                });  //end of runnable
//
//            }
//        });
//    } //end of getGenres
}
