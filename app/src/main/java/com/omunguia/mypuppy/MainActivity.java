package com.omunguia.mypuppy;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.omunguia.mypuppy.bean.ListaMascotas;
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

        Toolbar toolbar = (Toolbar) findViewById(R.id.actionBarPuppy);
        setSupportActionBar(toolbar);

        TextView textViewTitulo = (TextView)findViewById(R.id.tvTituloActionBar);
        textViewTitulo.setText(getString(R.string.app_name));

        initClicActionBar();

        Log.i("#MainActivity.OnCreate", "Crear Menu Contextual");
        ImageView myPuppyHome = (ImageView)findViewById(R.id.myPuppyHome);
        registerForContextMenu(myPuppyHome);


        ImageView myPuppyLikes = (ImageView)findViewById(R.id.myPuppyLikes);
        myPuppyLikes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(v.getContext(),v);
                popupMenu.getMenuInflater().inflate(R.menu.menu_popup, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menuPrimero10:
                                Snackbar.make(getCurrentFocus(), getResources().getString(R.string.text_very_soon), Snackbar.LENGTH_LONG)
                                        .show();
                                break;
                            case R.id.menuPrimero5:
                                Intent intentListaLikes = new Intent(MainActivity.this, ListadoMascotasFavoritasActivity.class);
                                startActivity(intentListaLikes);
                                break;
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });


    }

    public void initClicActionBar(){

        ImageView imageView = (ImageView)findViewById(R.id.myPuppyLikes);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentListaLikes = new Intent(MainActivity.this, ListadoMascotasFavoritasActivity.class);
                startActivity(intentListaLikes);
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.rvMain);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new MascotaAdapter(ListaMascotas.mascotas);
        recyclerView.setAdapter(adapter);

    }


    /**
     * ##########################################
     * # PARA IMPLEMENTAR LOS MENUS DE OPCIONES #
     * #########################################
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menuAbout:
                Snackbar.make(this.getCurrentFocus(), getResources().getString(R.string.text_very_soon), Snackbar.LENGTH_LONG)
                        .setAction(getResources().getString(R.string.menu_about), new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Log.i("SNACKBAR_MUNU", "CLICK ABOUT");
                            }
                        })
                        .show();
                break;
            case R.id.menuSettings:
                Snackbar.make(this.getCurrentFocus(), getResources().getString(R.string.text_very_soon), Snackbar.LENGTH_LONG)
                        .show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * ##########################################
     * # PARA IMPLEMENTAR LOS MENUS DE CONTEXTO #
     * #########################################
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_contexto,menu);
        //MenuInflater menuCotext = new MenuInflater(this);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuAgregar:
                Snackbar.make(this.getCurrentFocus(), getResources().getString(R.string.text_very_soon), Snackbar.LENGTH_LONG)
                        .setAction(getResources().getString(R.string.menu_add_pet), new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Log.i("SNACKBAR_MUNU", "CLICK AGREGAR");
                            }
                        })
                        .show();
                break;
        }
        return super.onContextItemSelected(item);
    }

}

