package com.example.appbdjson.ApiRetrofit;


import com.example.appbdjson.Model.Character;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EndPoint {

    String ROUTE = "/character";

    @GET(ROUTE)
    Call<List<Character>> getPost();

}
