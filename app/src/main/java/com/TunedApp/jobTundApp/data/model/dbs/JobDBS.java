package com.TunedApp.jobTundApp.data.model.dbs;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.TunedApp.jobTundApp.data.model.Jobsmodel;
import com.TunedApp.jobTundApp.data.model.Utilites.utils;
import com.TunedApp.jobTundApp.data.model.dao.JobDao;




@Database(entities = {Jobsmodel.class}, version =1, exportSchema = false)
public abstract class JobDBS extends RoomDatabase {

    public abstract JobDao githubDao();

    private static JobDBS ourInstance;

    //a singleton to prevent having multiple instances of the database opened at the same time.
    public static JobDBS getDatabase(final Context context)
    {
        synchronized (JobDBS.class) {
            if (ourInstance == null) {
                // Create database here
                //This code uses Room's database builder to create a RoomDatabase object in the application context from the SMSRoomDatabase class and names it "sms_database".
                ourInstance = Room.databaseBuilder(context.getApplicationContext(),
                        JobDBS.class, utils.DBSName).
                        allowMainThreadQueries().build();
            }
        }
        return ourInstance;
    }


    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override
    public void clearAllTables() {

    }
}
