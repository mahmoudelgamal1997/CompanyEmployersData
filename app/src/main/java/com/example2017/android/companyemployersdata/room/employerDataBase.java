package com.example2017.android.companyemployersdata.room;

import android.app.Application;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by M7moud on 14-Apr-19.
 */
@Database(entities = {Employer.class},version = 2)
public abstract class employerDataBase extends RoomDatabase {

    public abstract EmployerDAO employerDAO();

    public static employerDataBase INSTANCE;

    public static synchronized employerDataBase getINSTANCE(Application application){
        if (INSTANCE == null){

            INSTANCE = Room.databaseBuilder(application.getApplicationContext(),employerDataBase.class,"employer_information")
                    .fallbackToDestructiveMigration()
                    .build();

        }

        return INSTANCE;
    }

}
