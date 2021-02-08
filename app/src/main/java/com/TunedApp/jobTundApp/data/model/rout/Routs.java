package com.TunedApp.jobTundApp.data.model.rout;

import com.TunedApp.jobTundApp.data.model.Jobsmodel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Routs {

    @GET("positions.json?description=ruby&page=1")
    Call<List<Jobsmodel>> getAllJobsFromAPi();
}
