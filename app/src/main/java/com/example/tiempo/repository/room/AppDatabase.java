package com.example.tiempo.repository.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {HistorialTiempo.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class AppDatabase  extends RoomDatabase {
    public abstract HistorialTiempoDao userDao();

}
