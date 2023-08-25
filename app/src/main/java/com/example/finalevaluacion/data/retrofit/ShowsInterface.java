package com.example.finalevaluacion.data.retrofit;

import com.example.finalevaluacion.data.response.ShowResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ShowsInterface {


    @GET("a38d4b0d-d067-47b9-aeb9-2a507bec1411  ")
    Call<ShowResponse> getShows();
}
