package com.example.endlessrecyclerviewjava;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NumerosAdapter extends RecyclerView.Adapter<NumerosAdapter.ViewHolder> {

    List<Integer> numerosList;

    public NumerosAdapter(List<Integer> numerosList) {
        this.numerosList = numerosList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_numeros, parent, false);
        return new ViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvNumero.setText(numerosList.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return numerosList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvNumero;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNumero = itemView.findViewById(R.id.tvNumero);
        }
    }
}
