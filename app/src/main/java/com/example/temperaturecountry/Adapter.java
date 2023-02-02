package com.example.temperaturecountry;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.temperaturecountry.databinding.GorunumBinding;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.CountrHolder> {
    ArrayList<CountryTemp> arrayList;
    GorunumBinding binding;

    public Adapter(ArrayList<CountryTemp> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public CountrHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = GorunumBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CountrHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CountrHolder holder, int position) {
        binding.txt1.setText(arrayList.get(position).country);
        binding.txt2.setText(arrayList.get(position).temperature);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class CountrHolder extends RecyclerView.ViewHolder {
        GorunumBinding binding;

        public CountrHolder(@NonNull GorunumBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
