package com.TunedApp.jobTundApp.data.model.dao;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import com.TunedApp.jobTundApp.data.model.Jobsmodel;

@Dao
public interface JobDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Jobsmodel jobsmodel);
}
