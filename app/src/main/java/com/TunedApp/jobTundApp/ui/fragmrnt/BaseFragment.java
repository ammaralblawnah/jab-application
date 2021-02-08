package com.TunedApp.jobTundApp.ui.fragmrnt;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.TunedApp.jobTundApp.R;

public class BaseFragment extends Fragment {


    FragmentTransaction fragmentTransaction;
    Fragment currentFragment;


    public void openFragment(Fragment fragment, String tag) {
        try {
            fragmentTransaction =  getActivity().getSupportFragmentManager().beginTransaction();
            if (getActivity().getSupportFragmentManager().findFragmentById(R.id.jobs_detail_containe) != fragment) {
                fragmentTransaction.replace(R.id.jobs_detail_containe, fragment, tag);
                fragmentTransaction.addToBackStack(tag);
                fragmentTransaction.commit();
            }
        } catch (Exception e) {

        }
    }


    public void openFragmentWithBundle(Fragment fragment, String tag, Bundle bundle){
        FragmentManager fm;
        FragmentTransaction ft;
        fm = getFragmentManager();
        fragment.setArguments(bundle);
        ft = fm.beginTransaction().replace(R.id.jobs_detail_containe,fragment,tag);
        ft.addToBackStack(tag);
        ft.commit();

    }




}
