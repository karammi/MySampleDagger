package com.notash.mysampledagger;

import com.google.gson.JsonObject;
import com.notash.mysampledagger.models.City;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("provinces")
    Observable<JsonObject> getCities();
//    Observable<JsonObject> getCities();

    @GET("provinces")
    Call<JsonObject> getCitiesFromCall();
}
