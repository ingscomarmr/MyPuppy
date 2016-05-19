package com.omunguia.mypuppy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.omunguia.mypuppy.bean.Mascota;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initClicActionBar();
    }

    public void initClicActionBar(){
        ImageView imageView = (ImageView)findViewById(R.id.myPuppyLikes);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentListaLikes = new Intent(MainActivity.this,ListadoMascotasFavoritasActivity.class);
                startActivity(intentListaLikes);
            }
        });

        List<Mascota> mascotas = Arrays.asList(
                new Mascota(R.drawable.p1, "El Petalo", 10),
                new Mascota(R.drawable.p2, "Loba", 7),
                new Mascota(R.drawable.p3, "El Sami", 12),
                new Mascota(R.drawable.p4, "La Joya", 5),
                new Mascota(R.drawable.p5, "Laica", 15)
        );

        recyclerView = (RecyclerView) findViewById(R.id.rvMain);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new MascotaAdapter(mascotas);
        recyclerView.setAdapter(adapter);

    }
}

