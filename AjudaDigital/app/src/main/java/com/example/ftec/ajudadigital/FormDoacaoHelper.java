package com.example.ftec.ajudadigital;

import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RatingBar;

import com.example.ftec.ajudadigital.modelo.Doacao;

/**
 * Created by tiago on 06/11/17.
 */

public class FormDoacaoHelper {

    private final EditText campoNomeItem;
    private final EditText campoData;
    private final EditText campoQuantidade;
    private Doacao doacao;

    public FormDoacaoHelper(FormDoacaoActivity activity){

        doacao = new Doacao();
        campoNomeItem = (EditText) activity.findViewById(R.id.formdoacao_item);
        campoData = (EditText) activity.findViewById(R.id.formdoacao_data);
        campoQuantidade = (EditText)activity.findViewById(R.id.formdoacao_quantidade);

    }

    public Doacao pegaDoacao(){

        doacao.setNome_item(campoNomeItem.getText().toString());
        doacao.setData(campoData.getText().toString());
        doacao.setQuantidade( Integer.parseInt(campoQuantidade.getText().toString()));


        return doacao;
    }

    public void preencheFormulario(Doacao doacao) {

        campoNomeItem.setText(doacao.getNome_item());
        campoData.setText(doacao.getData());
        campoQuantidade.setText(doacao.getQuantidade().toString());

        this.doacao = doacao;

    }

    public void limpaFormulario(){

        campoNomeItem.setText(null);
        campoData.setText(null);
        campoQuantidade.setText(null);

    }


}
