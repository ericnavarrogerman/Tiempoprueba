package com.example.tiempo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tiempo.adapters.TiempoAdapter;
import com.example.tiempo.models.EstadoDelTiempoView;
import com.example.tiempo.viewmodels.TiempoViewModel;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText ciudad ;
    Button buscar;
    RecyclerView recyclerView;
    TextView textNoBusquedas;

    TiempoAdapter adapter;

    TiempoViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        viewModel = new ViewModelProvider(this).get(TiempoViewModel.class);

        buscar = findViewById(R.id.buttonBuscar);
        ciudad = findViewById(R.id.editTextCiudad);
        recyclerView = findViewById(R.id.recycler);
        textNoBusquedas = findViewById(R.id.textViewRecientes);

        adapter = new TiempoAdapter();

        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);

        buscar.setOnClickListener(this);

        viewModel.getHistorial().observe(this, data->{
            if (data.isEmpty()){
                textNoBusquedas.setVisibility(View.VISIBLE);
            }else {
                textNoBusquedas.setVisibility(View.GONE);
            }
            adapter.setListaHistorial(data.stream().map(entity ->
                  new  EstadoDelTiempoView(
                          entity.ciudad,
                          entity.descricion,
                          entity.temperatura,
                          entity.humedad,
                          entity.velocidadViento,
                          entity.fechaConsulta
                          )
            ).collect(Collectors.toList())
            );
        });


    }

    @Override
    public void onClick(View view) {
        viewModel.realizarNuevaConsulta(ciudad.getText().toString());
        ciudad.setText("");
    }
}