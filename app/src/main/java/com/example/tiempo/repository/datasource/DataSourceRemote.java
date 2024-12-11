package com.example.tiempo.repository.datasource;

import com.example.tiempo.repository.modelretrofit.WeatherResponse;
import com.example.tiempo.repository.retrofit.ApiClient;

import retrofit2.Call;

public class DataSourceRemote {

    public DataSourceRemote(){

    }

    public Call<WeatherResponse> getInfoCiudad(String cityName){
       return ApiClient.getRetrofit().listRepos(cityName,"a63c271e11d5c55066ac922fea3c903c");
    }

}
