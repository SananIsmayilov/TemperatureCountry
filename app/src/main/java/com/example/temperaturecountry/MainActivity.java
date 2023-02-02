package com.example.temperaturecountry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    Retrofit retrofit;
    CompositeDisposable compositeDisposable;
    String Base_Url = "https://raw.githubusercontent.com/";
    ArrayList<CountryTemp> arrayList;
    Adapter adapter;
    RecyclerView rcyc;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Gson gson = new GsonBuilder().create();
        retrofit = new Retrofit.Builder().
                addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(Base_Url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        getData();

        rcyc = findViewById(R.id.rcyc);
    }

    public void getData() {
        Country country = retrofit.create(Country.class);
        compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(country.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::load)
        );

    }

    public void load(List<CountryTemp> countryTempList) {
        arrayList = new ArrayList<>(countryTempList);

        rcyc.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(arrayList);
        rcyc.setAdapter(adapter);

    }


}