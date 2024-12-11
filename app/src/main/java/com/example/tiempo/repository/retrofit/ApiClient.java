package com.example.tiempo.repository.retrofit;

import com.example.tiempo.viewmodels.TiempoViewModel;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static TiempoInterface getRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TiempoInterface service = retrofit.create(TiempoInterface.class);
        return service;
    }

}
