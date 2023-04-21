package com.example.flendzztask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EmployeeAdapterView extends RecyclerView.Adapter<EmployeeHolder> {
    Context context;
    private final OnItemClickListener listener;
    List<User> userList;

    public EmployeeAdapterView(Context context, List<User> userList, OnItemClickListener listener) {
        this.listener = listener;
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    public EmployeeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EmployeeHolder(LayoutInflater.from(context).inflate(R.layout.recycleview_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeHolder holder, int position) {
        holder.employeeName.setText(userList.get(position).getName());
        holder.employeeMailId.setText(userList.get(position).getEmail());
        holder.layoutView.setOnClickListener(view -> listener.onItemClick(userList.get(position)));
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
