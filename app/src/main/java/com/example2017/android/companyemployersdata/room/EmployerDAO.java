package com.example2017.android.companyemployersdata.room;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by M7moud on 14-Apr-19.
 */
@Dao
public interface EmployerDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert (Employer employer);

    @Update
    void update (Employer employer);

    @Delete
    void Delete (Employer employer);


    @Query("SELECT * FROM employer_information WHERE age > :minAge")
    public Employer[] loadAllUsersOlderThan(int minAge);

    @Query("SELECT * FROM employer_information WHERE name LIKE :search")
    LiveData<List<Employer>> findUserWithName(String search);


    @Query("SELECT * FROM employer_information ORDER BY priority DESC")
    LiveData<List<Employer>> getAllEmployers();

}
