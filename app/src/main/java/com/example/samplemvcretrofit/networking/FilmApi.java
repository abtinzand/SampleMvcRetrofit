package com.example.samplemvcretrofit.networking;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FilmApi {
    //https://newsapi.org/v2/top-headlines?country=us&apiKey=fd82eb92bcc0478b96fbb82c1ca76819
    //@GET("/top-headlines?country=us&apiKey=fd82eb92bcc0478b96fbb82c1ca76819")
    @GET("/api/v1/movies")
    Call<JSONResponse> getTops(@Query("page") int page);
}
