package com.TunedApp.jobTundApp.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.TunedApp.jobTundApp.R;
import com.TunedApp.jobTundApp.data.model.Jobsmodel;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JobsAdapter extends RecyclerView.Adapter<JobsAdapter.MyViewHolder> {


    private ArrayList<Jobsmodel> mData;

    public OnClickItem clickItemRow;

    Context context;

    public interface OnClickItem {
        void clickOnItem(int position,Jobsmodel jobsmodel);
    }


    // data is passed into the constructor
    public JobsAdapter(Context context, ArrayList<Jobsmodel> data, OnClickItem clickItemRow) {
        this.mData = data;
        this.context = context;
        this.clickItemRow = clickItemRow;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_jobs_recyclerview, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        if (mData != null) {

            Glide.with(context)
                    .load(mData.get(position).getCompany_logo())
                    .centerCrop()
                    .placeholder(R.drawable.images)
                    .into(holder.jobImage);

            holder.txvCompany.setText(mData.get(position).getCompany());
            holder.txvJobTilte.setText(mData.get(position).getTitle());
            holder.txvDate.setText(mData.get(position).getCreated_at());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickItemRow.clickOnItem(position,mData.get(position));
                }
            });

        }
    }


    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.job_image)
        ImageView jobImage;
        @BindView(R.id.txv_jobname)
        TextView txvJobname;
        @BindView(R.id.txv_jobTilte)
        TextView txvJobTilte;
        @BindView(R.id.txv_date)
        TextView txvDate;
        @BindView(R.id.txv_company)
        TextView txvCompany;

        MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
