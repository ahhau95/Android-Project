package com.example.hau.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by hau on 7/18/2017.
 */



public class FirstFragment extends Fragment {
    // Store instance variables
    private String title;
    private int page;
    RecyclerView recyclerView;
    ArrayList<String> items;



    // newInstance constructor for creating fragment with arguments
    public static FirstFragment newInstance(int page, String title) {
        FirstFragment fragmentFirst = new FirstFragment();
        Bundle args = new Bundle();
        args.putInt("0", page);
        args.putString("HawkerStall", title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("0", 0);
        title = getArguments().getString("HakwerStall");

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.viewpager, container, false);     //Inflate the view for fragment based on layout view xml
        items = new ArrayList<String>(); //adding the data inside the array items
        items.add("Gurney Drive Hawker");
        items.add("Kimberly Hawker");
        items.add("Chulia Street Hawker");
        items.add("Newlane Hawker");
        items.add("Pulau Tikus Hawker");
        items.add("Air Itam Hawker And Market");
        items.add("Batu Lanchang Hawker And Market");
        items.add("Jelutong Hawker And Market");
        items.add("Penang Road Teow Chew Chendol & Laksa");
        items.add("Bayan Baru Market Hawker Center");
        items.add("Cecil Street Market Hawker Center");
        items.add("Sungai Pinang Food Court");



        recyclerView = (RecyclerView) view.findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new Adapter(getContext(),items));
        return view;

    }

}
