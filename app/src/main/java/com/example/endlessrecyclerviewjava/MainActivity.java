package com.example.endlessrecyclerviewjava;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Integer> numerosList = new ArrayList<>();

    RecyclerView rvNumeros;
    NumerosAdapter numerosAdapter;

    Integer registroTotales = 35;
    Integer limite = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvNumeros = findViewById(R.id.rvNumeros);

        obtenerPrimerosNumeros();

        numerosAdapter = new NumerosAdapter(numerosList);
        rvNumeros.setAdapter(numerosAdapter);

        rvNumeros.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) rvNumeros.getLayoutManager();

                if (linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == numerosList.size()-1) {
                    obtenerSiguientesNumeros();
                }
            }
        });

    }

    public void obtenerPrimerosNumeros() {
        if((registroTotales-numerosList.size()) < limite) {
            for (int i = numerosList.size() ; i < registroTotales ; i++) {
                numerosList.add(i);
            }
        } else {
            int siguienteLimite = numerosList.size() + limite;
            for (int i = numerosList.size() ; i < siguienteLimite ; i++) {
                numerosList.add(i);
            }
        }
    }

    public void obtenerSiguientesNumeros() {
        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if ((registroTotales-numerosList.size()) < limite) {
                    for (int i = numerosList.size() ; i < registroTotales ; i++) {
                        numerosList.add(i);
                    }
                } else {
                    int siguienteLimite = numerosList.size() + limite;
                    for (int i = numerosList.size() ; i < siguienteLimite ; i++) {
                        numerosList.add(i);
                    }
                }
                numerosAdapter.notifyDataSetChanged();
            }
        }, 3000);
    }
}