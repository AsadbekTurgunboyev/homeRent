package com.example.renthome.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.renthome.HomeModel;
import com.example.renthome.R;
import com.example.renthome.adapter.MainAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    MainAdapter adapter;
    FirebaseDatabase database;
    List<HomeModel> list;
    DatabaseReference myRef;
    public HomeFragment() {
        // Required empty public constructor
    }







    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        iniViews(view);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("near");
        getNearHome();
        return view;
    }

    private void getNearHome() {
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list = new ArrayList<>();
                for(DataSnapshot ds : snapshot.getChildren()){
                    HomeModel model = ds.getValue(HomeModel.class);
                    list.add(model);
                }
                adapter = new MainAdapter(getContext(),list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void iniViews(View view) {
        recyclerView = view.findViewById(R.id.recyclerView);
    }
}