package com.zaske.badmovies.services;

import com.zaske.badmovies.Constants;
import com.zaske.badmovies.models.Genre;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

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

    public ArrayList<Genre> processGenreResults(Response response){
        ArrayList<Genre> genres = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if(response.isSuccessful()){
                JSONObject tmdbJSON = new JSONObject(jsonData);
                JSONArray genresJSON = tmdbJSON.getJSONArray("genres");
                for(int i = 0; i < genresJSON.length(); i++){
                    JSONObject thisGenre = genresJSON.getJSONObject(i);
                    String name = thisGenre.getString("name");
                    int id = thisGenre.getInt("id");
                    Genre tempGenre = new Genre(name,id);
                    genres.add(tempGenre);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return genres;
    } //end of processGenreResults
}
