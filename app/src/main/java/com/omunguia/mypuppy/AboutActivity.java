package com.omunguia.mypuppy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);


        Toolbar toolbar = (Toolbar) findViewById(R.id.actionBarPuppy);
        setSupportActionBar(toolbar);

        //Agregar texto
        TextView textViewTitulo = (TextView)findViewById(R.id.tvTituloActionBar);
        textViewTitulo.setText(getString(R.string.app_name_about));

        //para activar el button back
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Ocultar la estrella
        ImageView imageViewStar = (ImageView)findViewById(R.id.myPuppyLikes);
        imageViewStar.setVisibility(View.INVISIBLE);
        imageViewStar.refreshDrawableState();
    }
}
