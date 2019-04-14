package com.example2017.android.companyemployersdata.Repository;

import android.arch.lifecycle.LiveData;

import com.example2017.android.companyemployersdata.room.Employer;

import java.util.List;

/**
 * Created by M7moud on 14-Apr-19.
 */
public interface Repository {


    void insert (Employer employer);

    void update (Employer employer);

    void Delete (Employer employer);


     LiveData<List<Employer>> getAllEmployers();

    public LiveData<List<Employer>> loadAllUsersOlderThan(int minAge);

    public LiveData<List<Employer>> findUserWithName(String search);

}
