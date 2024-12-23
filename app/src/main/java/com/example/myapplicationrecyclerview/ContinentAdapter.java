package com.example.myapplicationrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplicationrecyclerview.databinding.ItemBinding;

import java.util.ArrayList;

public class ContinentAdapter extends RecyclerView.Adapter<ContinentViewHolder> {
private ArrayList<Continent> list;
private OnItemClick click;

    public ContinentAdapter(ArrayList<Continent> list, OnItemClick click) {
        this.list = list;
        this.click = click;
    }

    @NonNull
    @Override
    public ContinentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ContinentViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ContinentViewHolder holder, int position) {
        holder.bind(list.get(position));
        holder.itemView.setOnClickListener(view->
        click.onClick(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class ContinentViewHolder extends RecyclerView.ViewHolder {
    private ItemBinding binding;

    public ContinentViewHolder( ItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Continent continent){
        binding.tvName.setText(continent.getName());
    }
}
