package com.example.tiempo.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tiempo.R;
import com.example.tiempo.models.EstadoDelTiempoView;

import java.text.SimpleDateFormat;
import java.util.List;

public class TiempoAdapter extends RecyclerView.Adapter<TiempoAdapter.TiempoViewHolder> {


    List<EstadoDelTiempoView> listaHistorial;

    @NonNull
    @Override
    public TiempoAdapter.TiempoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_historial,parent, false);

        return new TiempoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TiempoAdapter.TiempoViewHolder holder, int position) {
        EstadoDelTiempoView estado = listaHistorial.get(position);
        if (position==0){
            holder.imageView.setVisibility(View.VISIBLE);
        }else{
            holder.imageView.setVisibility(View.GONE);
        }

        holder.setData(estado);
    }

    @Override
    public int getItemCount() {
        if (listaHistorial == null){
            return  0;
        }
        return listaHistorial.size();
    }

    public void setListaHistorial(List<EstadoDelTiempoView> lista){
        this.listaHistorial = lista;
        notifyDataSetChanged();
    }



    public static class TiempoViewHolder extends RecyclerView.ViewHolder{

        TextView ciudad;
        TextView descricion;
        TextView temperatura;
        TextView humedad;
        TextView velocidadViento;
        ImageView imageView ;
        TextView fecha;

        public TiempoViewHolder(@NonNull View itemView) {
            super(itemView);

            ciudad = itemView.findViewById(R.id.textViewNombreDeCIudad);
            descricion = itemView.findViewById(R.id.textViewDescripcion);
            temperatura = itemView.findViewById(R.id.textViewValorTemperatura);
            humedad = itemView.findViewById(R.id.textViewValorHumedad);
            velocidadViento = itemView.findViewById(R.id.textViewValorVelocidadViento);
            fecha = itemView.findViewById(R.id.textViewFecha);
            imageView = itemView.findViewById(R.id.imageViewIsFrist);

        }

        public void setData(EstadoDelTiempoView estado) {
            ciudad.setText(estado.ciudad);
            descricion.setText(estado.descricion);
            temperatura.setText(String.format("%s", estado.temperatura));
            humedad.setText(String.format("%s", estado.humedad));
            velocidadViento.setText(String.format("%s", estado.velocidadViento));
            SimpleDateFormat formatoFechaHora = new SimpleDateFormat("dd/MM/yy HH:mm");
            String fechaFormateada = formatoFechaHora.format(estado.fecha);
            fecha.setText(fechaFormateada);
        }
    }

}