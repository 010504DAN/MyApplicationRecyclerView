package com.example.myapplicationrecyclerview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplicationrecyclerview.databinding.FragmentDetailBinding;
import com.example.myapplicationrecyclerview.databinding.FragmentFirstBinding;

import java.net.URL;

public class DetailFragment extends Fragment {
    private FragmentDetailBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDetailBinding.inflate(inflater, container, false);
        return  binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            String name = getArguments().getString("name", "Default Name");
            String img = getArguments().getString("img", "");
            String description = getArguments().getString("description", "No description available");

            binding.tvNameCities.setText(name);
            binding.tvDescription.setText(description);
            if (!img.isEmpty()) {
                new Thread(() -> {
                    try {
                        URL url = new URL(img);
                        Bitmap bitmap = BitmapFactory.decodeStream(url.openStream());
                        requireActivity().runOnUiThread(() -> binding.ivCities.setImageBitmap(bitmap));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        }
    }
}