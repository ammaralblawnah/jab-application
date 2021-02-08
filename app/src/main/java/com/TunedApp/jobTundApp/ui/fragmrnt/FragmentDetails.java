package com.TunedApp.jobTundApp.ui.fragmrnt;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.TunedApp.jobTundApp.R;
import com.TunedApp.jobTundApp.data.model.Jobsmodel;
import com.bumptech.glide.Glide;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Locale;

import javax.xml.transform.OutputKeys;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentDetails extends BaseFragment {


    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.jpb_description)
    TextView jpbDescription;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.job_image)
    ImageView imageView;
    Jobsmodel jobsmodel;
    private OutputKeys Build;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.jobs_fragment_details, container, false);
        ButterKnife.bind(this, root);

        if (getArguments() != null) {
            jobsmodel = getArguments().getParcelable("job") ;
        }

        Glide.with(getActivity())
                .load(jobsmodel.getCompany_logo())
                .centerCrop()
                .placeholder(R.drawable.images)
                .into(imageView);


        if (android.os.Build.VERSION.SDK_INT>= android.os.Build.VERSION_CODES.N) {
            jpbDescription.setText(Html.fromHtml(jobsmodel.getDescription(), Html.FROM_HTML_MODE_COMPACT));
        } else {
            jpbDescription.setText(Html.fromHtml(jobsmodel.getDescription()));
        }
        //jpbDescription.setText(jobsmodel.getDescription());


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri = String.format(Locale.ENGLISH, "geo:%f,%f", 31.9841475,35.9069972);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);
            }
        });
        return root;
    }
}
