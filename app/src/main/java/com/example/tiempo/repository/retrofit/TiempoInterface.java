package com.example.tiempo.repository.retrofit;

import com.example.tiempo.repository.modelretrofit.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TiempoInterface {
    @GET("data/2.5/weather")
    Call<WeatherResponse> listRepos(@Query("q") String ciudad, @Query("appid") String token);


}