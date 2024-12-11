package com.example.tiempo.repository.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;

import java.util.Date;

@Entity(tableName = "tiempo")
public class HistorialTiempo {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "ciudad")
    public String ciudad;
    @ColumnInfo(name = "descricion")
    public String descricion;
    @ColumnInfo(name = "temperatura")
    public double temperatura;
    @ColumnInfo(name = "humedad")
    public int humedad;
    @ColumnInfo(name = "velocidadViento")
    public double velocidadViento;

    @ColumnInfo(name = "fechaConsulta")
    public Date fechaConsulta;

}


