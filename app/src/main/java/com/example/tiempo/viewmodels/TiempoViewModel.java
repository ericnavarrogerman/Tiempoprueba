package com.example.tiempo.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.tiempo.models.EstadoDelTiempoView;
import com.example.tiempo.repository.TiempoRepository;
import com.example.tiempo.repository.room.HistorialTiempo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public class TiempoViewModel extends AndroidViewModel {

    TiempoRepository  repository;


    public TiempoViewModel(@NonNull Application application) {
        super(application);
        repository = new TiempoRepository(getApplication());
    }

    public LiveData<List<HistorialTiempo>> getHistorial(){
        return repository.getHistorial();

    }

    public void realizarNuevaConsulta(String cityName){
        repository.realizarNuevaConsulta(cityName);
    }



}
