package com.example.appbdjson.iu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbdjson.Model.Character;
import com.example.appbdjson.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LifecycleOwner{

    MainActivity context;
    ViewModel viewModel;
    RecyclerView recyclerView;
    AdapterRecicler adapterRecicler;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        recyclerView = findViewById(R.id.idrecycler);
        adapterRecicler = new AdapterRecicler();
        recyclerView.setAdapter(adapterRecicler);

        btn.findViewById(R.id.btnmostrar);

        btn.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {

                                   }
                               }
        );

        viewModel = ViewModelProviders.of(context).get(ViewModel.class);
        Observer listPerson = null;
        assert false;
        viewModel.getLiveData().observe(context, listPerson);

        listPerson = new androidx.lifecycle.Observer() {
            @Override
            public void onChanged(Object o) {
                adapterRecicler.setCharacters((ArrayList<Character>) o);
            }
        };
    }
}