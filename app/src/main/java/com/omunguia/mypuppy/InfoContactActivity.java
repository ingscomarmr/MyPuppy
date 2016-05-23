package com.omunguia.mypuppy;

import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.omunguia.mypuppy.utils.Email;

import java.util.ArrayList;
import java.util.List;

public class InfoContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_contact);

        Toolbar toolbar = (Toolbar) findViewById(R.id.actionBarPuppy);
        setSupportActionBar(toolbar);

        //Agregar texto
        TextView textViewTitulo = (TextView)findViewById(R.id.tvTituloActionBar);
        textViewTitulo.setText(getString(R.string.app_name_contacto));

        //para activar el button back
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Ocultar la estrella
        ImageView imageViewStar = (ImageView)findViewById(R.id.myPuppyLikes);
        imageViewStar.setVisibility(View.INVISIBLE);
        imageViewStar.refreshDrawableState();
    }

    public void sendEmail(View view){
        TextInputEditText name = (TextInputEditText)findViewById(R.id.etName);
        TextInputEditText email = (TextInputEditText)findViewById(R.id.etEmail);
        TextInputEditText message = (TextInputEditText)findViewById(R.id.etMessage);

        String nameStr = name.getText().toString();
        String emailStr = email.getText().toString();
        String messageStr = message.getText().toString();

        if(nameStr == null || emailStr == null || messageStr == null){
            Snackbar.make(this.getCurrentFocus(), getResources().getString(R.string.text_empty_fields_message), Snackbar.LENGTH_LONG).show();
        }

        try{
            String messageBody = "<h3>Correo de contacto</h3><br/><h5>"+nameStr+"("+emailStr+")</h5><br/>"
                    + "<br/><p>" + messageStr+"</p><br/>";

          Email.sendEmail("ingscomarmr@gmail.com;" + emailStr,"Contacto MyPuppy",messageStr);


            Snackbar.make(this.getCurrentFocus(), getResources().getString(R.string.text_send_email), Snackbar.LENGTH_LONG)
                    .setAction(getResources().getString(R.string.text_go_to_back), new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Log.i("Regresar atras", "CLICK AGREGAR");
                            onBackPressed();
                        }
                    })
                    .show();

        }catch (Exception e){
            Log.i("#ERROR EN MAIL",e.getMessage());
            Snackbar.make(this.getCurrentFocus(), getString(R.string.text_global_exception), Snackbar.LENGTH_LONG).show();
        }


    }
}
