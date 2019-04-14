package com.example2017.android.companyemployersdata;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example2017.android.companyemployersdata.EmployViewModel.EmployerViewModel;
import com.example2017.android.companyemployersdata.room.Employer;

import java.util.Random;

public class AddActivity extends AppCompatActivity {

    EditText name,age;
    Button button;
    EmployerViewModel employerViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        name=(EditText)findViewById(R.id.name);
        age=(EditText)findViewById(R.id.age);
        button=(Button)findViewById(R.id.add);


        employerViewModel= ViewModelProviders.of(this).get(EmployerViewModel.class);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name !=null && age!=null){

                    Employer employer=new Employer(new Random().nextInt(10),name.getText().toString(),age.getText().toString());
                    employerViewModel.insert(employer);
                    Toast.makeText(AddActivity.this, "Added Successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
