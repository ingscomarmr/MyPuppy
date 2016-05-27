package com.omunguia.mypuppy.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mikhaellopez.circularimageview.CircularImageView;
import com.omunguia.mypuppy.R;
import com.omunguia.mypuppy.adapter.MascotaAdapter;
import com.omunguia.mypuppy.bean.ListaMascotas;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);


        //agregar imagen
        CircularImageView civPerfil = (CircularImageView) view.findViewById(R.id.civPerfil);
        civPerfil.setImageResource(R.drawable.mascota);

        initRecyclerView(view);
        return view;
    }


    public void initRecyclerView(View view){
        recyclerView = (RecyclerView) view.findViewById(R.id.rvMainRecyclerView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new MascotaAdapter(ListaMascotas.mascotas,true);
        recyclerView.setAdapter(adapter);
    }

}
