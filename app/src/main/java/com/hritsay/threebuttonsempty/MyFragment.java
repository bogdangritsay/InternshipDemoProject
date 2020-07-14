package com.hritsay.threebuttonsempty;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hritsay.threebuttonsempty.databinding.ActivityMainBinding;
import com.hritsay.threebuttonsempty.databinding.MyFragmentBinding;

public class MyFragment extends Fragment {
   // private ActivityMainBinding activityMainBinding;
    private MyFragmentBinding myFragmentBinding;
    private MyViewModel mViewModel;
    public static final String TAG = SecondFragment.class.getCanonicalName();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        myFragmentBinding = MyFragmentBinding.inflate(inflater, container, false);
        //activityMainBinding = ActivityMainBinding.inflate(((MainActivity)getActivity()).getLayoutInflater());
        return myFragmentBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MyViewModel.class);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        myFragmentBinding = null;
    }

}