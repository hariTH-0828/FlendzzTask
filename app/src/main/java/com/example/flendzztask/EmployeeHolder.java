package com.example.flendzztask;

import android.text.util.Linkify;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EmployeeHolder extends RecyclerView.ViewHolder {

    TextView employeeName, employeeMailId;
    public LinearLayout layoutView;

    public EmployeeHolder(@NonNull View itemView) {
        super(itemView);
        employeeName = itemView.findViewById(R.id.employee_name);
        employeeMailId = itemView.findViewById(R.id.employee_mailId);
        employeeMailId.setAutoLinkMask(Linkify.EMAIL_ADDRESSES);
        layoutView = itemView.findViewById(R.id.layoutContainer);
    }
}
