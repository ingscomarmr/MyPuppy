package com.omunguia.mypuppy.fragments;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.omunguia.mypuppy.R;
import com.omunguia.mypuppy.adapter.MascotaAdapter;
import com.omunguia.mypuppy.bean.ListaMascotas;
import com.omunguia.mypuppy.bean.Mascota;

import db.BaseDatos;
import db.BaseDatosConfig;


public class HomeFragment extends Fragment {


    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initRecyclerView(view);
        return view;
    }

    public void initRecyclerView(View view){
        recyclerView = (RecyclerView) view.findViewById(R.id.rvMain);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);


        BaseDatos baseDatos = new BaseDatos(getContext());

        adapter = new MascotaAdapter(baseDatos.getMascotas());
        recyclerView.setAdapter(adapter);
    }
}
