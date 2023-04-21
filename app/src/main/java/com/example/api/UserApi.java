package com.example.api;

import com.example.flendzztask.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserApi {

    @GET("https://jsonplaceholder.typicode.com/users")
    Call<List<User>> getAllUsers();

    @GET("https://jsonplaceholder.typicode.com/users/{id}")
    Call<User> getUserById(@Path("id") int id);
}
