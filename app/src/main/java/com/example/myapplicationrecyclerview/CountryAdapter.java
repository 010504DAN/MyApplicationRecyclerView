package com.example.myapplicationrecyclerview;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplicationrecyclerview.databinding.ItemBinding;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryViewHolder> {
    private ArrayList<Country> list;
    private OnItemClick click;

    public CountryAdapter(ArrayList<Country> list, OnItemClick click) {
        this.list = list;
        this.click = click;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CountryViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        holder.bind(list.get(position));
        holder.itemView.setOnClickListener(view->
                click.onClick(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class CountryViewHolder extends RecyclerView.ViewHolder {
    private ItemBinding binding;

    public CountryViewHolder( ItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Country country){
        binding.tvName.setText(country.getName());
    }
}