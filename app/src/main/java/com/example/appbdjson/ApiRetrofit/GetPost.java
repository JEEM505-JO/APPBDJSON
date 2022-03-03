package com.example.appbdjson.ApiRetrofit;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.example.appbdjson.Model.Character;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetPost {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    EndPoint endPoint = retrofit.create(EndPoint.class);
    private MutableLiveData<List<Character>> charactersMutableLiveData;

    public GetPost() {
        charactersMutableLiveData = new MutableLiveData<List<Character>>();
        endPoint.getPost().enqueue(new Callback<List<Character>>() {
            @Override
            public void onResponse(Call<List<Character>> call, Response<List<Character>> response) {
                if(response.body() != null)
                charactersMutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Character>> call, Throwable t) {
                charactersMutableLiveData.postValue(null);
            }
        });
    }

    public LiveData<List<Character>> getcharacters(){
        return charactersMutableLiveData;
    }
}

