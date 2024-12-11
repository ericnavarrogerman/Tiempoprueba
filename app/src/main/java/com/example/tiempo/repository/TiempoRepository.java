package com.example.tiempo.repository;

import android.app.Application;
import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tiempo.models.EstadoDelTiempoView;
import com.example.tiempo.repository.datasource.DataSourceLocal;
import com.example.tiempo.repository.datasource.DataSourceRemote;
import com.example.tiempo.repository.modelretrofit.WeatherResponse;
import com.example.tiempo.repository.room.HistorialTiempo;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TiempoRepository {

    DataSourceRemote dataSourceRemote;
    DataSourceLocal  dataSourceLocal;
    Executor executor;


    public TiempoRepository(Application application){
        dataSourceRemote = new DataSourceRemote();
        dataSourceLocal = new DataSourceLocal(application);
        executor = Executors.newSingleThreadExecutor();

    }

    public void realizarNuevaConsulta(String cityName){
        executor.execute(() -> {
            dataSourceRemote.getInfoCiudad(cityName).enqueue(new Callback<WeatherResponse>() {
                @Override
                public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {

                    WeatherResponse resposeBody = response.body();
                    EstadoDelTiempoView tiempoView = new EstadoDelTiempoView(
                            resposeBody.getName(),
                            resposeBody.getWeather()[0].getDescription(),
                            resposeBody.getMain().getTemp(),
                            resposeBody.getMain().getHumidity(),
                            resposeBody.getWind().getSpeed()
                    );
                    dataSourceLocal.guardarNuevoHistorial(tiempoView);
                }

                @Override
                public void onFailure(Call<WeatherResponse> call, Throwable throwable) {

                }
            });
        });
    }

    public LiveData<List<HistorialTiempo>> getHistorial() {
        MediatorLiveData<List<HistorialTiempo>> result = new MediatorLiveData<>();

        executor.execute(() -> {
            LiveData<List<HistorialTiempo>> dbSource = dataSourceLocal.getHIstorial();
            result.addSource(dbSource, data -> result.postValue(data));
        });

        return result;
    }

}
