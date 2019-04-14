package com.example2017.android.companyemployersdata.Repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example2017.android.companyemployersdata.room.Employer;
import com.example2017.android.companyemployersdata.room.EmployerDAO;
import com.example2017.android.companyemployersdata.room.employerDataBase;

import java.util.List;

/**
 * Created by M7moud on 14-Apr-19.
 */
public class RepositoryImp implements Repository {



    public EmployerDAO employerDAO;
    public LiveData<List<Employer>> name;
    public LiveData<List<Employer>> AllEmployers;

    public RepositoryImp (Application application){

        employerDataBase employerDataBase= com.example2017.android.companyemployersdata.room.employerDataBase.getINSTANCE(application);
        employerDAO=employerDataBase.employerDAO();
        AllEmployers = employerDAO.getAllEmployers();

    }


    @Override
    public void insert(Employer employer) {

        new insertAsync(employerDAO).execute(employer);
    }

    @Override
    public void update(Employer employer) {

        new updateAsync(employerDAO).execute(employer);

    }

    @Override
    public void Delete(Employer employer) {

        new deleteAsync(employerDAO).execute(employer);
    }

    @Override
    public LiveData<List<Employer>> getAllEmployers() {
        return null;
    }


    @Override
    public LiveData<List<Employer>> loadAllUsersOlderThan(int minAge) {
        return null;
    }

    @Override
    public LiveData<List<Employer>> findUserWithName(String search) {

        name=employerDAO.findUserWithName(search);

        return name;
    }


    public static class insertAsync extends AsyncTask<Employer,Void,Void>{

        EmployerDAO employerDAO;

        insertAsync(EmployerDAO employerDAO){
            this.employerDAO = employerDAO;
        }

        @Override
        protected Void doInBackground(Employer... employers) {
           employerDAO.insert(employers[0]);

            return null;
        }
    }

    public static class updateAsync extends AsyncTask<Employer,Void,Void>{

        EmployerDAO employerDAO;

        updateAsync(EmployerDAO employerDAO){
            this.employerDAO = employerDAO;
        }

        @Override
        protected Void doInBackground(Employer... employers) {
            employerDAO.update(employers[0]);

            return null;
        }
    }


    public static class deleteAsync extends AsyncTask<Employer,Void,Void>{

        EmployerDAO employerDAO;

        deleteAsync(EmployerDAO employerDAO){
            this.employerDAO = employerDAO;
        }

        @Override
        protected Void doInBackground(Employer... employers) {
            employerDAO.Delete(employers[0]);

            return null;
        }
    }




}
