package com.example.flendzztask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.api.UserApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements OnItemClickListener{
    List<User> listUsers;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.employee_recyclerview);
        listUsers = new ArrayList<>();

        RetrofitService retrofitService = new RetrofitService();
        UserApi userApi = retrofitService.getRetrofit().create(UserApi.class);

        userApi.getAllUsers().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(@NonNull Call<List<User>> call,@NonNull Response<List<User>> response) {
                if(response.isSuccessful()){
                    List<User> userList = response.body();
                    listUsers.addAll(Objects.requireNonNull(userList));
                    displayAdapter(listUsers);
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<User>> call,@NonNull Throwable t) {
                Toast.makeText(getApplicationContext(), "Connection failed...", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void displayAdapter(List<User> listUsers) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(new EmployeeAdapterView(getApplicationContext(), listUsers, this));
    }

    @Override
    public void onItemClick(User position) {
        RetrofitService retrofitService = new RetrofitService();
        UserApi userApi = retrofitService.getRetrofit().create(UserApi.class);

        userApi.getUserById(position.getId()).enqueue(new Callback<User>() {
            @Override
            public void onResponse(@NonNull Call<User> call,@NonNull Response<User> response) {
                if(response.isSuccessful()){
                    User userResponse = response.body();
                    Intent intent = new Intent(getApplicationContext(), EmployeeDetail.class);
                    intent.putExtra("name", Objects.requireNonNull(userResponse).getName());
                    intent.putExtra("mailId", userResponse.getEmail());
                    intent.putExtra("id", String.valueOf(userResponse.getId()));
                    intent.putExtra("suite", userResponse.getAddress().getSuite());
                    intent.putExtra("street", userResponse.getAddress().getStreet());
                    intent.putExtra("city", userResponse.getAddress().getCity());
                    intent.putExtra("zipcode", userResponse.getAddress().getZipcode());
                    intent.putExtra("phoneNumber", userResponse.getPhone());
                    intent.putExtra("companyName", userResponse.getCompany().getName());
                    intent.putExtra("website", userResponse.getWebsite());
                    startActivity(intent);
                }
            }
            @Override
            public void onFailure(@NonNull Call<User> call,@NonNull Throwable t) {
                Toast.makeText(getApplicationContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}