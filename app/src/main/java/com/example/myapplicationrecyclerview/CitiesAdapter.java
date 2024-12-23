package com.example.myapplicationrecyclerview;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplicationrecyclerview.databinding.ItemBinding;

import java.util.ArrayList;

public class CitiesAdapter extends RecyclerView.Adapter<CitiesViewHolder> {
    private ArrayList<Cities> list;
    private OnItemClick click;

    public CitiesAdapter(ArrayList<Cities> list, OnItemClick click) {
        this.list = list;
        this.click = click;
    }

    @NonNull
    @Override
    public CitiesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CitiesViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CitiesViewHolder holder, int position) {
        holder.bind(list.get(position));
        holder.itemView.setOnClickListener(view->
                click.onClick(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class CitiesViewHolder extends RecyclerView.ViewHolder {
    private ItemBinding binding;

    public CitiesViewHolder( ItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Cities cities){
        binding.tvName.setText(cities.getName());
    }
}