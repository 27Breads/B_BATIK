package com.myaplication.B_BATIKS.rest;

import com.myaplication.B_BATIKS.model.BatikModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("batik/all")  //end point
    Call<BatikModel> getData();
}
