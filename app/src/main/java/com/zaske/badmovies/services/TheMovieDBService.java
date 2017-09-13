package com.zaske.badmovies.services;

import com.zaske.badmovies.Constants;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Guest on 9/13/17.
 */

public class TheMovieDBService {
    public static void getGenres(Callback callback){
        OkHttpClient client = new OkHttpClient();

        //construct the URL
        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.THEMOVIEDB_BASE_URL + Constants.THEMOVIEDB_GENRE_API).newBuilder();
        urlBuilder.addQueryParameter("api_key", Constants.THEMOVIEDB_API_KEY);
        String url = urlBuilder.build().toString();

        //Build the request
        Request request= new Request.Builder()
                .url(url)
                .build();

        //make the call asynchronously
        Call call = client.newCall(request);
        call.enqueue(callback);
    }
}
