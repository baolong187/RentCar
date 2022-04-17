package com.example.rentcar.api;

import com.example.rentcar.model.Employee;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Currency;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;

public interface ApiService {
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    ApiService apiService = new Retrofit.Builder()
            .baseUrl("http://192.168.1.15:8080/api/v1/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);

    @POST("customers/login")
    Call<Employee> login (@Body Employee employee);
}
