package com.omunguia.mypuppy;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.omunguia.mypuppy.adapter.MascotaAdapter;
import com.omunguia.mypuppy.bean.ListaMascotas;

public class ListadoMascotasFavoritasActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.listado_mascotas_favoritas);

        //para soporte de actionbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.actionBarPuppy);
        setSupportActionBar(toolbar);

        TextView textViewTitulo = (TextView)findViewById(R.id.tvTituloActionBar);
        textViewTitulo.setText(getString(R.string.app_name_favoritas));

        //para activar el button back
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initClicActionBar();
    }


    public void initClicActionBar(){

        ImageView imageViewHueso = (ImageView)findViewById(R.id.myPuppyHome);
        imageViewHueso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intentMain = new Intent(DetalleMascotaActivity.this,MainActivity.class);
                //startActivity(intentMain);
                onBackPressed();
            }
        });

        ImageView imageViewStar = (ImageView)findViewById(R.id.myPuppyLikes);
        imageViewStar.setVisibility(View.INVISIBLE);
        imageViewStar.refreshDrawableState();

        recyclerView = (RecyclerView) findViewById(R.id.rvMainFavoritos);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new MascotaAdapter(ListaMascotas.mascotas);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_action,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuRefreshListFavorites:
                Snackbar.make(this.getCurrentFocus(), getResources().getString(R.string.text_very_soon), Snackbar.LENGTH_LONG)
                        .show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
