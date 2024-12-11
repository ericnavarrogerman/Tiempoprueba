package com.example.tiempo.models;

import android.widget.TextView;

import java.util.Date;

public class EstadoDelTiempoView {

    public String ciudad;
    public String descricion;
    public double temperatura;
    public int humedad;
    public double velocidadViento;
    public Date fecha;

    public EstadoDelTiempoView(String ciudad,String descricion,double temperatura,int humedad, double velocidadViento){
        this.ciudad = ciudad;
        this.descricion = descricion;
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.velocidadViento = velocidadViento;
    }

    public EstadoDelTiempoView(String ciudad,String descricion,double temperatura,int humedad, double velocidadViento,Date fecha){
        this.ciudad = ciudad;
        this.descricion = descricion;
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.velocidadViento = velocidadViento;
        this.fecha = fecha;
    }


}
