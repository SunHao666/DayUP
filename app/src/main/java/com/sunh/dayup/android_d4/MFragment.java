package com.sunh.dayup.android_d4;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sunh.dayup.R;

/**
 * Created by jpwen on 2017/7/19.
 */

public class MFragment extends Fragment{

    public static MFragment newInstance(Context context, int position) {

        return new MFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_recyleview,null);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
//        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new MRecyclerAdapter(getActivity()));

        return view;
    }
}
