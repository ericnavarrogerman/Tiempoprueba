package com.example.tiempo.repository.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface  HistorialTiempoDao {

    @Query("SELECT * FROM tiempo order by id DESC")
    LiveData<List<HistorialTiempo>> getAll();

    @Insert
    void insertAll(HistorialTiempo... users);

}