package com.example2017.android.companyemployersdata;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example2017.android.companyemployersdata.EmployViewModel.EmployerViewModel;
import com.example2017.android.companyemployersdata.room.Employer;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EmployerViewModel employerViewModel;
    EditText editText;
    Button but ,Add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=(EditText)findViewById(R.id.Search);
        but=(Button)findViewById(R.id.but);
        Add=(Button)findViewById(R.id.add);

        employerViewModel= ViewModelProviders.of(this).get(EmployerViewModel.class);


        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ii =new Intent(MainActivity.this,AddActivity.class);
                startActivity(ii);
            }
        });

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Employer employer=new Employer(1,"mahmoud","12");
                employerViewModel.insert(employer);
                Log.e("add","Done");

            }
        });


     try {

         employerViewModel.getAllEmployers().observe(this, new Observer<List<Employer>>() {
             @Override
             public void onChanged(@Nullable List<Employer> employers) {
                 Log.e("All Data",employers.get(0).getName());
             }
         });



         employerViewModel.findUserWithName("ahmed").observe(this, new Observer<List<Employer>>() {
             @Override
             public void onChanged(@Nullable List<Employer> employers) {

                 for(int i=0;i<employers.size();i++) {
                     Log.e("name", employers.get(i).getName());
                     Log.e("name", employers.get(i).getAge());
                 }}
         });



     }catch (Exception e){

     }



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
