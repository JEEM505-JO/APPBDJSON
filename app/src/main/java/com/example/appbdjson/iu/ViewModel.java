package com.example.appbdjson.iu;


import android.nfc.NfcAdapter;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.appbdjson.ApiRetrofit.GetPost;
import com.example.appbdjson.Model.Character;

import java.util.ArrayList;
import java.util.List;

public class ViewModel extends androidx.lifecycle.ViewModel {
    MutableLiveData<ArrayList<Character>> liveData;
    ArrayList<Character> arrayList;
    GetPost  getPost;

    public void MainActivity(){
        liveData = new MutableLiveData<>();
        init();

    }

    public MutableLiveData<ArrayList<Character>> getLiveData(){
        return liveData;
    }

    private void init() {
        loadlist();
        liveData.setValue(arrayList);
    }

    public void loadlist(){

        getPost.getcharacters().observeForever(new Observer<List<Character>>() {
            @Override
            public void onChanged(List<Character> characters) {
                arrayList.addAll(characters);
            }
        });


    }


}
