package com.example.ftec.ajudadigital.modelo;

import java.io.Serializable;

/**
 * Created by tiago on 06/11/17.
 */

public class Doacao implements Serializable {


    private Long id;
    private String nome_item;
    private Integer quantidade;
    private String data;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome_item() {
        return nome_item;
    }

    public void setNome_item(String nome_item) {
        this.nome_item = nome_item;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }





    @Override
    public String toString() {

        return getData()+"  "+getNome_item()+"     "+getQuantidade()+"Un";

    }



}
