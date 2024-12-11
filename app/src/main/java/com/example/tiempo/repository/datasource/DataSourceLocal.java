package com.example.tiempo.repository.datasource;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Room;

import com.example.tiempo.models.EstadoDelTiempoView;
import com.example.tiempo.repository.room.AppDatabase;
import com.example.tiempo.repository.room.HistorialTiempo;
import com.example.tiempo.repository.room.HistorialTiempoDao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataSourceLocal {

    AppDatabase db;

    public DataSourceLocal(Application app){
        db = Room.databaseBuilder(app, AppDatabase.class, "database-name").allowMainThreadQueries().build();
    }


    public LiveData<List<HistorialTiempo>> getHIstorial(){
        return db.userDao().getAll();
    }

    public void guardarNuevoHistorial(EstadoDelTiempoView estadoDelTiempoView){
        HistorialTiempo tiempo = new HistorialTiempo();
        tiempo.ciudad = estadoDelTiempoView.ciudad;
        tiempo.descricion = estadoDelTiempoView.descricion;
        tiempo.temperatura = estadoDelTiempoView.temperatura;
        tiempo.humedad = estadoDelTiempoView.humedad;
        tiempo.velocidadViento = estadoDelTiempoView.velocidadViento;
        tiempo.fechaConsulta = new Date();

        db.userDao().insertAll(tiempo);
    }

}
