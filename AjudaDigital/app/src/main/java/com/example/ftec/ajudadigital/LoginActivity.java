package com.example.ftec.ajudadigital;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        //Botao Entrar
        Button botao_entrar = (Button) findViewById(R.id.login_botao_entrar);
        botao_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent exibeCampanha = new Intent(LoginActivity.this, CampanhaActivity.class);
                startActivity(exibeCampanha);
                finish();
            }
        });

        //Botao Cadastrar
        Button botao_cadastrar = (Button) findViewById(R.id.login_botao_cadastrar);
        botao_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent exibeFormVoluntario = new Intent(LoginActivity.this, FormVoluntarioActivity.class);
                startActivity(exibeFormVoluntario);
            }
        });



    }
}
