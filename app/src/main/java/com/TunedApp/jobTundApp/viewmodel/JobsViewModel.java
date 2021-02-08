package com.TunedApp.jobTundApp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.TunedApp.jobTundApp.data.model.Jobsmodel;
import com.TunedApp.jobTundApp.data.model.network.AppServices;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JobsViewModel extends AndroidViewModel {

    private List<Jobsmodel> jobslist=new ArrayList<>();

    public JobsViewModel(@NonNull Application application) {
        super(application);
    }



    private MutableLiveData<List<Jobsmodel>> jsobsliveData=null;

    public  MutableLiveData<List<Jobsmodel>> getAllJobs(){
        if (jsobsliveData==null){
            jsobsliveData=new MutableLiveData<>();
            dawnloadeJobs();
        }

        return jsobsliveData;
    }


    private void dawnloadeJobs() {
        AppServices.routs().getAllJobsFromAPi().enqueue(new Callback<List<Jobsmodel>>() {
            @Override
            public void onResponse(Call<List<Jobsmodel>> call, Response<List<Jobsmodel>> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {

                        //save in  local DBS
//                        jobsDao.InsertALL(response.body());

                        //notify  observal  data  is changed
                        jsobsliveData.setValue(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Jobsmodel>> call, Throwable t) {

            }
        });

    }
}