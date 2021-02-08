package com.TunedApp.jobTundApp.ui.fragmrnt;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.TunedApp.jobTundApp.R;
import com.TunedApp.jobTundApp.data.model.Jobsmodel;
import com.TunedApp.jobTundApp.ui.adapter.JobsAdapter;
import com.TunedApp.jobTundApp.viewmodel.JobsViewModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentJobs extends BaseFragment {

    ArrayList<Jobsmodel> jobsmodelArrayList = new ArrayList<>();


    @BindView(R.id.rec_jobs)
    RecyclerView recJobs;

    JobsAdapter jobsAdapter = null;
    @BindView(R.id.progressBar_cyclic)
    ProgressBar progressBarCyclic;
    private JobsViewModel jobsViewModel;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        jobsViewModel= ViewModelProviders.of(this).get(JobsViewModel.class);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.jobs_frgment, container, false);
        ButterKnife.bind(this, rootView);
        progressBarCyclic.setVisibility(View.VISIBLE);
        jobsViewModel.getAllJobs().observe(getActivity(), new Observer<List<Jobsmodel>>() {
            @Override
            public void onChanged(List<Jobsmodel> jobsList) {
                progressBarCyclic.setVisibility(View.GONE);
                initRecyclerView();
                jobsAdapter = new JobsAdapter(getActivity(), (ArrayList<Jobsmodel>) jobsList, new JobsAdapter.OnClickItem() {
                    @Override
                    public void clickOnItem(int position, Jobsmodel jobsmodel) {
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("job", jobsmodel);
                        openFragmentWithBundle(new FragmentDetails(), "FragmentDetails", bundle);
                    }
                });
                recJobs.setAdapter(jobsAdapter);
            }
        });

        return rootView;
    }


    private void initRecyclerView() {
        RecyclerView.LayoutManager mlayoutManager =
                new GridLayoutManager(getActivity(), 1);
        recJobs.setLayoutManager(mlayoutManager);
        recJobs.setAdapter(jobsAdapter);
    }


}
