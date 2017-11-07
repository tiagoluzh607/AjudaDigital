package com.example.ftec.ajudadigital;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class AfinidadeActivity extends AppCompatActivity {


    private Spinner spinnerOpcoes;
    private ArrayAdapter<String> afinidadesOpcoes;
    private ArrayAdapter<String> afinidadesSelecionadas;
    private ListView listaAfinidades;
    private Button botao_inserir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afinidade);


        listaAfinidades =(ListView) findViewById(R.id.formvoluntario_lista_afinidades);
        botao_inserir = (Button) findViewById(R.id.formvoluntario_inserir);

        spinnerOpcoes =(Spinner) findViewById(R.id.formvoluntario_spinner_afinidade);

        afinidadesOpcoes = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item);
        afinidadesOpcoes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOpcoes.setAdapter(afinidadesOpcoes);

        afinidadesOpcoes.add("Refugiados");
        afinidadesOpcoes.add("Crianças vítimas de abuso");
        afinidadesOpcoes.add("Pessoas em situação de rua");
        afinidadesOpcoes.add("Mulheres vítimas de violência");
        afinidadesOpcoes.add("Crianças desaparecidas");
        afinidadesOpcoes.add("Animais abandonados");
        afinidadesOpcoes.add("Crianças e adolescentes fora da escola");
        afinidadesOpcoes.add("Idosos");
        afinidadesOpcoes.add("Pessoas com deficiência");
        afinidadesOpcoes.add("Direitos Humanos");

        afinidadesSelecionadas = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item);
        listaAfinidades.setAdapter(afinidadesSelecionadas);


        botao_inserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(AfinidadeActivity.this, ""+spinnerOpcoes.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
