package com.omunguia.mypuppy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by omunguia on 02/05/2016.
 */
public class DetalleMascotaActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mascota_detalle);

        //para soporte de actionbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.actionBarPuppy);
        setSupportActionBar(toolbar);

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
    }
}

