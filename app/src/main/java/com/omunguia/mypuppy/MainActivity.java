package com.omunguia.mypuppy;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

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
                Intent intentListaLikes = new Intent(MainActivity.this,ListadoMascotasActivity.class);
                startActivity(intentListaLikes);
            }
        });
    }
}

