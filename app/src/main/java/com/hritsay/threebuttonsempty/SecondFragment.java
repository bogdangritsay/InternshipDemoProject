package com.hritsay.threebuttonsempty;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hritsay.threebuttonsempty.databinding.FragmentSecondBinding;

import java.util.LinkedList;


public class SecondFragment extends Fragment {
    private FragmentSecondBinding fragmentSecondBinding;
    public static final String TAG = SecondFragment.class.getCanonicalName();
    private UserListAdapter adapter;
    private RecyclerView recyclerView;
    private final LinkedList<UserItem> itemList = new LinkedList<>();

    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentSecondBinding = FragmentSecondBinding.inflate(inflater, container, false);
        View view = fragmentSecondBinding.getRoot();
        fragmentSecondBinding.secondFrBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStack(MyFragment.TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            }
        });



        for (int i = 0; i < 20; i++) {
            itemList.add(new UserItem("Title №" + i , "Descripion " + i, R.drawable.android_image));
        }
        recyclerView = fragmentSecondBinding.recycleList;
        adapter = new UserListAdapter(getContext(), itemList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        return view;
    }


}