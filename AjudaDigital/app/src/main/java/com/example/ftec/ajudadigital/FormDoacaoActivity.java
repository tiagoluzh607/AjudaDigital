package com.example.ftec.ajudadigital;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.ftec.ajudadigital.dao.DoacaoDao;
import com.example.ftec.ajudadigital.modelo.Doacao;

public class FormDoacaoActivity extends AppCompatActivity {

    private FormDoacaoHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_doacao);

        helper = new FormDoacaoHelper(this);

        //Pegando o modelo passado como parâmetro

        Intent intent = getIntent();
        Doacao doacao = (Doacao) intent.getSerializableExtra("doacao");

        //Verificando se é novo registro ou esta vindo para edição
        if (doacao != null){
            helper.preencheFormulario(doacao);
        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //Usado para transformar um xml em uma view desenhavel na tela Inflater
        MenuInflater inflater = getMenuInflater();
        //Infla e coloca dentro do item de menu
        inflater.inflate(R.menu.menu_formulario, menu);


        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        //Verificando qual item de menu o usuario selecionou
        switch (item.getItemId()){

            case R.id.menu_formulario_ok:

                //Pegando a Doacao da Tela
                Doacao doacao = helper.pegaDoacao();

                Toast.makeText(FormDoacaoActivity.this, "Registro Salvo com Sucesso!", Toast.LENGTH_SHORT ).show();


                //Salvando Aluno no Banco de dados
                DoacaoDao dao = new DoacaoDao(this);

                //Verificando se o botão irá alterar ou irá incluir um registro novo
                if(doacao.getId() != null){
                    dao.update(doacao);
                    finish();
                }
                else{
                    dao.insert(doacao);
                    helper.limpaFormulario();
                }

                dao.close();

                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
