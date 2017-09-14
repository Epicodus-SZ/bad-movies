package com.zaske.badmovies.services;

import com.zaske.badmovies.Constants;
import com.zaske.badmovies.models.Genre;
import com.zaske.badmovies.models.Hated_Stuff;

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

public class STZDataService {
    public static void getHatedStuff(Callback callback){
        String STZDATASERVICE_BASE_URL = "https://api-test-c0f4f.firebaseio.com/.json";

        OkHttpClient client = new OkHttpClient();


        //Build the request
        Request request= new Request.Builder()
                .url(STZDATASERVICE_BASE_URL)
                .build();

        //make the call asynchronously
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Hated_Stuff> processHatedStuffResults(Response response){
        ArrayList<Hated_Stuff> hated = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if(response.isSuccessful()){
                JSONObject tmdbJSON = new JSONObject(jsonData);
                JSONArray hatedsJSON = tmdbJSON.getJSONArray("hated_stuff");
                for(int i = 0; i < hatedsJSON.length(); i++){
                    JSONObject thisHated = hatedsJSON.getJSONObject(i);
                    String name = thisHated.getString("name");
                    String imgUrl = thisHated.getString("img_url");
                    String reason = thisHated.getString("reason");
                    int id = thisHated.getInt("id");
                    int hateLevel = thisHated.getInt("hate_level");
                    // (int id, String name, String reason, String imgUrl, int hateLevel )
                    Hated_Stuff tempHated = new Hated_Stuff(id, name, reason, imgUrl, hateLevel);
                    hated.add(tempHated);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return hated;
    } //end of processGenreResults
}
