package com.zaske.badmovies.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.zaske.badmovies.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.searchByGenreButton) Button msearchByGenreButton;


    @OnClick(R.id.searchByGenreButton) void onButtonPress() {
        Intent showListOfGenres = new Intent(MainActivity.this, ListGenres.class);
        startActivity(showListOfGenres);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Binding to our layout objects
        ButterKnife.bind(this);
    }
}
