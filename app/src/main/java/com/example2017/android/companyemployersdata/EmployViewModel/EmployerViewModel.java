package com.example2017.android.companyemployersdata.EmployViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example2017.android.companyemployersdata.Repository.Repository;
import com.example2017.android.companyemployersdata.Repository.RepositoryImp;
import com.example2017.android.companyemployersdata.room.Employer;

import java.util.List;

/**
 * Created by M7moud on 14-Apr-19.
 */
public class EmployerViewModel extends AndroidViewModel implements Repository {


    public RepositoryImp repositoryImp;
    public LiveData<List<Employer>> SingleUser;
    LiveData<List<Employer>> AllEmployer;

    public EmployerViewModel(@NonNull Application application) {
        super(application);

        repositoryImp= new RepositoryImp(application);
        AllEmployer = repositoryImp.AllEmployers;

    }

    @Override
    public void insert(Employer employer) {

        repositoryImp.insert(employer);
    }

    @Override
    public void update(Employer employer) {

        repositoryImp.update(employer);
    }


    @Override
    public void Delete(Employer employer) {

        repositoryImp.Delete(employer);
    }

    @Override
    public LiveData<List<Employer>> getAllEmployers() {
        return AllEmployer;
    }

    @Override
    public LiveData<List<Employer>> loadAllUsersOlderThan(int minAge) {
        return null;
    }

    @Override
    public LiveData<List<Employer>> findUserWithName(String search) {


        return repositoryImp.findUserWithName(search);

    }
}
