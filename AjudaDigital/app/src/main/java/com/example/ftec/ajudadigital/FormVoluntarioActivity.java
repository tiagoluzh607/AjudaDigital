package com.example.ftec.ajudadigital;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class FormVoluntarioActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_voluntario);






    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //Usado para transformar um xml em uma view desenhavel na tela Inflater
        MenuInflater inflater = getMenuInflater();
        //Infla e coloca dentro do item de menu
        inflater.inflate(R.menu.menu_formulario, menu);


        return super.onCreateOptionsMenu(menu);
    }

}
