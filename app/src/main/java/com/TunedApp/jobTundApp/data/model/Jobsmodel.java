package com.TunedApp.jobTundApp.data.model;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Jobsmodel implements Parcelable {


    @PrimaryKey
    @NonNull
    private  String id;
    private String company;
    private  String company_logo;
    private  String  company_url;
    private String created_at;
    private  String   description;
    private  String how_to_apply;
    private  String location;
    private  String title;
    private  String type;
    private  String url;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompany_logo() {
        return company_logo;
    }

    public void setCompany_logo(String company_logo) {
        this.company_logo = company_logo;
    }

    public String getCompany_url() {
        return company_url;
    }

    public void setCompany_url(String company_url) {
        this.company_url = company_url;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHow_to_apply() {
        return how_to_apply;
    }

    public void setHow_to_apply(String how_to_apply) {
        this.how_to_apply = how_to_apply;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.company);
        dest.writeString(this.company_logo);
        dest.writeString(this.company_url);
        dest.writeString(this.created_at);
        dest.writeString(this.description);
        dest.writeString(this.how_to_apply);
        dest.writeString(this.id);
        dest.writeString(this.location);
        dest.writeString(this.title);
        dest.writeString(this.type);
        dest.writeString(this.url);
    }

    public Jobsmodel() {
    }

    protected Jobsmodel(Parcel in) {
        this.company = in.readString();
        this.company_logo = in.readString();
        this.company_url = in.readString();
        this.created_at = in.readString();
        this.description = in.readString();
        this.how_to_apply = in.readString();
        this.id = in.readString();
        this.location = in.readString();
        this.title = in.readString();
        this.type = in.readString();
        this.url = in.readString();
    }

    public static final Parcelable.Creator<Jobsmodel> CREATOR = new Parcelable.Creator<Jobsmodel>() {
        @Override
        public Jobsmodel createFromParcel(Parcel source) {
            return new Jobsmodel(source);
        }

        @Override
        public Jobsmodel[] newArray(int size) {
            return new Jobsmodel[size];
        }
    };
}
